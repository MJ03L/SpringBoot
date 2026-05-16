package com.yoel.actividad.service;

import com.yoel.actividad.model.Estudiante;
import com.yoel.actividad.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repository;

    // Crear un estudiante en base de datos
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    // Obtener todos los estudiantes de la base de datos
    public List<Estudiante> obtenerTodos() {
        return repository.findAll();
    }
}
