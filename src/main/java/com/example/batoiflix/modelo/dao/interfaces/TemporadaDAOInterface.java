package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.Temporada;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface TemporadaDAOInterface {
    ArrayList<Temporada> getByIdSerie(int idSerie);
    boolean save(Temporada temporada);
    Temporada getById(int idSerie, int idTemporada);
}