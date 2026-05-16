package com.yoel.actividad.repository;

import com.yoel.actividad.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // Al extender JpaRepository, ya tenemos métodos como save(), findAll(), findById(), de
}
