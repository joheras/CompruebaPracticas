import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac06_01_FileManager {

	
	@Test	
	public void testAddFilesSearchDirectory() {
		
		Directory tf1 = new Directory("file1");
		assertEquals("El primer fichero se añade correctamente", true, FileManager.addDirectory(tf1));
		assertNotEquals("El primer fichero se ha añadido correctamente", null, FileManager.searchDirectory(tf1.getName()));
		
		Directory tf2 = new Directory("file2");
		assertEquals("El segundo fichero se añade correctamente", true, FileManager.addDirectory(tf2));
		assertNotEquals("El segundo fichero se ha añadido correctamente", null, FileManager.searchDirectory(tf2.getName()));
		
		Directory tf3 = new Directory("file3");
		assertEquals("El tercer fichero se añade correctamente", true, FileManager.addDirectory(tf3));
		assertNotEquals("El tercer fichero se ha añadido correctamente", null, FileManager.searchDirectory(tf3.getName()));
		
		Directory tf4 = new Directory("file4");
		assertEquals("El cuarto fichero se añade correctamente", true, FileManager.addDirectory(tf4));
		assertNotEquals("El cuarto fichero se ha añadido correctamente", null, FileManager.searchDirectory(tf4.getName()));
		
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del primero", false, FileManager.addDirectory(tf1));
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del segundo", false, FileManager.addDirectory(tf2));
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del tercero", false, FileManager.addDirectory(tf3));
		assertEquals("No podemos añadir de nuevo un fichero con el nombre del cuarto", false, FileManager.addDirectory(tf4));
		
	}
	
	
	@Test	
	public void testDeleteFilesSearchFile() {
		
		Directory dir = new Directory("test");
		Directory tf1 = new Directory("file1");
		FileManager.addDirectory(tf1);
		Directory tf2 = new Directory("file2");
		FileManager.addDirectory(tf2);
		Directory tf3 = new Directory("file3");
		FileManager.addDirectory(tf3);
		Directory tf4 = new Directory("file4");
		FileManager.addDirectory(tf4);
		Directory tf5 = new Directory("file5");
		FileManager.addDirectory(tf5);
		
		
		
		assertEquals("Eliminamos el fichero file3", true, FileManager.removeDirectory(tf3.getName()) );
		assertEquals("El fichero file3 se ha eliminado correctamente", null, FileManager.searchDirectory(tf3.getName()));
		assertEquals("Eliminamos el fichero file5", true, FileManager.removeDirectory(tf5.getName()) );
		assertEquals("El fichero file5 fichero se ha eliminado correctamente", null, FileManager.searchDirectory(tf5.getName()));
		assertEquals("Eliminamos el fichero file1", true, FileManager.removeDirectory(tf1.getName()) );
		assertEquals("El fichero file1 se ha eliminado correctamente", null, FileManager.searchDirectory(tf1.getName()));
		assertEquals("Eliminamos el fichero file2", true, FileManager.removeDirectory(tf2.getName()) );
		assertEquals("El fichero file2 se ha eliminado correctamente", null, FileManager.searchDirectory(tf2.getName()));
		assertEquals("Eliminamos el fichero file4", true, FileManager.removeDirectory(tf4.getName()) );
		assertEquals("El fichero file4 se ha eliminado correctamente", null, FileManager.searchDirectory(tf4.getName()));
		
		assertEquals("Intentamos eliminar de nuevo el fichero file4", false, FileManager.removeDirectory(tf4.getName()) );
	}
	
}
