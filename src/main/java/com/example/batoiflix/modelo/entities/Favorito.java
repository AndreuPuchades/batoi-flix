package com.example.batoiflix.modelo.entities;

import com.example.batoiflix.modelo.dao.ProduccionDAO;

public class Favorito {
    /**
     * Es la entidad que conecta la produccion y el usuario cuando lo marac como favorito
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private Usuario usuario;
    private Produccion produccion;
    /**
     * Este es el constructor de la clase Favorito.
     * Recibe los siguientes parámetros:
     *
     * @param usuario Es el usuario
     * @param produccion Es la produccion
     */
    public Favorito(Usuario usuario, Produccion produccion) {
        this.usuario = usuario;
        this.produccion = produccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Produccion getProduccion() {
        return produccion;
    }
}