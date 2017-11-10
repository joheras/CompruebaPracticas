import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac06_01_Directory {

	@Test
	public void testConstructorAndGetters() {
		
		Directory dir = new Directory("test");
		assertEquals("El nombre de dir es test", "test", dir.getName());
		assertEquals("El inode de dir es 11", 11, dir.getInode());
		assertArrayEquals("Los permisos de dir son 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-'", 
				new char [] { 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-' }, dir.getPermissions());
	
	}
	
	@Test	
	public void testAddFilesSearchFile() {
		
		Directory dir = new Directory("test");
		TextFile tf1 = new TextFile("file1", "");
		assertEquals("El primer fichero se añade correctamente", true, dir.addFile(tf1));
		assertNotEquals("El primer fichero se ha añadido correctamente", null, dir.searchFile(tf1.getName()));
		
		TextFile tf2 = new TextFile("file2", "");
		assertEquals("El segundo fichero se añade correctamente", true, dir.addFile(tf2));
		assertNotEquals("El segundo fichero se ha añadido correctamente", null, dir.searchFile(tf2.getName()));
		
		TextFile tf3 = new TextFile("file3", "");
		assertEquals("El tercer fichero se añade correctamente", true, dir.addFile(tf3));
		assertNotEquals("El tercer fichero se ha añadido correctamente", null, dir.searchFile(tf3.getName()));
		
		TextFile tf4 = new TextFile("file4", "");
		assertEquals("El cuarto fichero se añade correctamente", true, dir.addFile(tf4));
		assertNotEquals("El cuarto fichero se ha añadido correctamente", null, dir.searchFile(tf4.getName()));
		
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del primero", false, dir.addFile(tf1));
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del segundo", false, dir.addFile(tf2));
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del tercero", false, dir.addFile(tf3));
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del cuarto", false, dir.addFile(tf4));
		
	}
	
	
	@Test	
	public void testDeleteFilesSearchFile() {
		
		Directory dir = new Directory("test");
		TextFile tf1 = new TextFile("file1", "");
		dir.addFile(tf1);
		TextFile tf2 = new TextFile("file2", "");
		dir.addFile(tf2);
		TextFile tf3 = new TextFile("file3", "");
		dir.addFile(tf3);
		TextFile tf4 = new TextFile("file4", "");
		dir.addFile(tf4);
		TextFile tf5 = new TextFile("file5", "");
		dir.addFile(tf5);
		
		
		
		assertEquals("Eliminamos el fichero file3", true, dir.removeFile(tf3.getName()) );
		assertEquals("El fichero file3 se ha eliminado correctamente", null, dir.searchFile(tf3.getName()));
		assertEquals("Eliminamos el fichero file5", true, dir.removeFile(tf5.getName()) );
		assertEquals("El fichero file5 fichero se ha eliminado correctamente", null, dir.searchFile(tf5.getName()));
		assertEquals("Eliminamos el fichero file1", true, dir.removeFile(tf1.getName()) );
		assertEquals("El fichero file1 se ha eliminado correctamente", null, dir.searchFile(tf1.getName()));
		assertEquals("Eliminamos el fichero file2", true, dir.removeFile(tf2.getName()) );
		assertEquals("El fichero file2 se ha eliminado correctamente", null, dir.searchFile(tf2.getName()));
		assertEquals("Eliminamos el fichero file4", true, dir.removeFile(tf4.getName()) );
		assertEquals("El fichero file4 se ha eliminado correctamente", null, dir.searchFile(tf4.getName()));
		
		assertEquals("Intentamos eliminar de nuevo el fichero file4", false, dir.removeFile(tf4.getName()) );
	}
	
}
