package com.example.batoiflix.modelo.entities;

public class DisponiblidadPlataforma {
    /**
     * Es la entidad que conecta la produccion y la plataforma
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int idProduccion;
    private int idPlataforma;
    /**
     * Este es el constructor de la clase DisponibilidadPlataforma.
     * Recibe los siguientes parámetros:
     *
     * @param idplataforma El numero identificativo de la plataforma
     * @param idProduccion El numero identificativo de la produccion
     */

    public DisponiblidadPlataforma(int idProduccion, int idplataforma) {
        this.idProduccion = idProduccion;
        this.idPlataforma = idplataforma;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public int getIdProduccion() {
        return idProduccion;
    }
}