package com.example.batoiflix.modelo.repositorios;

import com.example.batoiflix.modelo.dao.UsuarioDAO;
import com.example.batoiflix.modelo.dao.interfaces.UsuarioDAOInterface;
import com.example.batoiflix.modelo.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoriosUsuarios {
    private UsuarioDAOInterface usuarioDAOInterface;

    public RepositoriosUsuarios(@Autowired UsuarioDAO usuarioDAO){
        this.usuarioDAOInterface = usuarioDAO;
    }

    public boolean save(Usuario usuario){
        return usuarioDAOInterface.save(usuario);
    }

    public Usuario findByEmail(String email){
        return usuarioDAOInterface.findByEmail(email);
    }

    public Usuario findByUsuario(String buscador){
        return usuarioDAOInterface.findByEmailWithContrasenya(buscador);
    }
}