package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.Plataforma;

import java.util.ArrayList;

public interface DisponibilidadPlataformaDAOInterface {
    ArrayList<Plataforma> plataformasDisponibles(int produccionID);
}
