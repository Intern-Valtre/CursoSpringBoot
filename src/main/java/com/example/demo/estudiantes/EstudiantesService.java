package com.example.demo.estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesService {

    @Autowired
    private EstudiantesRepository estudiantesRepository;

    public String agregarEstudiante(Estudiantes estudiantes) {
        estudiantesRepository.save(estudiantes);

        return "Exitoso";

    }

    public List<Estudiantes> listar() {
        return (List<Estudiantes>)estudiantesRepository.findAll() ;
    }
}
