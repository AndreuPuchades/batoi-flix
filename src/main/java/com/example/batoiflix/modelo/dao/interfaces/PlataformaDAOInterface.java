package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.Plataforma;
import java.util.ArrayList;

public interface PlataformaDAOInterface {
    ArrayList<Plataforma> findAll();


    Plataforma getById(int id);
}
