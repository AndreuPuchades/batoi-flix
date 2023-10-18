package com.example.batoiflix.workers;

import com.example.batoiflix.BatoiFlixApplication;
import com.example.batoiflix.modelo.dao.ProduccionDAO;
import com.example.batoiflix.modelo.dao.TemporadaDAO;
import com.example.batoiflix.modelo.dao.interfaces.ProduccionDAOInterface;
import com.example.batoiflix.modelo.dao.interfaces.TemporadaDAOInterface;
import com.example.batoiflix.modelo.entities.Serie;
import com.example.batoiflix.modelo.entities.Temporada;
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
import java.util.ArrayList;

@Component
@ConditionalOnProperty(name = "Series")
public class CSVImportSeries implements CommandLineRunner {

    private TemporadaDAOInterface temporadaDAOInterface;
    private ProduccionDAOInterface produccionDAOInterface;
    private final Environment environment;

    @Autowired
    public CSVImportSeries(Environment environment, @Autowired TemporadaDAO temporadaDAO, @Autowired ProduccionDAO produccionDAO) {
        this.temporadaDAOInterface = temporadaDAO;
        this.produccionDAOInterface = produccionDAO;
        this.environment = environment;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(BatoiFlixApplication.class).web(WebApplicationType.NONE).run(args);
    }

    public void run(String... args) {
        ArrayList<Temporada> temporadasFichero = leerFicheroTemporadas();

        for (int i = 0; i < temporadasFichero.size(); i++) {
            temporadaDAOInterface.save(temporadasFichero.get(i));
        }
    }

    private ArrayList<Temporada> leerFicheroTemporadas(){
        ArrayList<Temporada> todasLasTemporadas = new ArrayList<>();
        File file = new File(getClass().getResource("/databases/extra_series.csv").getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            do {
                String registro = br.readLine();
                if (registro == null){
                    return todasLasTemporadas;
                }
                if (registro != null){
                    Temporada temporada = getTemporada(registro);
                    todasLasTemporadas.add(temporada);
                }
            }while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Temporada getTemporada(String registro){
        String[] campos = registro.split(";");
        Serie serie =(Serie) produccionDAOInterface.getByIdProduccion(Integer.parseInt(campos[0].trim()));
        int temporada = Integer.parseInt(campos[1].trim());
        int anyo = Integer.parseInt(campos[2].trim());
        String guion = campos[3].trim();
        int capitulo = Integer.parseInt(campos[4].trim());
        return new Temporada(serie, temporada, anyo, guion, capitulo);
    }
}