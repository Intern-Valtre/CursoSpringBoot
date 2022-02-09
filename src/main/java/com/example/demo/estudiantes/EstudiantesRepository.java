package com.example.demo.estudiantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiantes, Long> {


    @Transactional
    @Modifying
    @Query("UPDATE Estudiantes e " +
            "SET e.estatus = FALSE "+
            "WHERE  e.id = ?1"
    )
    int desactivarEstudiante(Long idEstudiante);

    @Transactional
    @Modifying
    @Query("UPDATE Estudiantes e " +
            "SET e.estatus = TRUE "+
            "WHERE e.id = ?1"
    )
    int activarEstudiante(Long idEstudiante);

}
