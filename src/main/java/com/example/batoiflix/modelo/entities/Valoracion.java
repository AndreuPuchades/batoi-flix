package com.example.batoiflix.modelo.entities;

public class Valoracion {
    /**
     * Esta entidad de valoracion
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
   private Produccion produccion;
   private Usuario usuario;
   private String comentario;
   private int valoracion;
    /**
     * Este es uno de los constructores de valoraciones.
     * Recibe los siguientes parámetros:
     *
     * @param produccion La produccion
     * @param usuario El usuario
     * @param comentario El comentario asociado
     * @param valoracion La valoracion asociada
     *
     */
    public Valoracion(Produccion produccion, Usuario usuario, String comentario, int valoracion) {
        this.produccion = produccion;
        this.usuario = usuario;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getComentario() {
        return comentario;
    }


    public int getValoracion() {
        return valoracion;
    }
}
