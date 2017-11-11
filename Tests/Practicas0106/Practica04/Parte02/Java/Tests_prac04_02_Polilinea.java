import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac04_02_Polilinea {

	@Test
	public void testConstructor() {
		
		Polilinea pl = new Polilinea("polilinea");
		assertEquals("El nombre de pl es polilinea", "polilinea", pl.getNombre());
		assertEquals("El numero de puntos de pl es inicialmente 0", 0, pl.numeroPuntos());

		Polilinea pl2 = new Polilinea("polilinea2");
		assertEquals("El nombre de pl2 es polilinea2", "polilinea2", pl2.getNombre());
		assertEquals("El numero de puntos de pl2 es inicialmente 0", 0, pl2.numeroPuntos());
		
	}
	
	
	
	@Test
	public void testContienePunto() {
		
		Polilinea pl = new Polilinea("polilinea");
		Punto p = new Punto(1.0,1.0);
		assertEquals("Una polilinea recien construida no puede contener ningún punto", false, pl.contienePunto(p));
		
		pl.anyadirPunto(p);
		assertEquals("Al añadir un punto a una polilinea vacía, la polilinea contiene al punto", true, pl.contienePunto(p));
		
		
		for(int i=1;i<15;i++) {
			p = new Punto(i,i);
			pl.anyadirPunto(p);
			assertEquals("Al añadir un punto a una polilinea, la polilinea contiene al punto", true, pl.contienePunto(p));
		}
		
	}
	
	@Test
	public void testAnyadirPunto() {
		
		Polilinea pl = new Polilinea("polilinea");
		Punto p = new Punto(0.0,0.0);
		pl.anyadirPunto(p);
		assertEquals("Un punto previamente añadido a una polilinea no se puede añadir de nuevo", false, pl.anyadirPunto(p));

		for(int i=1;i<15;i++) {
			p = new Punto(i,i);
			pl.anyadirPunto(p);
			assertEquals("Al añadir un punto a una polilinea, la polilinea contiene al punto", true, pl.contienePunto(p));
		}
		
		p = new Punto(15.0,15.0);
		assertEquals("Limite maximo de puntos", false, pl.anyadirPunto(p));
		assertEquals("Limite maximo de puntos", false, pl.contienePunto(p));
		
	}
	
	@Test
	public void testEliminarPunto() {
		
		Polilinea pl = new Polilinea("polilinea");
		Punto p = new Punto(0.0,0.0);
		pl.anyadirPunto(p);
		assertEquals("Si un punto está en la polilinea la función eliminarPunto lo elimina y devuelve true", true, pl.eliminarPunto(p));
		assertEquals("Si un punto está en la polilinea la función eliminarPunto lo elimina y devuelve true", false, pl.contienePunto(p));
		
		
		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl.anyadirPunto(p);
		}
		
		p = new Punto(15.0,15.0);
		assertEquals("Si un punto no está en la polilinea al intentar eliminarlo devuelve false", false, pl.eliminarPunto(p));

		p = new Punto(5.0,5.0);
		assertEquals("Si un punto está en la polilinea la función eliminarPunto lo elimina y devuelve true", true, pl.eliminarPunto(p));
		assertEquals("Si un punto está en la polilinea la función eliminarPunto lo elimina y devuelve true", false, pl.contienePunto(p));
		
		p = new Punto(14,14);
		assertEquals("Si un punto está en la polilinea la función eliminarPunto lo elimina y devuelve true", true, pl.eliminarPunto(p));
		assertEquals("Si un punto está en la polilinea la función eliminarPunto lo elimina y devuelve true", false, pl.contienePunto(p));
		
	}
	
	@Test
	public void testNumeroPuntos() {
		
		Polilinea pl = new Polilinea("polilinea");
		assertEquals("La polilinea vacía contiene 0 puntos", 0, pl.numeroPuntos());
		Punto p;
		
		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl.anyadirPunto(p);
			assertEquals("Al añadir un punto, el número de puntos aumenta en 1", i+1, pl.numeroPuntos());
		}
		
		p = new Punto(15.0,15.0);
		pl.anyadirPunto(p);
		assertEquals("Si no podemos añadir un punto, el número de puntos no varía", 15, pl.numeroPuntos());

		for(int i=14;i>=0;i--) {
			p = new Punto(i,i);
			pl.eliminarPunto(p);
			assertEquals("Al eliminar un punto, el número de puntos disminuye en 1", i, pl.numeroPuntos());
		}
		
	}
	
	

	@Test
	public void testEstanAlineados() {
	
		Polilinea pl = new Polilinea("polilinea");
		assertEquals("En una polilinea vacía todos los puntos están alineados", true, pl.estanAlineados());
		
		Punto p;
		p = new Punto(0,0);
		pl.anyadirPunto(p);
		assertEquals("En una polilinea con un punto, todos los puntos están alineados", true, pl.estanAlineados());
		
		p = new Punto(1,1);
		p.setCoordAngular(0);
		pl.anyadirPunto(p);
		assertEquals("En una polilinea con dos punto, todos los puntos están alineados", true, pl.estanAlineados());
		
		for(int i=2;i<13;i++) {
			p = new Punto(i,i);
			p.setCoordRadial(i*i);
			p.setCoordAngular(0);
			pl.anyadirPunto(p);
			assertEquals("Los puntos de esta polilinea están alineados", true, pl.estanAlineados());
		}
		
		p = new Punto(-1,-5);
		pl.anyadirPunto(p);
		assertEquals("Los puntos de esta polilinea no están alineados", false, pl.estanAlineados());
		
	}
	
	
	@Test
	public void testPuntoMasAlejado() {
		
		Polilinea pl = new Polilinea("polilinea");
		
		assertEquals("El punto mas alejado de la polilinea vacía es null", null, pl.puntoMasAlejado());
		
		
		Punto p;
		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl.anyadirPunto(p);
		}
		assertEquals("El punto mas alejado de la polilinea es el (14,14)", 14, pl.puntoMasAlejado().getX(),0.0001);
		assertEquals("El punto mas alejado de la polilinea es el (14,14)", 14, pl.puntoMasAlejado().getY(),0.0001);
		
		Polilinea pl2 = new Polilinea("polilinea");
		for(int i=30;i>=16;i--) {
			p = new Punto(i,i);
			pl2.anyadirPunto(p);
		}
		assertEquals("El punto mas alejado de la polilinea pl2 es el (30,30)", 30, pl2.puntoMasAlejado().getX(),0.0001);
		assertEquals("El punto mas alejado de la polilinea pl2 es el (30,30)", 30, pl2.puntoMasAlejado().getY(),0.0001);
		
		
		
	}


	@Test
	public void testPuntoMasCercano() {
		Polilinea pl = new Polilinea("polilinea");
		

		assertEquals("El punto mas cercano de la polilinea vacía es null", null, pl.puntoMasCercano());
		
		Punto p;
		for(int i=0;i<15;i++) {
			p = new Punto(i,i);
			pl.anyadirPunto(p);
		}
		assertEquals("El punto mas cercano de la polilinea es el (0,0)", 0, pl.puntoMasCercano().getX(),0.0001);
		assertEquals("El punto mas cercano de la polilinea es el (0,0)", 0, pl.puntoMasCercano().getY(),0.0001);
		
		Polilinea pl2 = new Polilinea("polilinea");
		for(int i=30;i>=16;i--) {
			p = new Punto(i,i);
			pl2.anyadirPunto(p);
		}
		assertEquals("El punto mas cercano de la polilinea pl2 es el (16,16)", 16, pl2.puntoMasCercano().getX(),0.0001);
		assertEquals("El punto mas cercano de la polilinea pl2 es el (16,16)", 16, pl2.puntoMasCercano().getY(),0.0001);
		
		
	}



}
