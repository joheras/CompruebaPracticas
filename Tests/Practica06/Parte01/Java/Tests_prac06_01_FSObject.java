import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_prac06_01_FSObject {

	@Test
	public void testConstructorAndGetters() {
		
		FSObject fso = new FSObject("test");
		assertEquals("El nombre de fso es test", "test", fso.getName());
		assertEquals("El inode de fso es 0", 0, fso.getInode());
		assertArrayEquals("Los permisos de fso son 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-'", 
				new char [] { 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-' }, fso.getPermissions());
		
		FSObject fso1 = new FSObject("test1");
		assertEquals("El nombre de fso1 es test1", "test1", fso1.getName());
		assertEquals("El inode de fso1 es 1", 1, fso1.getInode());
		assertArrayEquals("Los permisos de fso1 son 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-'", 
				new char [] { 'r', 'w', '-', 'r', 'w', '-', 'r', 'w', '-' }, fso1.getPermissions());
		
	}
	
	@Test	
	public void testSetName() {
		
		FSObject fso = new FSObject("test");
		fso.setName("test2");
		int iNode = fso.getInode();
		char[] permissions = fso.getPermissions();
		assertEquals("El nombre de fso es test2", "test2", fso.getName());
		assertEquals("El inode de fso no cambia", iNode, fso.getInode());
		assertArrayEquals("Los permisos de fso no cambian",permissions, fso.getPermissions());
		
	}
	
	
	@Test	
	public void testSetPermissions() {
		
		FSObject fso = new FSObject("test");

		String name = fso.getName();
		int iNode = fso.getInode();
		fso.setPermissions(new char [] { 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r' });
		assertEquals("El nombre de fso no cambia", name, fso.getName());
		assertEquals("El inode de fso no cambia", iNode, fso.getInode());
		assertArrayEquals("Los permisos han cambiado",new char [] { 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r' }, fso.getPermissions());
		
	}

}
