import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac04_01_Asignatura {

	@Test
	public void testConstructor() {
		Asignatura a = new Asignatura();
		assertEquals("El nombre de una asignatura construida con constructor vacío debe estar vacío", "", a.getNombre());
		assertEquals("El número de creditos de una asignatura construida con constructor vacío debe ser 0", 0, a.getCreditos());
		assertEquals("El plan de estudios de una asignatura construida con constructor vacío debe ser 0", 0, a.getPlanEstudios());
		
		Asignatura a1 = new Asignatura("POO",6,701);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, a1.getPlanEstudios());
		
	}
	
	@Test
	public void testSetNombre() {	
		Asignatura a1 = new Asignatura("POO",6,701);
		a1.setNombre("TP");
		assertEquals("El nombre de la asignatura a1 debe ser TP", "TP", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, a1.getPlanEstudios());
		
	}

	
	@Test
	public void testSetCreditos() {	
		Asignatura a1 = new Asignatura("POO",6,701);
		a1.setCreditos(9);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 9", 9, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, a1.getPlanEstudios());
		
	}
	
	@Test
	public void testSetPlanEstudios() {	
		Asignatura a1 = new Asignatura("POO",6,701);
		a1.setPlanEstudios(801);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 801", 801, a1.getPlanEstudios());
		
	}
	
}
