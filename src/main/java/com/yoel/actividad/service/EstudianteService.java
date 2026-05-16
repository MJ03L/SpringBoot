package com.yoel.actividad.service;

import com.yoel.actividad.ResourceNotFoundException;
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

    // Metodo para obtener por ID (Lanza error si no existe)
    public Estudiante obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con el ID: " + id));
    }

    // Metodo para actualizar
    public Estudiante actualizarEstudiante(Long id, Estudiante detalles) {
        Estudiante estudiante = obtenerPorId(id); // Reutiliza el metodo de arriba para validar si existe

        estudiante.setNombre(detalles.getNombre());
        estudiante.setEmail(detalles.getEmail());

        return repository.save(estudiante);
    }

    // Metodo para eliminar
    public void eliminarEstudiante(Long id) {
        Estudiante estudiante = obtenerPorId(id); // Valida si existe antes de borrar
        repository.delete(estudiante);
    }
}
