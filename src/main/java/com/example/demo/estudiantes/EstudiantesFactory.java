package com.example.demo.estudiantes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstudiantesFactory {

    @Bean
    CommandLineRunner commandLineRunner(EstudiantesService estudiantesService) {
        return args -> {
            Estudiantes estudianteOmar = new Estudiantes(
                    "Omar",
                    "Ramirez",
                    6
            );
            //Registra el estudiante
            estudiantesService.agregarEstudiante(estudianteOmar);

            Estudiantes estudianteAlexis = new Estudiantes(
                    "Alexis",
                    "Luna",
                    5
            );
            //Registra el estudiante
            estudiantesService.agregarEstudiante(estudianteAlexis);

            Estudiantes estudianteGiselle = new Estudiantes(
                    "Giselle",
                    "Camo",
                    7
            );
            //Registra el estudiante
            estudiantesService.agregarEstudiante(estudianteGiselle);

            //Elimina el estudiante con valor 1
            Long idEliminar = Long.valueOf(1);
            estudiantesService.eliminarEstudiante(idEliminar);

        };
    }

}
