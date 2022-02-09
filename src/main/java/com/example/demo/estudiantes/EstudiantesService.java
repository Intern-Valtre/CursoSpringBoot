package com.example.demo.estudiantes;

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

    public void desactivadoEstudiante(Long idEstudiante) {
        Optional<Estudiantes> estudianteBusqueda = estudiantesRepository.findById(idEstudiante);

        if (estudianteBusqueda.isPresent()) {
            if (estudianteBusqueda.get().getEstatus()) {
                estudiantesRepository.desactivarEstudiante(idEstudiante);
            }
        }

    }

    public void activadoEstudiante(Long idEstudiante) {
        Optional<Estudiantes> estudianteBusqueda = estudiantesRepository.findById(idEstudiante);

        if (estudianteBusqueda.isPresent()) {
            if (!estudianteBusqueda.get().getEstatus()) {
                estudiantesRepository.activarEstudiante(idEstudiante);
            }
        }
    }

}
