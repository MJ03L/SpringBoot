package com.yoel.actividad.controller;

import com.yoel.actividad.model.Estudiante;
import com.yoel.actividad.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    // Volvemos a usar Inyección de Dependencias para traer el Service
    @Autowired
    private EstudianteService service;

    // Endpoint para guardar (POST: http://localhost:8080/api/estudiantes)
    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return service.guardarEstudiante(estudiante);
    }

    // Endpoint para listar (GET: http://localhost:8080/api/estudiantes)
    @GetMapping
    public List<Estudiante> listarTodos() {
        return service.obtenerTodos();
    }
}
