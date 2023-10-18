package com.example.batoiflix.modelo.repositorios;

import com.example.batoiflix.modelo.dao.*;
import com.example.batoiflix.modelo.dao.interfaces.*;
import com.example.batoiflix.modelo.entities.*;
import com.example.batoiflix.modelo.enums.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class RepositorioProduccions {
    private ProduccionDAOInterface produccionDAOInterface;
    private FavoritosDAOInterface favoritosDAOInterface;
    private TemporadaDAOInterface temporadaDAOInterface;
    private VisualizacionDAOInterface visualizacionDAOInterface;
    private DisponibilidadPlataformaDAOInterface disponibilidadPlataformaDAOInterface;
    private PlataformaDAOInterface plataformaDAOInterface;

    public RepositorioProduccions(@Autowired ProduccionDAO produccionDAO, @Autowired FavoritosDAO favoritosDAO,
                                  @Autowired TemporadaDAO temporadaDAO, @Autowired VisualizacionDAO visualizacionDAO,
                                  @Autowired DisponibilidadPlataformaDAO disponibilidadPlataformaDAO,
                                  @Autowired PlataformaDAO plataformaDAO) {
        this.produccionDAOInterface = produccionDAO;
        this.favoritosDAOInterface = favoritosDAO;
        this.temporadaDAOInterface = temporadaDAO;
        this.visualizacionDAOInterface = visualizacionDAO;
        this.disponibilidadPlataformaDAOInterface = disponibilidadPlataformaDAO;
        this.plataformaDAOInterface = plataformaDAO;
    }

    public void save(Produccion produccion){
        if(!produccionDAOInterface.save(produccion)){
            throw new RuntimeException("No se ha guardado la produccion");
        }
    }

    public Produccion getProduccionWithExtras(int idProduccion){
        Produccion produccion = produccionDAOInterface.getByIdProduccion(idProduccion);
        ArrayList <Plataforma> plataformas = disponibilidadPlataformaDAOInterface.plataformasDisponibles(idProduccion);
        for (Plataforma item: plataformas) {
            Plataforma plataforma = plataformaDAOInterface.getById(item.getCodigo());
            item.setWeb(plataforma.getWeb());
            item.setIcono(plataforma.getIcono());
        }
        produccion.setPlataformas(plataformas);
        if (produccion.getClass().equals(Serie.class)){
            ArrayList<Temporada> temporadas = findAllWithSerie(produccion.getId());
            Serie serie = (Serie) produccion;
            serie.setTemporadas(temporadas);
            return serie;
        }
        return produccion;
    }


    private ArrayList<Temporada> findAllWithSerie(int idSerie){
        ArrayList<Temporada> temporadas = temporadaDAOInterface.getByIdSerie(idSerie);
        Serie serie =(Serie) produccionDAOInterface.getByIdProduccion(idSerie);
        for (Temporada temporada: temporadas) {
            temporada.setSerie(serie);
        }
        return temporadas;
    }
    public ArrayList<Produccion> findAllMasRecomendadas(){
        return produccionDAOInterface.findAllRecomendadas();
    }


    public ArrayList<Produccion> findAllSeries(){
        ArrayList<Produccion> produccionsAll = produccionDAOInterface.findAll();
        ArrayList<Produccion> produccionsNews = new ArrayList<>();

        for (int i = 0; i < produccionsAll.size(); i++) {
            if(produccionsAll.get(i).getClass().getSimpleName().equalsIgnoreCase("serie")){
                produccionsNews.add(produccionsAll.get(i));
            }
        }

        return produccionsNews;
    }

    public ArrayList<Produccion> getPeliculasParecidas(Produccion produccion){
        ArrayList<Genero> generos = produccion.getGenero();
        ArrayList<Produccion> produccionsAll = findAllWithExtras();
        ArrayList<Produccion> produccionsNew = new ArrayList<>();

        int contador = 0;
        for (int i = 0; i < produccionsAll.size(); i++) {
            for (int j = 0; j < generos.size(); j++) {
                for (int k = 0; k < produccionsAll.get(i).getGenero().size(); k++) {
                    if(produccionsAll.get(i).getGenero().get(k).equals(generos.get(j))){
                        contador++;
                    }
                }
            }

            if (produccionsAll.get(i).getId() != produccion.getId() && contador >= 1){
                produccionsNew.add(produccionsAll.get(i));
            }

            contador = 0;
        }

        return produccionsNew;
    }

    public ArrayList<Produccion> findProduccionesByIdUsuario(Usuario usuario){
        ArrayList<Favorito> favoritos = favoritosDAOInterface.findByIdUsuario(usuario);
        ArrayList<Produccion> produccions = new ArrayList<>();

        for (int i = 0; i < favoritos.size(); i++) {
            produccions.add(produccionDAOInterface.getByIdProduccion(favoritos.get(i).getProduccion().getId()));
        }

        return produccions;
    }

    public ArrayList<Produccion> findAllWithExtras(){
        return produccionDAOInterface.findAll();
    }

    public PaginateResult findAllWithTitle(String busqueda,int page){
        return produccionDAOInterface.getByTitlePagined(busqueda,page,15);
    }

    public PaginateResult paginatedPeliculas(int page){
        return produccionDAOInterface.findAllPelicula(page,15);
    }
    public PaginateResult paginatedProduccionesOrden(int page,String order){
        return produccionDAOInterface.findAllOrder(page,15,order);
    }

    public PaginateResult findAllWithGenere(String genero,int page){
        return produccionDAOInterface.getByGenerePagined(genero,page,15);
    }

    public PaginateResult paginatedSeries(int page){
        return produccionDAOInterface.findAllSeries(page,15);
    }
    public PaginateResult paginatedWithGenereAnTitle(String genero, String titulo, int page){
        return produccionDAOInterface.getByGenereAndTitlePagined(genero,titulo,page,15);
    }

    public Temporada getByIdTemporada(int idSerie, int idTemporada){
        Temporada temporada = temporadaDAOInterface.getById(idSerie, idTemporada);
        Serie serie = (Serie) getProduccionWithExtras(idSerie);
        temporada.setSerie(serie);
        return temporada;
    }

    public boolean addVisualizacion(Usuario usuario, Produccion produccion){
        return visualizacionDAOInterface.save(usuario,produccion);
    }
}