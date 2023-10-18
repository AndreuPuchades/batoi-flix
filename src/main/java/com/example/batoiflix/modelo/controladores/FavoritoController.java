package com.example.batoiflix.modelo.controladores;

import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.repositorios.RepositorioFavorito;
import com.example.batoiflix.modelo.repositorios.RepositorioProduccions;
import com.example.batoiflix.modelo.repositorios.RepositorioValoraciones;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.HashMap;

@Controller
public class FavoritoController {
    private final String LOGGED_USER_KEY  = "usuarioLogged";

    @Autowired
    private RepositorioProduccions repositorioProduccions;
    @Autowired
    private RepositorioFavorito repositorioFavorito;

    @GetMapping("/favorito")
    public String anyadirFavorito(@RequestParam int idProduccion, HttpSession httpSession, RedirectAttributes redirectAttributes){
        Usuario usuarioLogged = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);

        if(usuarioLogged != null){
            Produccion produccion = repositorioProduccions.getProduccionWithExtras(idProduccion);
            boolean hayFavorito = repositorioFavorito.estaEnFavorito(produccion, usuarioLogged);

            if(hayFavorito){
                repositorioFavorito.removeFavorito(produccion, usuarioLogged);
            } else {
                repositorioFavorito.saveFavorito(usuarioLogged, repositorioProduccions.getProduccionWithExtras(idProduccion));
            }
        } else {
            HashMap<String, String> errors = new HashMap<>();
            errors.put("Alerta","Debes registrarte o iniciar sesión para guardar tus favoritos");
            redirectAttributes.addFlashAttribute("errorsFavoritos",errors);
        }

        return "redirect:/detalles-produccion?idProduccion=" + idProduccion;
    }

    @GetMapping("/eliminar-favorito")
    public String eliminarFavorito(@RequestParam int idProduccion, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);

        if(usuario != null){
            repositorioFavorito.removeFavorito(repositorioProduccions.getProduccionWithExtras(idProduccion), usuario);
            return "redirect:/lista-favoritos";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/lista-favoritos")
    public String vistaFavoritos(Model model, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);

        if(usuario == null){
            return "redirect:/login";
        } else {
            model.addAttribute("producciones", repositorioProduccions.findProduccionesByIdUsuario(usuario));
            model.addAttribute("usuario", usuario);
            return "vista-favoritos";
        }
    }
}
