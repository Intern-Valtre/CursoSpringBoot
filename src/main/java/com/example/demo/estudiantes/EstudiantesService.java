package com.example.demo.estudiantes;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Estudiantes> buscaEstudiante(Long idEstudiante) {
        return estudiantesRepository.findById(idEstudiante);
    }

    public boolean modificaEstudiante(Estudiantes estudianteModificado) {

        Boolean flag = true;
        Optional<Estudiantes> estudianteModificar = buscaEstudiante(estudianteModificado.getId());

        if (estudianteModificar.isPresent()) {
            Estudiantes estudiantesGrabar = estudianteModificar.get();
            estudiantesGrabar.setNombres(estudianteModificado.getNombres());
            estudiantesGrabar.setApellidos(estudianteModificado.getApellidos());
            estudiantesGrabar.setClases(estudianteModificado.getClases());

            estudiantesRepository.save(estudiantesGrabar);
        } else {
            flag = false;
        }

        return flag;

    }

    //Permite borrado de estudiantes mediante id
    public Boolean eliminarEstudiante(Long id) {
        estudiantesRepository.deleteById(id);
        return true;
    }
}
