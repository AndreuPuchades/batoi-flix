package com.example.batoiflix.modelo.repositorios;

import com.example.batoiflix.modelo.dao.ProduccionDAO;
import com.example.batoiflix.modelo.dao.ValoracionDAO;
import com.example.batoiflix.modelo.dao.interfaces.ProduccionDAOInterface;
import com.example.batoiflix.modelo.dao.interfaces.ValoracionesDAOInterface;
import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.entities.Valoracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class RepositorioValoraciones {
    private ValoracionesDAOInterface valoracionesDAOInterface;
    private ProduccionDAOInterface produccionDAOInterface;

    public RepositorioValoraciones(@Autowired ValoracionDAO valoracionesDAO, @Autowired ProduccionDAO produccionDAO){
        this.valoracionesDAOInterface = valoracionesDAO;
        this.produccionDAOInterface = produccionDAO;
    }

    public void saveValoracion(Valoracion valoracion){
        valoracionesDAOInterface.save(valoracion);
    }

    public ArrayList<Valoracion> findValoracionesByIdUsuario(Usuario usuario){
        ArrayList<Valoracion> valoraciones = valoracionesDAOInterface.findByIdUsuario(usuario);

        for (int i = 0; i < valoraciones.size(); i++) {
            valoraciones.get(i).setUsuario(usuario);
            valoraciones.get(i).setProduccion(produccionDAOInterface.getByIdProduccion(valoraciones.get(i).getProduccion().getId()));
        }

        return valoraciones;
    }
    public Valoracion findValoracionesByIdUsuarioAndProduccion(Usuario usuario, Produccion produccion){
        return valoracionesDAOInterface.findByIdUsuarioAndProduccion(usuario,produccion);
    }

    public void removeValoracion(int idProduccion, int idUsuario){
        valoracionesDAOInterface.remove(idProduccion, idUsuario);
    }
}