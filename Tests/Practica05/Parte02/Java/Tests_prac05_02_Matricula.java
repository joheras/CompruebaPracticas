import static org.junit.Assert.*;

import java.util.OptionalDouble;

import org.junit.Test;

public class Tests_prac05_02_Matricula {
	
	
	@Test
	public void testConstructor() {
		Estudiante e1 = new Estudiante("peperez",true);
		Actividad a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Matricula m = new Matricula(a1, e1, Curso.C1718, OrdenMatricula.M1,50);
		
		
		assertEquals("La cuasi del estudiante debe ser peperez", "peperez", m.getEstudiante().getCuasi());
		assertEquals("El estudiante pertenece a una familia numerosa", true, m.getEstudiante().getFamiliaNumerosa());
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", m.getActividad().getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, m.getActividad().getCreditos());
		assertEquals("El curso es 17/18", Curso.C1718, m.getCurso());
		assertEquals("Es primera matrícula", OrdenMatricula.M1, m.getOrdenMatricula());	
		
	}

	@Test
	public void testPrecioFamiliaNoNumerosaPrimeraMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M1,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M1,10);
			
		assertEquals("Precio familia no numerosa, primera matricula es precio por nº créditos",127.26, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, primera matricula es precio por nº créditos",20, m2.getPrecio(),0.0001);
		
	}
	
	@Test
	public void testPrecioFamiliaNoNumerosaSegundaMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M2,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M2,10);
			
		assertEquals("Precio familia no numerosa, segunda matricula es precio por nº créditos por 2",254.52, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, segunda matricula es precio por nº créditos por 2",40, m2.getPrecio(),0.0001);
		 
	}
	
	@Test
	public void testPrecioFamiliaNoNumerosaTerceraMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M3,10);
			
		assertEquals("Precio familia no numerosa, tercera matricula es precio por nº créditos por 4.4",559.944, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, tercera matricula es precio por nº créditos por 4.4",88, m2.getPrecio(),0.0001);
		 
	}
	
	@Test
	public void testPrecioFamiliaNoNumerosaCuartaMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M4,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M4,10);
			
		assertEquals("Precio familia no numerosa, cuarta matricula es precio por nº créditos por 6",763.56, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, cuarta matricula es precio por nº créditos por 6",120, m2.getPrecio(),0.0001);
		 
	}
	
	@Test
	public void testPrecioFamiliaNumerosa() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Actividad act3 = new Asignatura("TP",5, 2010, Tipo.Obligatoria);
		Actividad act4 = new Reconocimiento("Deportes", 4, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",true);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M1,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M2,10);
		Matricula m3 = new Matricula(act3, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m4 = new Matricula(act4, est1, Curso.C1718,OrdenMatricula.M4,10);
			
		assertEquals("Precio familia numerosa, primera matricula es precio por nº créditos por 0.5 ",63.63, m1.getPrecio(),0.0001);
		assertEquals("Precio familia numerosa, segunda matricula es precio por nº créditos por 2 por 0.5",20, m2.getPrecio(),0.0001);
		assertEquals("Precio familia numerosa, tercera matricula es precio por nº créditos por 4.4 por 0.5",233.31, m3.getPrecio(),0.0001);
		assertEquals("Precio familia numerosa, cuarta matricula es precio por nº créditos por 6 por 0.5",120, m4.getPrecio(),0.0001);
		 
	}
	
	
	@Test
	public void testCalificacionVacia() {
		Actividad act1 = new Reconocimiento("Deportes", 4, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",true);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M1,10);
		
		assertEquals("Al construir una matricula su calificación debe estar vacía ",OptionalDouble.empty(), m1.getCalificacion());
		
	}
	

	
	
	
	
	

}
