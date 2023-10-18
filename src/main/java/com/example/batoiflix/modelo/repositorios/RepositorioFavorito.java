package com.example.batoiflix.modelo.repositorios;

import com.example.batoiflix.modelo.dao.FavoritosDAO;
import com.example.batoiflix.modelo.dao.interfaces.FavoritosDAOInterface;
import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositorioFavorito {
    private FavoritosDAOInterface favoritosDAOInterface;

    public RepositorioFavorito(@Autowired FavoritosDAO favoritosDAO){
        this.favoritosDAOInterface = favoritosDAO;
    }

    public void saveFavorito(Usuario usuario, Produccion produccion){
        favoritosDAOInterface.insertFavoritos(usuario, produccion);
    }

    public boolean estaEnFavorito(Produccion produccion, Usuario usuario){
        return favoritosDAOInterface.estaEnFavorito(produccion, usuario);
    }

    public boolean removeFavorito(Produccion produccion, Usuario usuario){
        return favoritosDAOInterface.removeFavorito(produccion, usuario);
    }
}
