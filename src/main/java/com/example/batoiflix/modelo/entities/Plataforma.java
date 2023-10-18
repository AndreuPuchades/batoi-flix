package com.example.batoiflix.modelo.entities;

public class Plataforma {
    /**
     * Esta entidad de la plataforma
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int codigo;
    private String nombre;
    private String web;
    private String icono;
    /**
     * Este es uno de los constructores de plataforma.
     * Recibe los siguientes parámetros:
     *
     * @param codigo El numero identificativo de la produccion
     *
     */
    public Plataforma(int codigo) {
        this.codigo = codigo;
    }
    /**
     * Este es uno de los constructores de produccion.
     * Recibe los siguientes parámetros:
     *
     * @param codigo El numero identificativo de la produccion
     * @param nombre el nombre de la produccion
     * @param web es la web de la produccion
     * @param icono es el icono de la produccion
     *
     */
    public Plataforma(int codigo, String nombre, String web, String icono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.web = web;
        this.icono = icono;
    }
    /**
     * Este es uno de los constructores de produccion, tiene por defecto el numero de codigo a -1
     * Recibe los siguientes parámetros:
     *
     * @param nombre el nombre de la produccion
     *
     */
    public Plataforma(String nombre) {
        this.codigo = -1;
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Plataforma(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}