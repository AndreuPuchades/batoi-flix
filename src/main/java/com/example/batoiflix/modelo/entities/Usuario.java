package com.example.batoiflix.modelo.entities;

import com.example.batoiflix.modelo.enums.TipoUsuario;

public class Usuario {
    /**
     * Esta entidad del usuario
     *
     *
     * @author Arantxa, Cintia, Andreu, Ruben
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private int codigo;
    private String nombre;
    private String apellidos;
    private String email;
    private String contrasenyaHash;
    private TipoUsuario tipoUsuario;
    /**
     * Este es uno de los constructores de usuario.
     * Recibe los siguientes parámetros:
     *
     * @param codigo El numero identificativo del usuario
     * @param nombre El nombre del usuario
     * @param apellidos Los apellidos del usuario
     * @param email El email del usuario
     * @param contrasenyaHash El hash de la contraseña del usuario
     * @param tipoUsuario El tipo de usuario
     *
     */
    public Usuario(int codigo, String nombre, String apellidos, String email, String contrasenyaHash, TipoUsuario tipoUsuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasenyaHash = contrasenyaHash;
        this.tipoUsuario = tipoUsuario;
    }
    /**
     * Este es uno de los constructores de usuario, por defecto el codigo es -1
     * Recibe los siguientes parámetros:
     *
     * @param nombre El nombre del usuario
     * @param apellidos Los apellidos del usuario
     * @param email El email del usuario
     * @param contrasenyaHash El hash de la contraseña del usuario
     * @param tipoUsuario El tipo de usuario
     *
     */
    public Usuario(String nombre, String apellidos, String email, String contrasenyaHash, TipoUsuario tipoUsuario) {
        this.codigo = -1;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasenyaHash = contrasenyaHash;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenyaHash() {
        return contrasenyaHash;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setContrasenyaHash(String contrasenyaHash) {
        this.contrasenyaHash = contrasenyaHash;
    }
}