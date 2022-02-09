package com.example.demo.estudiantes;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Estudiantes {

    @SequenceGenerator(
            name = "seq_estudiantes",
            sequenceName = "seq_estudiantes",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_estudiantes"
    )
    private Long id;
    private String nombres;
    private String apellidos;
    private Integer clases;
    private Boolean estatus;

    public Estudiantes(String nombres, String apellidos, Integer clases) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clases = clases;
        this.estatus = true;
    }

}
