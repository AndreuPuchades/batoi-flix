package com.example.batoiflix.modelo.entities;

public class Productor {
    /**
     * Es la entidad que hace referencia al productor de la produccion
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int id;
    private String nombre;
    /**
     * Este es uno de los constructores de la clase Productor.
     * Recibe los siguientes parámetros:
     *
     * @param id El numero identificativo del productor
     * @param nombre El nombre del productor
     */
    public Productor(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }
    /**
     * Este es uno de los constructores de la clase Productor, por defecto pone el id a -1
     * Recibe los siguientes parámetros:
     *
     * @param nombre El nombre del productor
     */
    public Productor(String nombre) {
        this.nombre = nombre;
        this.id = -1;
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