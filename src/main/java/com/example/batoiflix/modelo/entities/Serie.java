package com.example.batoiflix.modelo.entities;

import com.example.batoiflix.modelo.enums.Calificacion;
import com.example.batoiflix.modelo.enums.Genero;

import java.time.LocalDate;
import java.util.ArrayList;

public class Serie extends Produccion {
    /**
     * Esta entidad extiende de produccion y son las series, estas tiene una lista de temporadas
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private ArrayList<Temporada> temporadas;

    public Serie(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento, int duracion,
                 ArrayList<Genero> genero, Director director, ArrayList<Actor> actores, String guion, String portada,
                 Productor productor, String web, ArrayList<Temporada> temporadas, ArrayList<Plataforma> plataformas) {
        super(id, titulo, calificacion, fechaLanzamiento, duracion, genero, director, actores, guion, portada, productor, web,plataformas);
        this.temporadas = temporadas;
    }

    public Serie(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento, int duracion,
                 ArrayList<Genero> genero, Director director, ArrayList<Actor> actores, String guion, String portada,
                 Productor productor, String web, ArrayList<Plataforma> plataformas) {
        super(id, titulo, calificacion, fechaLanzamiento, duracion, genero, director, actores, guion, portada, productor, web,plataformas);
    }

    public Serie(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento, int duracion,
                 ArrayList<Genero> genero, Director director, ArrayList<Actor> actores, String guion, String portada,
                 Productor productor, String web) {
        super(id, titulo, calificacion, fechaLanzamiento, duracion, genero, director, actores, guion, portada, productor, web);
    }

    public void setTemporadas(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }
}