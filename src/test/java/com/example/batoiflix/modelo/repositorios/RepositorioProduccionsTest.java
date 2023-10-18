package com.example.batoiflix.modelo.repositorios;

import com.example.batoiflix.modelo.entities.PaginateResult;
import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.enums.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RepositorioProduccionsTest {
    @Autowired
    private RepositorioProduccions repositorioProduccions;
    @Autowired
    private RepositoriosUsuarios repositoriosUsuarios;

    @Test
    void testBuscarPorNombre(){
        String tituloProduccionEsperada = "The Other Woman";
        int idProduccionEsperada = 14;

        PaginateResult resultado = repositorioProduccions.findAllWithTitle("The Other Woman",1);
        assertEquals(tituloProduccionEsperada,resultado.getProduccions().get(0).getTitulo());
        assertEquals(idProduccionEsperada,resultado.getProduccions().get(0).getId());
    }

    @Test
    void testlistarSeries(){
        int totalDeSeriesPagina1 = 8;

        PaginateResult paginateResult = repositorioProduccions.paginatedSeries(1);
        assertEquals(totalDeSeriesPagina1,paginateResult.getProduccions().size());
    }

    @Test
    void testOrdenarASCConPagina(){
        ArrayList<String> titulosEsperados = new ArrayList<>();
        titulosEsperados.add("Coyote Ugly");
        titulosEsperados.add("Miss Congeniality");
        titulosEsperados.add("All the Pretty Horses");
        titulosEsperados.add("Finding Forrester");
        titulosEsperados.add("The Pledge");
        titulosEsperados.add("15 Minutes");
        titulosEsperados.add("A Knight's Tale");
        titulosEsperados.add("Scary Movie 2");
        titulosEsperados.add("Final Fantasy: The Spirits Within");
        titulosEsperados.add("Training Day");
        titulosEsperados.add("From Hell");
        titulosEsperados.add("The Mothman Prophecies");
        titulosEsperados.add("Big Trouble");
        titulosEsperados.add("Changing Lanes");
        titulosEsperados.add("The Sweetest Thing");

        int numeroDeProduccionesEsperadas = 15;

        PaginateResult resultadoObtenido = repositorioProduccions.paginatedProduccionesOrden(4,"ASC");
        for (int i = 0; i < titulosEsperados.size(); i++) {
            assertEquals(titulosEsperados.get(i),resultadoObtenido.getProduccions().get(i).getTitulo());
        }
        assertEquals(numeroDeProduccionesEsperadas,resultadoObtenido.getProduccions().size());
    }

    @Test
    void testInsertarNuevoUsuario(){
        Usuario usuario = new Usuario("Prueba","Entornos","prueba@gmail.com","711383a59fda05336fd2ccf70c8059d1523eb41a", TipoUsuario.USUARIO);

        boolean insertado = repositoriosUsuarios.save(usuario);

        assertTrue(insertado);
        assertNotNull(usuario.getCodigo());
    }
}
