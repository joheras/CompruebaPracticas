import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac05_02_Reconocimiento {

	@Test
	public void testConstructor() {
		
		Reconocimiento a1 = new Reconocimiento("POO",6,"ingles");
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("La descripción debe ser inglés", "ingles",a1.getDescripcion());
		
	}
	
	@Test
	public void testSetNombre() {	
		Reconocimiento a1 = new Reconocimiento("POO",6,"ingles");
		a1.setNombre("TP");
		assertEquals("El nombre de la asignatura a1 debe ser TP", "TP", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("La descripción debe ser inglés", "ingles",a1.getDescripcion());
	}

	
	@Test
	public void testSetCreditos() {	
		Reconocimiento a1 = new Reconocimiento("POO",6,"ingles");
		a1.setCreditos(9);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 9", 9, a1.getCreditos());
		assertEquals("La descripción debe ser inglés", "ingles",a1.getDescripcion());
		
	}
	
	@Test
	public void testSetDescripcion() {	
		Reconocimiento a1 = new Reconocimiento("POO",6,"ingles");
		a1.setDescripcion("frances");
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("La descripción debe ser frances", "frances",a1.getDescripcion());
	}
	
}
