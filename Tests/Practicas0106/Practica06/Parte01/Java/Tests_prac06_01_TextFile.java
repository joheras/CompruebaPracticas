import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac06_01_TextFile {

	@Test
	public void testConstructorAndGetters() {
		
		TextFile tf = new TextFile("test","Fichero de texto");
		assertEquals("El nombre de tf es test", "test", tf.getName());
		assertEquals("El inode de tf es 5", 5, tf.getInode());
		assertArrayEquals("Los permisos de tf son 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-'", 
				new char [] { 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-' }, tf.getPermissions());
		assertEquals("El contenido de tf es: Fichero de texto", 
				"Fichero de texto", tf.getContent());
		
		
		
	}
	
	@Test	
	public void testSetContent() {
		
		TextFile tf = new TextFile("test","Fichero de texto");
		String name = tf.getName();
		int iNode = tf.getInode();
		char[] permissions = tf.getPermissions();
		tf.setContent("New content");
		assertEquals("El nombre de tf no cambia", name,tf.getName());
		assertEquals("El inode de tf no cambia", iNode, tf.getInode());
		assertArrayEquals("Los permisos de tf no cambian",permissions, tf.getPermissions());
		assertEquals("El contenido de tf cambia","New content", tf.getContent());
		
	}
	
}
