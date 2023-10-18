package com.example.batoiflix.modelo.entities;

public class Temporada {
    /**
     * Esta entidad de la temporada
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int idTemporada;
    private int idSerie;
    private Serie serie;
    private int anyoLanzamiento;
    private String guion;
    private int capitulos;
    /**
     * Este es uno de los constructores de temporada.
     * Recibe los siguientes parámetros:
     *
     * @param idSerie El numero identificativo de la serie
     * @param idTemporada El numero identificativo de la temporada
     * @param anyoLanzamiento el anyo en la que se lanzo
     * @param guion es el guion de la temporada
     * @param capitulos el numero de capitulos de la temporada
     *
     */
    public Temporada(int idSerie, int idTemporada, int anyoLanzamiento, String guion, int capitulos) {
        this.idSerie = idSerie;
        this.idTemporada = idTemporada;
        this.anyoLanzamiento = anyoLanzamiento;
        this.guion = guion;
        this.capitulos = capitulos;
    }
    /**
     * Este es uno de los constructores de temporada.
     * Recibe los siguientes parámetros:
     *
     * @param serie Es la serie a la que pertenece
     * @param idTemporada El numero identificativo de la temporada
     * @param anyoLanzamiento el anyo en la que se lanzo
     * @param guion es el guion de la temporada
     * @param capitulos el numero de capitulos de la temporada
     *
     */
    public Temporada(Serie serie, int idTemporada, int anyoLanzamiento, String guion, int capitulos) {
        this.serie = serie;
        this.idTemporada = idTemporada;
        this.anyoLanzamiento = anyoLanzamiento;
        this.guion = guion;
        this.capitulos = capitulos;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public Serie getSerie() {
        return serie;
    }

    public int getAnyoLanzamiento() {
        return anyoLanzamiento;
    }

    public String getGuion() {
        return guion;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getTemporadaFormat(){
        return "Temporada " + idTemporada;
    }
}
