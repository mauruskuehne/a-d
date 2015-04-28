package zbw.simpleList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ch.zbw.kuehne.*;

public class JUnitTestListe {

	private Liste liste = null;
	@Before
	public void setUp() throws Exception {
		//liste = new ArListe();
		liste = new DoppeltLinkedList();
	
	}

	@Test
	public void testInsertFirst() {
		assertTrue(liste.insertFirst(new Element(2,"Wil")));
		assertTrue(liste.insertFirst(new Element(4,"Chur")));
		assertEquals(4,liste.getFirst().getId());
		assertEquals(2,liste.getLast().getId());
	}
	
	
	@Test
	public void testEmpty() {
		assertTrue(liste.empty());
		assertTrue(liste.insertFirst(new Element(4,"Chur")));
		assertFalse(liste.empty());
		
	}
	
	@Test
	public void testGetFirst() {
		
		assertNull(liste.getFirst());
		
		assertTrue(liste.insertFirst(new Element(4,"Chur")));
		assertTrue(liste.insertFirst(new Element(2,"Wil")));
		assertTrue(liste.insertFirst(new Element(6,"Genf")));
		
		assertEquals(6,liste.getFirst().getId());
	}
	
	@Test
	public void testGetLast() {
		
		assertNull(liste.getLast());
		
		assertTrue(liste.insertFirst(new Element(4,"Chur")));
		assertTrue(liste.insertFirst(new Element(2,"Wil")));
		assertTrue(liste.insertFirst(new Element(6,"Genf")));
		
		assertEquals(4,liste.getLast().getId());
	}
	
	@Test
	public void testInsertLast() {
		assertTrue(liste.insertLast(new Element(2,"Wil")));
		assertTrue(liste.insertLast(new Element(4,"Chur")));
		assertEquals(2,liste.getFirst().getId());
		assertEquals(4,liste.getLast().getId());
	}
	
	@Test
	public void testSearch() {
		
		assertNull(liste.search(4));
		
		assertTrue(liste.insertFirst(new Element(4,"Chur")));
		assertTrue(liste.insertFirst(new Element(2,"Wil")));
		assertTrue(liste.insertFirst(new Element(3,"Bern")));
		assertTrue(liste.insertFirst(new Element(6,"Genf")));
		
		assertEquals("Chur",liste.search(4).getName());
		assertEquals("Genf",liste.search(6).getName());
		assertEquals("Genf",liste.search(6).getName());
		assertEquals("Wil",liste.search(2).getName());
		
		assertNull(liste.search(77));
	}
	
	@Test
	public void testdelete() {
		
		// lösche in leerer Liste
		assertFalse(liste.delete(2));
		
		// lösche Element in einer Liste mit nur einem Element
		assertTrue(liste.insertFirst(new Element(4,"Chur")));
		assertTrue(liste.delete(4));
		
		assertTrue(liste.empty());
		
		assertTrue(liste.insertFirst(new Element(4,"Chur")));
		assertTrue(liste.insertFirst(new Element(2,"Wil")));
		assertTrue(liste.insertFirst(new Element(3,"Bern")));
		assertTrue(liste.insertFirst(new Element(6,"Genf")));
		
		liste.show();
		
		// lösche nicht vorhandenes Element
		assertFalse(liste.delete(23));
	

		// lösche erstes Element
		assertTrue(liste.delete(6));
		
		// lösche letztes Element
		assertTrue(liste.delete(4));
		liste.show();
		assertTrue(liste.delete(2));
		
		assertFalse(liste.empty());
		liste.show();
		assertTrue(liste.delete(3));
		

		assertTrue(liste.empty());

	}
	@Test
	public void testSort() {
		
		assertTrue(liste.insertLast(new Element(4,"Chur")));
		assertTrue(liste.insertLast(new Element(23,"Wil")));
		assertTrue(liste.insertLast(new Element(3,"Bern")));
		assertTrue(liste.insertLast(new Element(10,"Genf")));
		assertTrue(liste.insertLast(new Element(7,"Buchs")));
		assertTrue(liste.insertLast(new Element(16,"Biel")));
		assertTrue(liste.insertLast(new Element(2,"ZŸrich")));
		
		liste.sortieren();
		
		liste.show();
	}
	
	@Test
	public void testchange() {
		// in leerer Liste tauschen
		assertFalse(liste.change(4, 2));
		
		assertTrue(liste.insertLast(new Element(4,"Chur")));
		assertTrue(liste.insertLast(new Element(2,"Wil")));
		assertTrue(liste.insertLast(new Element(3,"Bern")));
		assertTrue(liste.insertLast(new Element(6,"Genf")));
		assertTrue(liste.insertLast(new Element(7,"Buchs")));
		assertTrue(liste.insertLast(new Element(16,"Biel")));
		assertTrue(liste.insertLast(new Element(23,"ZŸrich")));
		

		
		// nicht vorhandene Elemente tauschen
		assertFalse(liste.change(4, 1));
		assertFalse(liste.change(1, 4));
	
		// tauschen von 2 Elemente (nicht am Anfang, nicht aufeinanderfolgend
		assertTrue(liste.change(3, 16));
		System.out.println("Test change");
		liste.show();
		
		// erstes Element tauschen
		assertTrue(liste.change(4, 16));
		assertEquals("Biel",liste.getFirst().getName());
		
		// erstes und zweites Element tauschen
		assertTrue(liste.change(16, 2));
		assertEquals("Wil",liste.getFirst().getName());

		System.out.println("Test change");
		liste.show();
		
		// erstes und letztes Element tauschen
		assertTrue(liste.change(2, 23));
		assertEquals("ZŸrich",liste.getFirst().getName());

	}
	
	@Test
	public void testSublist() {

		assertTrue(liste.insertLast(new Element(4,"Chur")));
		assertTrue(liste.insertLast(new Element(2,"Wil")));
		assertTrue(liste.insertLast(new Element(3,"Bern")));
		assertTrue(liste.insertLast(new Element(6,"Genf")));
		assertTrue(liste.insertLast(new Element(7,"Buchs")));
		assertTrue(liste.insertLast(new Element(16,"Biel")));
		assertTrue(liste.insertLast(new Element(23,"ZŸrich")));
		
		Liste subList = liste.sublist(1, 3);
		
		assertTrue(subList.getFirst().getId() == 2);
		assertTrue(subList.getLast().getId() == 6);
	}
	
	public void testSearchElements() {

		assertTrue(liste.insertLast(new Element(4,"Chur")));
		assertTrue(liste.insertLast(new Element(2,"Wil")));
		assertTrue(liste.insertLast(new Element(3,"Bern")));
		assertTrue(liste.insertLast(new Element(6,"Genf")));
		assertTrue(liste.insertLast(new Element(7,"Buchs")));
		assertTrue(liste.insertLast(new Element(16,"Biel")));
		assertTrue(liste.insertLast(new Element(23,"ZŸrich")));
		
		Liste subList = liste.searchElements(2, 6);
		
		assertTrue(subList.getFirst().getId() == 2);
		assertTrue(subList.getLast().getId() == 6);
		

		subList = liste.searchElements(200, 600);
		
		assertNull(subList);
	}
}
