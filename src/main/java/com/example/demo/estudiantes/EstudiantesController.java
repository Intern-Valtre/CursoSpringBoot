package com.example.demo.estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudiantesService estudiantesService;

    @GetMapping
    public String listadoEstudiantes(Model model) {
        List<Estudiantes> estudiantesList = estudiantesService.listar();
        model.addAttribute("estudiantesList", estudiantesList);
        return "estudiantes/listado";
    }

    @GetMapping(path = "new")
    public String agregarEstudiante(Model model) {
        model.addAttribute("estudianteNuevo", new Estudiantes());
        return "estudiantes/agregar";
    }

    @PostMapping(path = "new")
    public String registerNewEstudiante(@Validated Estudiantes estudiantes, Model model) {
        estudiantesService.agregarEstudiante(estudiantes);
        return "redirect:/estudiantes";
    }

    @GetMapping(path = "/{idEstudiante}")
    public String modificarEstudiante(
            @PathVariable("idEstudiante") Long idEstudiante,
            Model model
    ) {
        Optional<Estudiantes> estudianteEditable = estudiantesService.buscaEstudiante(idEstudiante);
        if (estudianteEditable.isPresent()) {
            model.addAttribute("idEstudiante", idEstudiante);
            model.addAttribute("estudianteEditable", estudianteEditable);
            return "estudiantes/editar";
        } else {
            return "redirect:/estudiantes";
        }

    }

    @PostMapping
    public String confirmarEdicion(
            @Validated Estudiantes estudianteModificado,
            Model model
    ) {
        Boolean flag = estudiantesService.modificaEstudiante(estudianteModificado);

        return "redirect:/estudiantes";
    }

    @GetMapping(path = "/desactivar/{idEstudiante}")
    public String desactivarEstudiante(
            @PathVariable("idEstudiante") Long idEstudiante,
            Model model
    ) {
        estudiantesService.desactivadoEstudiante(idEstudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping(path = "/activar/{idEstudiante}")
    public String activarEstudiante(
            @PathVariable("idEstudiante") Long idEstudiante,
            Model model
    ) {
        estudiantesService.activadoEstudiante(idEstudiante);
        return "redirect:/estudiantes";
    }

}
