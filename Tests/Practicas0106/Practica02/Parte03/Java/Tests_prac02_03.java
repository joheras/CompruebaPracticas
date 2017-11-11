import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac02_03 {

	@Test
	public void testConstructores() {
		Punto p = new Punto();
		assertEquals("La coordenada x de un punto construido con constructor vacío debe ser 0", 0, p.getX(),0.001);
		assertEquals("La coordenada y de un punto construido con constructor vacío debe ser 0", 0, p.getY(),0.001);
		
		Punto p1 = new Punto(5.0,7.0);
		assertEquals("La coordenada x del punto p1 deber ser 5.0", 5.0, p1.getX(),0.001);
		assertEquals("La coordenada y del punto p1 deber ser 7.0", 7.0, p1.getY(),0.001);
	}
	
	@Test
	public void testGetSetX() {
			
		Punto p1 = new Punto(5.0,7.0);
		p1.setX(3.2);
		assertEquals("La coordenada x del punto p1 deber ser 3.2", 3.2, p1.getX(),0.001);
		assertEquals("La coordenada y del punto p1 deber ser 7.0", 7.0, p1.getY(),0.001);
	}

	
	@Test
	public void testGetSetY() {
			
		Punto p1 = new Punto(5.0,7.0);
		p1.setY(3.2);
		assertEquals("La coordenada x del punto p1 deber ser 5.0", 5.0, p1.getX(),0.001);
		assertEquals("La coordenada y del punto p1 deber ser 3.2", 3.2, p1.getY(),0.001);
	}
	
	@Test
	public void testGetCoordRadial() {
			
		Punto p1 = new Punto(7.5,3.2);
		assertEquals("La coordenada radial de p1 es 8.15414", 8.15414, p1.getCoordRadial(),0.001);
		
		Punto p2 = new Punto(-3.4,0);
		assertEquals("La coordenada radial de p2 es 3.4", 3.4, p2.getCoordRadial(),0.001);
		
		Punto p3 = new Punto(-3.4,3.2);
		assertEquals("La coordenada radial de p3 es 4.669047", 4.669047, p3.getCoordRadial(),0.001);
		
		Punto p4 = new Punto(-5.77,-4.5);
		assertEquals("La coordenada radial de p4 es 7.317301", 7.317301, p4.getCoordRadial(),0.001);
		
		Punto p5 = new Punto(0,6.3);
		assertEquals("La coordenada radial de p5 es 6.3", 6.3, p5.getCoordRadial(),0.001);
		
		Punto p6 = new Punto(0,-9.8);
		assertEquals("La coordenada radial de p6 es 9.8", 9.8, p6.getCoordRadial(),0.001);
		
		Punto p7 = new Punto(0,0);
		assertEquals("La coordenada radial de p7 es 0", 0, p7.getCoordRadial(),0.001);
		
	}	
	
	@Test
	public void testGetCoordAngular() {
			
		Punto p1 = new Punto(7.5,3.2);
		assertEquals("La coordenada angular de p1 es 0.40328", 0.40328, p1.getCoordAngular(),0.001);
		
		Punto p2 = new Punto(-3.4,0);
		assertEquals("La coordenada angular de p2 es 3.14159", 3.14159, p2.getCoordAngular(),0.001);
		
		Punto p3 = new Punto(-3.4,3.2);
		assertEquals("La coordenada angular de p3 es 2.38649", 2.38649, p3.getCoordAngular(),0.001);
		
		Punto p4 = new Punto(-5.77,-4.5);
		assertEquals("La coordenada angular de p4 es -2.47923", -2.47923, p4.getCoordAngular(),0.001);
		
		Punto p5 = new Punto(0,6.3);
		assertEquals("La coordenada angular de p5 es 1.5708", 1.5708, p5.getCoordAngular(),0.001);
		
		Punto p6 = new Punto(0,-9.8);
		assertEquals("La coordenada angular de p6 es -1.5708", -1.5708, p6.getCoordAngular(),0.001);
		
		Punto p7 = new Punto(0,0);
		assertEquals("La coordenada angular de p7 es 0", 0, p7.getCoordAngular(),0.001);
		
	}

	@Test
	public void testSetCoordRadial() {
			
		Punto p1 = new Punto(7.5,3.2);
		p1.setCoordRadial(4.2);
		assertEquals("La coordenada radial de p1 es 4.2", 4.2, p1.getCoordRadial(),0.001);
		assertEquals("La coordenada x de p1 es 3.86307", 3.86307, p1.getX(),0.001);
		assertEquals("La coordenada y de p1 es 1.64824", 1.64824, p1.getY(),0.001);
		
		Punto p2 = new Punto(-3.4,-2);
		p2.setCoordRadial(50.9);
		assertEquals("La coordenada radial de p2 es 50.9", 50.9, p2.getCoordRadial(),0.001);
		assertEquals("La coordenada x de p2 es -43.87245", -43.87245, p2.getX(),0.001);
		assertEquals("La coordenada y de p2 es -25.8073", -25.8073, p2.getY(),0.001);
		
	}

	@Test
	public void testSetCoordAngular() {
			
		Punto p1 = new Punto(7.5,3.2);
		p1.setCoordAngular(0.78538);
		assertEquals("La coordenada angular de p1 es 0.78538",0.78538, p1.getCoordAngular(),0.001);
		assertEquals("La coordenada x de p1 es 5.76595", 5.76595, p1.getX(),0.001);
		assertEquals("La coordenada y de p1 es 5.76574", 5.76574, p1.getY(),0.001);
		
		Punto p2 = new Punto(-3.4,-2);
		p2.setCoordAngular(-0.52358);
		assertEquals("La coordenada angular de p2 es -0.52358", -0.52358, p2.getCoordAngular(),0.001);
		assertEquals("La coordenada x de p2 es 3.4161", 3.4161, p2.getX(),0.001);
		assertEquals("La coordenada y de p2 es -1.97224", -1.97224, p2.getY(),0.001);
		
	}
	
	@Test
	public void testSumarCoordenadas() {
			
		Punto p1 = new Punto(7.5,3.2);
		Punto p2 = new Punto();
		p1.sumarCoordenadas(p2);
		assertEquals("La coordenada x de p1 es 7.5", 7.5, p1.getX(),0.001);
		assertEquals("La coordenada y de p1 es 3.2", 3.2, p1.getY(),0.001);
		
		Punto p3 = new Punto(2.4,-4.2);
		p1.sumarCoordenadas(p3);
		assertEquals("La coordenada x de p1 es 9.9", 9.9, p1.getX(),0.001);
		assertEquals("La coordenada y de p1 es -1.0", -1.0, p1.getY(),0.001);
		
		Punto p4 = new Punto(-2.9,2.0);
		p1.sumarCoordenadas(p4);
		assertEquals("La coordenada x de p1 es 7.0", 7.0, p1.getX(),0.001);
		assertEquals("La coordenada y de p1 es 1.0", 1.0, p1.getY(),0.001);
		
	}
}
