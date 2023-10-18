package com.example.batoiflix.modelo.entities;

public class Director {
    /**
     * Es la entidad que hace referencia al director que dirige una produccion
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int id;
    private String nombre;
    /**
     * Este es uno de los constructores de la clase Director.
     * Recibe los siguientes parámetros:
     *
     * @param id El numero identificativo del director
     * @param nombre El nombre del director
     */
    public Director(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    /**
     * Este es uno de los constructores de la clase Director, este contructor pone por defecto id a -1
     * Recibe los siguientes parámetros:
     *
     * @param nombre El nombre del director
     */
    public Director(String nombre) {
        this.id = -1;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
}