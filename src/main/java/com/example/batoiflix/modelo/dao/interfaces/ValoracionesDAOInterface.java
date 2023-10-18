package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.entities.Valoracion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ValoracionesDAOInterface {
    boolean save(Valoracion valoracion);
    ArrayList<Valoracion> findByIdUsuario(Usuario usuario);
    boolean remove(int idProduccion, int idUsuario);
    Valoracion findByIdUsuarioAndProduccion(Usuario usuario, Produccion produccion);
}
