package com.example.batoiflix.modelo.controladores;

import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.repositorios.RepositorioProduccions;
import com.example.batoiflix.modelo.repositorios.RepositorioValoraciones;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValoracionesController {
    private final String LOGGED_USER_KEY  = "usuarioLogged";

    @Autowired
    RepositorioProduccions repositorioProduccions;
    @Autowired
    RepositorioValoraciones repositorioValoraciones;

    @GetMapping("/lista-valoraciones")
    public String vistaValoraciones(Model model, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);

        if(usuario == null){
            return "redirect:/login";
        } else {
            model.addAttribute("valoraciones", repositorioValoraciones.findValoracionesByIdUsuario(usuario));
            model.addAttribute("usuario", usuario);
            return "vista-valoraciones";
        }
    }

    @GetMapping("/eliminar-valoracion")
    public String eliminarValoracion(@RequestParam int idProduccion, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);

        if(usuario != null){
            repositorioValoraciones.removeValoracion(idProduccion, usuario.getCodigo());
            return "redirect:/lista-valoraciones";
        } else {
            return "redirect:/login";
        }
    }
}