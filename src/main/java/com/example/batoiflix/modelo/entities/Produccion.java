package com.example.batoiflix.modelo.entities;

import com.example.batoiflix.modelo.enums.Calificacion;
import com.example.batoiflix.modelo.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Produccion {
    /**
     * Esta entidad es abstracta y de ella extienden las series y las peliculas
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int id;
    private String titulo;
    private Calificacion calificacion;
    private LocalDate fechaLanzamiento;
    private int duracion;
    private ArrayList<Genero> genero;
    private Director director;
    private ArrayList<Actor> actores;
    private String guion;
    private String portada;
    private Productor productor;
    private String web;
    private ArrayList<Plataforma> plataformas;
    /**
     * Este es uno de los constructores de produccion.
     * Recibe los siguientes parámetros:
     *
     * @param id El numero identificativo de la produccion
     * @param titulo el nombre de la produccion
     * @param calificacion es la colificacion de la produccion
     * @param fechaLanzamiento la fecha en la que se estreno
     * @param duracion es la duracion e la produccion
     * @param genero los generos de la produccion
     * @param director el director de la produccion
     * @param actores los actores de la produccion
     * @param guion el guion de la produccion
     * @param portada la portada de la produccion
     * @param productor el productor de la produccion
     * @param web la web de la produccion
     * @param plataformas las plataformas de la produccion
     *
     */
    public Produccion(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento, int duracion,
                      ArrayList<Genero> genero, Director director, ArrayList<Actor> actores, String guion, String portada,
                      Productor productor, String web, ArrayList<Plataforma> plataformas) {
        this.id = id;
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
        this.actores = actores;
        this.guion = guion;
        this.portada = portada;
        this.productor = productor;
        this.web = web;
        this.plataformas = plataformas;
    }
    /**
     * Este es uno de los constructores de produccion.
     * Recibe los siguientes parámetros:
     *
     * @param id El numero identificativo de la produccion
     * @param titulo el nombre de la produccion
     * @param calificacion es la colificacion de la produccion
     * @param fechaLanzamiento la fecha en la que se estreno
     * @param duracion es la duracion e la produccion
     * @param genero los generos de la produccion
     * @param director el director de la produccion
     * @param actores los actores de la produccion
     * @param guion el guion de la produccion
     * @param portada la portada de la produccion
     * @param productor el productor de la produccion
     * @param web la web de la produccion
     *
     */
    public Produccion(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento, int duracion,
                      ArrayList<Genero> genero, Director director, ArrayList<Actor> actores, String guion, String portada,
                      Productor productor, String web) {
        this.id = id;
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
        this.actores = actores;
        this.guion = guion;
        this.portada = portada;
        this.productor = productor;
        this.web = web;
    }

    public Produccion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getFechaLanzamientoString(){
        return fechaLanzamiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public int getDuracion() {
        return duracion;
    }

    public ArrayList<Genero> getGenero() {
        return genero;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public String getGuion() {
        return guion;
    }

    public String getPortada() {
        return portada;
    }

    public Productor getProductor() {
        return productor;
    }

    public String getWeb() {
        return web;
    }

    public ArrayList<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setPlataformas(ArrayList<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }
}