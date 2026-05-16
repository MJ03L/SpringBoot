package com.yoel.actividad.controller;

import com.yoel.actividad.model.Estudiante;
import com.yoel.actividad.service.EstudianteService;
import jakarta.validation.Valid; // ¡NUEVO! Para activar las validaciones
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // ¡NUEVO! Para devolver estados HTTP correctos
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    // Endpoint para listar (GET: http://localhost:8080/api/estudiantes)
    @GetMapping
    public List<Estudiante> listarTodos() {
        return service.obtenerTodos();
    }

    // ¡NUEVO! Endpoint para buscar por ID con control de errores
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id) {
        Estudiante estudiante = service.obtenerPorId(id); // Tu servicio controlará si no existe
        return ResponseEntity.ok(estudiante);
    }

    // Endpoint para guardar (Añadimos @Valid para activar las validaciones de la entidad)
    @PostMapping
    public Estudiante crear(@Valid @RequestBody Estudiante estudiante) {
        return service.guardarEstudiante(estudiante);
    }

    // ¡NUEVO! 1. Método PUT para actualizar un estudiante por ID
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id, @Valid @RequestBody Estudiante estudianteDetalles) {
        Estudiante estudianteActualizado = service.actualizarEstudiante(id, estudianteDetalles);
        return ResponseEntity.ok(estudianteActualizado);
    }

    // ¡NUEVO! 2. Método DELETE para borrar un estudiante por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id) {
        service.eliminarEstudiante(id);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}