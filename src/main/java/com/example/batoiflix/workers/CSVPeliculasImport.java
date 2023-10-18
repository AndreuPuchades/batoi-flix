package com.example.batoiflix.workers;

import com.example.batoiflix.BatoiFlixApplication;
import com.example.batoiflix.modelo.dao.ProduccionDAO;
import com.example.batoiflix.modelo.dao.interfaces.ProduccionDAOInterface;
import com.example.batoiflix.modelo.entities.*;
import com.example.batoiflix.modelo.enums.Calificacion;
import com.example.batoiflix.modelo.enums.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

@Component
@ConditionalOnProperty(name = "Peliculas")
public class CSVPeliculasImport implements CommandLineRunner {

    private ProduccionDAOInterface produccionDAOInterface;
    private final Environment environment;

    @Autowired
    public CSVPeliculasImport(Environment environment, @Autowired ProduccionDAO produccionDAO) {
        this.produccionDAOInterface = produccionDAO;
        this.environment = environment;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(BatoiFlixApplication.class).web(WebApplicationType.NONE).run("--Peliculas");
    }

    public void run(String... args) {
        ArrayList<Produccion> produccions = leerFicheroProducciones();
        for (int i = 0; i < produccions.size(); i++) {
            produccionDAOInterface.save(produccions.get(i));
        }
    }

    private ArrayList<Produccion> leerFicheroProducciones(){
        ArrayList<Produccion> todasLasProducciones = new ArrayList<>();
        File file = new File(getClass().getResource("/databases/peliculas_series.csv").getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            do {
                String registro = br.readLine();
                if (registro == null){
                    return todasLasProducciones;
                }
                if (registro != null) {
                    Produccion produccion = getProduccion(registro);
                    todasLasProducciones.add(produccion);
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Produccion getProduccion(String registro){
        String[] camposRegistro = registro.split(";");
        int codigo = Integer.parseInt(camposRegistro[0].trim());
        String titulo = camposRegistro[1].trim();
        Calificacion calificacion = getCalificacion(camposRegistro[2].trim());
        LocalDate fecha = getFecha(camposRegistro[3].trim());
        String duracionString = camposRegistro[4].trim();
        int duracion;
        if(duracionString.equalsIgnoreCase("N/A")){
            duracion = 0;
        } else {
            duracion = Integer.parseInt(duracionString.substring(0, duracionString.length() - 4));
        }

        ArrayList<Genero> genero = getGeneros(camposRegistro[5].trim());
        Director director = new Director(camposRegistro[6].trim());
        ArrayList<Actor> actores = getActores(camposRegistro[7].trim());
        String guion = camposRegistro[8].trim();
        String portada = camposRegistro[9].trim();
        String tipo = camposRegistro[10].trim();
        Productor productor = new Productor(camposRegistro[11].trim());
        String web = camposRegistro[12].trim();
        ArrayList<Plataforma> plataformas = getPlataformas(camposRegistro[13].trim());
        if (tipo.equals("movie")){
            return new Pelicula(codigo,titulo,calificacion,fecha,duracion,genero,director,actores,guion,portada,productor,web,plataformas);
        } else if (tipo.equals("tv-show")) {
            return new Serie(codigo,titulo,calificacion,fecha,duracion,genero,director,actores,guion,portada,productor,web,plataformas);
        }
        return null;
    }

    private ArrayList<Genero> getGeneros(String cadenaGeneros){
        Genero[] allGeneros = {
                Genero.ADVENTURE, Genero.ACTION, Genero.ANIMATION, Genero.BIOGRAPHY, Genero.FANTASY,
                Genero.DRAMA, Genero.CRIME, Genero.FAMILY, Genero.HORROR, Genero.HISTORY, Genero.MUSICAL, Genero.SPORT,
                Genero.COMEDY, Genero.SCI_FI, Genero.MISTERY, Genero.WESTERN, Genero.ROMANCE, Genero.THRILLER,
        };

        ArrayList<Genero> generos = new ArrayList<>();
        String[] generosCadena = cadenaGeneros.split(",");

        for (int i = 0; i < generosCadena.length; i++) {
            for (int j = 0; j < allGeneros.length; j++) {
                if(allGeneros[j].toString().equalsIgnoreCase(generosCadena[i].trim())){
                    generos.add(allGeneros[j]);
                }
            }
        }

        return generos;
    }

    private ArrayList<Actor> getActores(String actores){
        ArrayList<Actor> actoresProduccion = new ArrayList<>();
        String[] camposActores = actores.split(",");
        for (String actor: camposActores) {
            actoresProduccion.add(new Actor(actor));
        }
        return actoresProduccion;
    }

    private ArrayList<Plataforma> getPlataformas(String plataformas){
        ArrayList<Plataforma> plataformas1 = new ArrayList<>();
        String[] plat = plataformas.split(",");
        for (String item: plat ) {
            plataformas1.add(new Plataforma(item.trim()));
        }
        return plataformas1;
    }

    private LocalDate getFecha(String fecha){

        DateTimeFormatter formatter;
        LocalDate fecha2;
        if (fecha.contains("-")){
            formatter = DateTimeFormatter.ofPattern("[dd][d]-MMM-yy");
            fecha2 = LocalDate.parse(fecha.trim(),formatter);
            if (fecha2.getYear() > 2023){
                fecha2 = fecha2.minusYears(100);
            }
        } else {
            formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ROOT);
            fecha2 = LocalDate.parse(fecha.trim(),formatter);
        }
        return fecha2;
    }

    private Calificacion getCalificacion(String cadena){
        if(cadena.equalsIgnoreCase("G")){
            return Calificacion.G;
        } else if (cadena.equalsIgnoreCase("PG")) {
            return Calificacion.PG;
        } else if (cadena.equalsIgnoreCase("PG-13")) {
            return Calificacion.PG_13;
        } else if (cadena.equalsIgnoreCase("R")) {
            return Calificacion.R;
        } else {
            return Calificacion.X;
        }
    }
}
