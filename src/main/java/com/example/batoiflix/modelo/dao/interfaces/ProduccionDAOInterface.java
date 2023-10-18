package com.example.batoiflix.modelo.dao.interfaces;

import com.example.batoiflix.modelo.entities.PaginateResult;
import com.example.batoiflix.modelo.entities.Produccion;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface ProduccionDAOInterface {
    ArrayList<Produccion> findAll();
    PaginateResult findAllPelicula(int page, int pageSize);
    PaginateResult findAllOrder(int page, int pageSize, String order);
    PaginateResult findAllSeries(int page, int pageSize);
    boolean save(Produccion produccion);
    Produccion getByIdProduccion(int idProduccion);
    ArrayList<Produccion> findAllRecomendadas();
    PaginateResult getByTitlePagined(String titulo,int page, int pageSize);
    PaginateResult getByGenerePagined(String genero,int page, int pageSize);
    PaginateResult getByGenereAndTitlePagined(String genero,String titulo,int page, int pageSize);
}