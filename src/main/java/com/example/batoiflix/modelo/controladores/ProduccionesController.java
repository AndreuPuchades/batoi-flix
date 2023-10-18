package com.example.batoiflix.modelo.controladores;

import com.example.batoiflix.modelo.entities.*;
import com.example.batoiflix.modelo.enums.Genero;
import com.example.batoiflix.modelo.repositorios.RepositorioFavorito;
import com.example.batoiflix.modelo.repositorios.RepositorioProduccions;
import com.example.batoiflix.modelo.repositorios.RepositorioValoraciones;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProduccionesController {
    private final String LOGGED_USER_KEY  = "usuarioLogged";

    @Autowired
    private RepositorioProduccions repositorioProduccions;
    @Autowired
    private RepositorioValoraciones repositorioValoraciones;
    @Autowired
    private RepositorioFavorito repositorioFavorito;

    @GetMapping("/detalles-produccion")
    public String detallesProduccion(@RequestParam int idProduccion, Model model, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);
        Produccion produccion = repositorioProduccions.getProduccionWithExtras(idProduccion);
        boolean esSerie = false;
        if (produccion instanceof Serie){
            esSerie = true;
            Serie serie = (Serie) produccion;
            model.addAttribute("serie",serie);
        }
        Valoracion valoracion = null;
        if(usuario != null){
            repositorioProduccions.addVisualizacion(usuario,produccion);
            boolean hayFavorito = repositorioFavorito.estaEnFavorito(produccion, usuario);
            valoracion = repositorioValoraciones.findValoracionesByIdUsuarioAndProduccion(usuario,produccion);
            model.addAttribute("favorito", hayFavorito);
        } else {
            model.addAttribute("favorito", false);
        }
        model.addAttribute("valoracion",valoracion);
        model.addAttribute("esSerie",esSerie);
        model.addAttribute("usuario", usuario);
        model.addAttribute("produccion", produccion);
        model.addAttribute("peliculas", repositorioProduccions.getPeliculasParecidas(produccion));
        return "detail-view";
    }

    @GetMapping("/detalles-temporada")
    public String detallesTemporada(@RequestParam int idSerie, @RequestParam int idTemporada, Model model, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);
        Produccion produccion = repositorioProduccions.getProduccionWithExtras(idSerie);
        Temporada temporada = repositorioProduccions.getByIdTemporada(idSerie, idTemporada);
        if(usuario != null){
            boolean hayFavorito = repositorioFavorito.estaEnFavorito(produccion, usuario);
            model.addAttribute("favorito", hayFavorito);
        } else {
            model.addAttribute("favorito", false);
        }
        model.addAttribute("temporada", temporada);
        model.addAttribute("usuario", usuario);
        model.addAttribute("produccion",produccion);
        model.addAttribute("series", repositorioProduccions.findAllSeries());
        return "detalles-temporada";
    }

    @PostMapping("/actualizar-produccion")
    public String actualizarProduccion(@RequestParam Map<String, String> params, HttpSession httpSession,
                                       RedirectAttributes redirectAttributes){
        Produccion produccion = repositorioProduccions.getProduccionWithExtras(Integer.parseInt(params.get("idProduccion")));
        String valoracion = params.get("valoracion");
        String mensaje = params.get("mensaje");
        Usuario usuarioLogged = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);
        HashMap<String,String> errors = new HashMap<>();
        if(usuarioLogged != null && !valoracion.equalsIgnoreCase("")){
            try {
                if(mensaje == null){
                    repositorioValoraciones.saveValoracion(new Valoracion(produccion, usuarioLogged, "", Integer.parseInt(valoracion)));
                } else {
                    repositorioValoraciones.saveValoracion(new Valoracion(produccion, usuarioLogged, mensaje, Integer.parseInt(valoracion)));
                }
            } catch (RuntimeException e){
                if (e.getMessage().contains("Duplicate entry")){
                    errors.put("Error","Esta producción ya ha sido valorada");
                    redirectAttributes.addFlashAttribute("errors",errors);
                }
            }
            return "redirect:/detalles-produccion?idProduccion=" + produccion.getId();
        }
        errors.put("Alerta","Necesitas haber iniciado sesión para poder comentar o valorar la producción");
        redirectAttributes.addFlashAttribute("errors",errors);
        return "redirect:/detalles-produccion?idProduccion=" + produccion.getId();
    }

    @GetMapping("/busqueda")
    public String busquedaAction(@RequestParam(required = false, defaultValue = "") String buscador,
                                 @RequestParam(required = false, defaultValue = "") String genero,
                                 Model model, HttpSession httpSession,
                                 @RequestParam(defaultValue = "", required = false) String type,
                                 @RequestParam(defaultValue = "1") int page) {
        PaginateResult paginateResult = null;
        if (! type.equals("")){
            if (type.equals("pelis")){
                    paginateResult = repositorioProduccions.paginatedPeliculas(page);
            } else if (type.equals("series")) {
                    paginateResult = repositorioProduccions.paginatedSeries(page);

            }
        } else if (genero.equals("")) {
                paginateResult = repositorioProduccions.findAllWithTitle(buscador,page);

        }else if(buscador.equals("")){
                paginateResult = repositorioProduccions.findAllWithGenere(genero,page);

        }else if (!buscador.equals("") && !genero.equals("")){
                paginateResult = repositorioProduccions.paginatedWithGenereAnTitle(genero,buscador,page);
        }

        model.addAttribute("usuario", httpSession.getAttribute(LOGGED_USER_KEY));
        model.addAttribute("boton",paginateResult.isQuedanMas());
        model.addAttribute("producciones",paginateResult.getProduccions());
        model.addAttribute("page",page);
        return "vista-busqueda";
    }

    @GetMapping("/ordenar")
    public String ordenarProducciones(HttpSession httpSession,Model model,@RequestParam String fecha,@RequestParam(defaultValue = "1") int page){
        model.addAttribute("usuario", httpSession.getAttribute(LOGGED_USER_KEY));
        PaginateResult paginateResult = repositorioProduccions.paginatedProduccionesOrden(page,fecha);
        model.addAttribute("boton",paginateResult.isQuedanMas());
        model.addAttribute("producciones",paginateResult.getProduccions());
        model.addAttribute("page",page);
        return "vista-busqueda";
    }

    @GetMapping("/")
    public String vistaPrincipal(HttpSession httpSession, Model model, @RequestParam(defaultValue = "1") int pagePel,
                                 @RequestParam(defaultValue = "1") int pageSer){
        model.addAttribute("usuario", httpSession.getAttribute(LOGGED_USER_KEY));
        model.addAttribute("recomendadas", repositorioProduccions.findAllMasRecomendadas());
        PaginateResult peliculas = repositorioProduccions.paginatedPeliculas(pagePel);
        PaginateResult series = repositorioProduccions.paginatedSeries(pageSer);
        model.addAttribute("masPelis",peliculas.isQuedanMas());
        model.addAttribute("masSeries",series.isQuedanMas());
        model.addAttribute("numPagPel",pagePel);
        model.addAttribute("numPagSer",pageSer);
        model.addAttribute("peliculas", peliculas.getProduccions());
        model.addAttribute("series", series.getProduccions());
        model.addAttribute("generos",getGeneros());
        return "vista-principal";
    }
    private ArrayList<Genero> getGeneros(){
        Genero[] allGeneros = {
                Genero.ADVENTURE, Genero.ACTION, Genero.ANIMATION, Genero.BIOGRAPHY, Genero.FANTASY,
                Genero.DRAMA, Genero.CRIME, Genero.FAMILY, Genero.HORROR, Genero.HISTORY, Genero.MUSICAL, Genero.SPORT,
                Genero.COMEDY, Genero.SCI_FI, Genero.MISTERY, Genero.WESTERN, Genero.ROMANCE, Genero.THRILLER,
        };
        ArrayList<Genero> generos = new ArrayList<>();
        for (Genero item:allGeneros ) {
            generos.add(item);
        }
        return generos;
    }
}