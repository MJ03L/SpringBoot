package com.yoel.actividad.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min; // ¡NUEVO! Para validar números mínimos
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El formato del email no es válido")
    private String email;

    // 1. ¡AÑADE ESTA VARIABLE!
    @Min(value = 1, message = "La edad debe ser mayor a 0")
    private Integer edad;

    // Constructores
    public Estudiante() {}

    // Modificamos el constructor para incluir la edad si lo necesitas
    public Estudiante(Long id, String nombre, String email, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    // Getters y Setters existentes...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // 2. ¡AÑADE ESTOS DOS MÉTODOS AL FINAL (GETTER Y SETTER)!
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}