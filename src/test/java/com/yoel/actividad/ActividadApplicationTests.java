package com.yoel.actividad;

import com.yoel.actividad.model.Estudiante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActividadApplicationTests {

	@Test
	void contextLoads() {
		// Test por defecto de Spring
	}

	@Test
	void verificarNombreEstudiante() {
		// Creamos un estudiante simulado para la prueba
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Yoel");
		estudiante.setEmail("yoel@correo.com");

		// Comprobamos si el nombre asignado es realmente "Yoel"
		assertEquals("Yoel Falla", estudiante.getNombre());
	}
}