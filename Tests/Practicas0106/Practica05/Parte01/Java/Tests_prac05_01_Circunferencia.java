import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests_prac05_01_Circunferencia {

	

	@Test
	public void testConstructoresCircunferencia() {
		
		Circunferencia c = new Circunferencia();
		assertEquals("El radio de una circunferencia construida con el constructor vacío debe ser 0.0", 0.0, c.getRadio(),0);
		
		Circunferencia c1 = new Circunferencia(10.0);
		assertEquals("El radio de la circunferencia c1 debe ser 10.0", 10.0, c1.getRadio(),0);
		
	}
	
	@Test
	public void testContador() {
		assertEquals("Hasta ahora se han construido 2 circunferencias", 2, Circunferencia.getContadorCircunferencias(),0);
		
	}
	
	@Test
	public void testGetSetRadio() {
		
		Circunferencia c1 = new Circunferencia(18);
		c1.setRadio(5.0);
		assertEquals("El radio de la circunferencia c1 debe ser 5.0", 5.0, c1.getRadio(),0);
		
	}
	
	@Test
	public void testGetSetDiametro() {
		
		Circunferencia c1 = new Circunferencia(12);
		assertEquals("El diametro de la circunferencia c1 con radio 12 debe ser 24", 24, c1.getDiametro(),0);
		c1.setDiametro(5.0);
		assertEquals("El radio de la circunferencia c1 con diametro 5.0 debe ser 2.5", 2.5, c1.getRadio(),0);
		
	}
	
	@Test
	public void testGetSetLongitud() {
		
		Circunferencia c1 = new Circunferencia(2.0);
		assertEquals("La longitud de la circunferencia c1 con radio 2.0 debe ser 12.5664", 12.5664, c1.getLongitud(),0);
		c1.setLongitud(0.62832);
		assertEquals("El radio de la circunferencia c1 con longitud 0.62832 debe ser 0.1", 0.1, c1.getRadio(),0);
		
	}
	
	@Test
	public void testGetSetArea() {
		
		Circunferencia c1 = new Circunferencia(5.0);
		assertEquals("El área de la circunferencia c1 con radio 5.0 debe ser 78.54", 78.54, c1.getArea(),0.001);
		c1.setArea(0.125664);
		assertEquals("El radio de la circunferencia c1 con área 0.125664 debe ser 0.2", 0.2, c1.getRadio(),0);
		
	}
	
	@Test
	public void testToString() {
			
		Circunferencia c1 = new Circunferencia(5.0);
		assertEquals("C1 se muestra bien", true, c1.toString().contains(Double.toString(c1.getRadio())));
		assertEquals("C1 se muestra bien", true, c1.toString().contains(Double.toString(c1.getArea())));

	}
	

}
