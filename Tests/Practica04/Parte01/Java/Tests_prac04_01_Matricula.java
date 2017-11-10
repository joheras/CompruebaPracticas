import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac04_01_Matricula {

	@Test
	public void testConstructor() {
		Estudiante e1 = new Estudiante("peperez",true);
		Asignatura a1 = new Asignatura("POO",6,701);
		Matricula m = new Matricula(a1, e1, Curso.C1718, OrdenMatricula.M1);
		
		
		assertEquals("La cuasi del estudiante debe ser peperez", "peperez", m.getEstudiante().getCuasi());
		assertEquals("El estudiante pertenece a una familia numerosa", true, m.getEstudiante().getFamiliaNumerosa());
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", m.getAsignatura().getNombre());
		assertEquals("El número de creditos de la asignatura a1 debe ser 6", 6, m.getAsignatura().getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, m.getAsignatura().getPlanEstudios());
		assertEquals("El curso es 17/18", Curso.C1718, m.getCurso());
		assertEquals("Es primera matrícula", OrdenMatricula.M1, m.getOrdenMatricula());
		
		
	}

}
