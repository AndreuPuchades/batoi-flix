package com.example.batoiflix.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class PasswordHelper {
    /**
     * Esta clase es la encargada de encriptar y comprobar las contraseñas
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */

    /**
     * Genera el sha1 de la contraseña
     *
     * @param password la contraseña que introduce el usuario al registrarse
     * @return devulve la contraseña en sha1
     */
    public String generateSha1(String password){
        return DigestUtils.sha1Hex(password);
    }
    /**
     * Comprueba que la contraseña introducida por el usuario y el hash que hay en la base de datos es el mismo
     *
     * @param password la contraseña que introduce el usuario al iniciar sesion
     * @param hashCode el hash de la contraseña asignada a ese usuario que hay en la base de datos
     * @return devuelve true o false si es igual o no
     */
    public boolean verify(String password, String hashCode){
        return generateSha1(password).equals(hashCode);
    }
}
