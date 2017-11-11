import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac05_02_Actividad {

	@Test
	public void testConstructor() {
		Actividad a = new Actividad();
		assertEquals("El nombre de una asignatura construida con constructor vacío debe estar vacío", "", a.getNombre());
		assertEquals("El número de creditos de una asignatura construida con constructor vacío debe ser 0", 0, a.getCreditos());
		
		Actividad a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		
	}
	
	@Test
	public void testSetNombre() {	
		Actividad a1 = new Actividad("POO",6);
		a1.setNombre("TP");
		assertEquals("El nombre de la asignatura a1 debe ser TP", "TP", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		
	}

	
	@Test
	public void testSetCreditos() {	
		Actividad a1 = new Actividad("POO",6);
		a1.setCreditos(9);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 9", 9, a1.getCreditos());
		
	}

}
