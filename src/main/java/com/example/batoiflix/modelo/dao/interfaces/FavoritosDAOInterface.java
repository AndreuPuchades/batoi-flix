package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.Favorito;
import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface FavoritosDAOInterface {
    boolean insertFavoritos(Usuario usuario, Produccion produccion);
    boolean estaEnFavorito(Produccion produccion, Usuario usuario);
    boolean removeFavorito(Produccion produccion, Usuario usuario);
    ArrayList<Favorito> findByIdUsuario(Usuario usuario);
}