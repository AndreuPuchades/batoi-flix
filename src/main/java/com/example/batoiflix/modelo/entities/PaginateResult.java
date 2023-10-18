package com.example.batoiflix.modelo.entities;

import java.util.ArrayList;

public class PaginateResult {
    /**
     * Es la entidad que permite la paginacion de las consultas
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private ArrayList<Produccion> produccions;
    private boolean quedanMas;
    private int numPag;
    /**
     * Este es el constructor de la clase PaginateResult.
     * Recibe los siguientes parámetros:
     *
     * @param produccions son las producciones que contiene la consulta paginada
     * @param quedanMas Es el boolano que indica si hay mas registros
     * @param numPag Es el numero de pagina
     */
    public PaginateResult(ArrayList<Produccion> produccions, boolean quedanMas, int numPag) {
        this.produccions = produccions;
        this.quedanMas = quedanMas;
        this.numPag = numPag;
    }

    public ArrayList<Produccion> getProduccions() {
        return produccions;
    }

    public boolean isQuedanMas() {
        return quedanMas;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setProduccions(ArrayList<Produccion> produccions) {
        this.produccions = produccions;
    }

    public void setQuedanMas(boolean quedanMas) {
        this.quedanMas = quedanMas;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
}
