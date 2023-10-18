package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface VisualizacionDAOInterface {
    boolean save(Usuario usuario, Produccion produccion);
    int getVisualizaciones(Usuario usuario, Produccion produccion);
}