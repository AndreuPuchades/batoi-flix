package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface UsuarioDAOInterface {
    ArrayList<Usuario> findAll();
    boolean save(Usuario usuario);
    Usuario getByID(int id);
    Usuario getByEmail(String email);
    Usuario findByName(String nombre, String apellidos);
    Usuario findByEmail(String email);
    Usuario findByEmailWithContrasenya(String email);
}