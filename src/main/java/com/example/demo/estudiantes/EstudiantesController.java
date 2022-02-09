package com.example.demo.estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

}
