package com.example.batoiflix;

import com.example.batoiflix.modelo.entities.Pelicula;
import com.example.batoiflix.workers.CSVPeliculasImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatoiFlixApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatoiFlixApplication.class, args);
	}
}