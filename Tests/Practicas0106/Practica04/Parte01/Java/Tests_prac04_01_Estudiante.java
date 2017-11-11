import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac04_01_Estudiante {

	@Test
	public void testConstructor() {
		Estudiante e = new Estudiante();
		assertEquals("La cuasi de un estudiante construido con constructor vacío debe estar vacío", "", e.getCuasi());
		assertEquals("Un estudiante construido con el constructor vacío no tiene familia numerosa", false, e.getFamiliaNumerosa());
		
		
		Estudiante e1 = new Estudiante("peperez",true);
		assertEquals("La cuasi del estudiante debe ser peperez", "peperez", e1.getCuasi());
		assertEquals("El estudiante pertenece a una familia numerosa", true, e1.getFamiliaNumerosa());
		
		
	}
	
	@Test
	public void testSetCuasi() {	
		Estudiante e1 = new Estudiante("peperez",true);
		e1.setCuasi("pepeperez");
		assertEquals("La cuasi del estudiante debe ser pepeperez", "pepeperez", e1.getCuasi());
		assertEquals("El estudiante pertenece a una familia numerosa", true, e1.getFamiliaNumerosa());
		
	}

	
	@Test
	public void testSetFamiliaNumerosa() {	
		Estudiante e1 = new Estudiante("peperez",true);
		e1.setFamiliaNumerosa(false);
		assertEquals("La cuasi del estudiante debe ser peperez", "peperez", e1.getCuasi());
		assertEquals("El estudiante no pertenece a una familia numerosa", false, e1.getFamiliaNumerosa());
		
	}
	
}
