package com.example.batoiflix.modelo.entities;

public class Actor {
    /**
     * Es la entidad que hace referencia al actor de la produccion
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int codigo;
    private String nombre;
    /**
     * Este es uno de los constructores de la clase Actor.
     * Recibe los siguientes parámetros:
     *
     * @param codigo El numero identificativo del actor
     * @param nombre El nombre del actor
     */
    public Actor(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    /**
     * Este es uno de los constructores de la clase Actor, este contructor pone por defecto id a -1
     * Recibe los siguientes parámetros:
     *
     * @param nombre El nombre del actor
     */
    public Actor(String nombre){
        this.codigo = -1;
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
}