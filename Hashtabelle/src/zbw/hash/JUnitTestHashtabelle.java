package zbw.hash;

import org.junit.Before;
import org.junit.Test;

import ch.zbw.kuehne.HashtabelleImpl;
import junit.framework.TestCase;


public class JUnitTestHashtabelle extends TestCase {

	private HashtabelleImpl myTab;
	
	
	public JUnitTestHashtabelle()
	{
		super();
		
	}

	@Before
	public void setUp()
	{
		myTab = new HashtabelleImpl();
	}
	
	@Test
	public void testInsert()
	{
		assertTrue( myTab.put(new Element("Meier","St.Gallen")));	
		assertTrue(myTab.put(new Element("Wagner","Wil")));	
		assertEquals("Wil", myTab.get("Wagner").getName());	
		assertEquals("St.Gallen", myTab.get("Meier").getName());		
		assertTrue(myTab.put(new Element("Müller","Gossau")));	
		assertEquals("Gossau", myTab.get("Müller").getName());	
	}
	
	@Test
	public void testDoppelteEintraege()
	{
	
		assertTrue(myTab.put(new Element("Wagner","Wil")));		
		assertTrue(myTab.put(new Element("Müller","Gossau")));	
		assertEquals("Gossau", myTab.get("Müller").getName());	
		assertFalse(myTab.put(new Element("Müller","Gossau")));	
		assertTrue( myTab.put(new Element("Meier","St.Gallen")));
		assertFalse( myTab.put(new Element("Meier","St.Gallen")));

	}
	
	
	@Test
	public void testGet()
	{
		assertEquals(true, myTab.put(new Element("Meier","St.Gallen")));	
		assertEquals(true, myTab.put(new Element("Wagner","Wil")));	
		assertEquals(true, myTab.put(new Element("Müller","Gossau")));	
		assertEquals("Wil", myTab.get("Wagner").getName());	
		assertEquals("St.Gallen", myTab.get("Meier").getName());		
		assertEquals("Gossau", myTab.get("Müller").getName());	
	}

	
	@Test
	public void testDelete()
	{
		assertEquals(true, myTab.put(new Element("Meier","St.Gallen")));	
		assertEquals(true, myTab.put(new Element("Wagner","Wil")));	
		assertEquals(true, myTab.put(new Element("Müller","Gossau")));	
		assertEquals("Wil", myTab.get("Wagner").getName());	
		assertTrue(myTab.delete("Meier"));	
		assertNull(myTab.get("Meier"));	
		assertFalse(myTab.delete("Meier"));	


	}

}
