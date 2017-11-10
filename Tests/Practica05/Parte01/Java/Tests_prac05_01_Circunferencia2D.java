import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests_prac05_01_Circunferencia2D {

	

	@Test
	public void testConstructoresCircunferencia2D() {
		
		Circunferencia2D c = new Circunferencia2D();
		assertEquals("El radio de una circunferencia2D construida con el constructor vacío debe ser 0.0", 0.0, c.getRadio(),0);
		assertEquals("El centro de la circunferencia c debe ser (0,0)", 0, c.getCentro().getX(),0);
		assertEquals("El centro de la circunferencia c debe ser (0,0)", 0, c.getCentro().getY(),0);
		
		Punto p = new Punto(5.0,5.0);
		Circunferencia2D c1 = new Circunferencia2D(10.0,p);
		assertEquals("El radio de la circunferencia c1 debe ser 10.0", 10.0, c1.getRadio(),0);
		assertEquals("El centro de la circunferencia c1 debe ser (5,5)", 5.0, c1.getCentro().getX(),0.0001);
		assertEquals("El centro de la circunferencia c1 debe ser (5,5)", 5.0, c1.getCentro().getY(),0.0001);
		
	}
	
	@Test
	public void testContadorCircunferencia2D() {
		assertEquals("Hasta ahora se han construido 9 circunferencias",9, Circunferencia.getContadorCircunferencias(),0);
		
	}
	
	@Test
	public void testGetSetRadio() {
		
		Punto p = new Punto(5.0,5.0);
		Circunferencia2D c1 = new Circunferencia2D(18,p);
		c1.setRadio(5.0);
		assertEquals("El radio de la circunferencia c1 debe ser 5.0", 5.0, c1.getRadio(),0);
		
	}
	
	
	@Test
	public void testGetSetCentro() {
		
		Punto p = new Punto(5.0,5.0);
		Circunferencia2D c1 = new Circunferencia2D(18,p);
		
		assertEquals("El centro de la circunferencia c1 debe ser (5.0,5.0)", 5.0, c1.getCentro().getX(),0.0001);
		assertEquals("El centro de la circunferencia c1 debe ser (5.0,5.0)", 5.0, c1.getCentro().getY(),0.0001);
		
		Punto p1 = new Punto(7.0,7.0);
		c1.setCentro(p1);
		assertEquals("El centro de la circunferencia c1 debe ser (7.0,7.0)", 7.0, c1.getCentro().getX(),0.0001);
		assertEquals("El centro de la circunferencia c1 debe ser (7.0,7.0)", 7.0, c1.getCentro().getY(),0.0001);
		
	}
	
	@Test
	public void testGetSetDiametro() {
		Punto p = new Punto(5.0,5.0);
		Circunferencia2D c1 = new Circunferencia2D(12,p);
		assertEquals("El diametro de la circunferencia c1 con radio 12 debe ser 24", 24, c1.getDiametro(),0);
		c1.setDiametro(5.0);
		assertEquals("El radio de la circunferencia c1 con diametro 5.0 debe ser 2.5", 2.5, c1.getRadio(),0);
		
	}
	
	@Test
	public void testGetSetLongitud() {
		Punto p = new Punto(5.0,5.0);
		Circunferencia2D c1 = new Circunferencia2D(2.0,p);
		assertEquals("La longitud de la circunferencia c1 con radio 2.0 debe ser 12.5664", 12.5664, c1.getLongitud(),0);
		c1.setLongitud(0.62832);
		assertEquals("El radio de la circunferencia c1 con longitud 0.62832 debe ser 0.1", 0.1, c1.getRadio(),0);
		
	}
	
	@Test
	public void testGetSetArea() {
		Punto p = new Punto(5.0,5.0);
		Circunferencia2D c1 = new Circunferencia2D(5.0,p);
		assertEquals("El área de la circunferencia c1 con radio 5.0 debe ser 78.54", 78.54, c1.getArea(),0.001);
		c1.setArea(0.125664);
		assertEquals("El radio de la circunferencia c1 con área 0.125664 debe ser 0.2", 0.2, c1.getRadio(),0);
		
	}
	
	@Test
	public void testToString() {
		Punto p = new Punto(5.0,5.0);	
		Circunferencia2D c1 = new Circunferencia2D(5.0,p);
		assertEquals("C1 muestra bien Circunferencia2D", true, c1.toString().contains("Circunferencia2D"));
		assertEquals("C1 muestra bien el radio", true, c1.toString().contains(Double.toString(5.0)));
		assertEquals("C1 muestra bien el area", true, c1.toString().contains(Double.toString(c1.getArea())));
		assertEquals("C1 muestra bien el punto", true, c1.toString().contains(Double.toString(c1.getCentro().getCoordAngular())));
		assertEquals("C1 muestra bien el punto", true, c1.toString().contains(Double.toString(c1.getCentro().getCoordRadial())));

	}
	

}
