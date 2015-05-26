package zbw;

import org.junit.Before;
import org.junit.Test;

import ch.zbw.kuehne.TreeImpl;
import junit.framework.TestCase;

public class TreeTestJunit extends TestCase {
	
	private TreeImpl baum;
	
	public  TreeTestJunit()
	{
		
	}
	@Before
	public void setUp()
	{
		baum = new TreeImpl();
		baum.insert(new Element(10,"Bern"));
		baum.insert(new Element(2,"Zürich"));
		baum.insert(new Element(17,"Basel"));
		baum.insert(new Element(19,"Genf"));
		baum.insert(new Element(12,"Chur"));
		baum.insert(new Element(4,"Luzern"));
	}
		
	@Test
	public void testCreate()
	{
		
		baum.show();
	}
	
	@Test
	public void testSearch()
	{
		assertEquals(null,baum.search(77));
		assertEquals("Bern",(baum.search(10)).getName());
		assertEquals("Chur",(baum.search(12)).getName());
		
	}
	
	@Test
	public void testInsert()
	{
		assertEquals(null,baum.search(77));
		assertEquals("Bern",(baum.search(10)).getName());
		assertEquals("Chur",(baum.search(12)).getName());
		assertTrue(baum.insert(new Element(3,"Wil")));
		assertEquals(3,(baum.search(3)).getId());
	
		
	}
	
	@Test
	public void testdelete()
	{

		System.out.println("-------LOESCHEN VORHER---------"); 
		baum.show();
		
		//Blatt löschen
		baum.delete(4);
		assertEquals(null,baum.search(4));
		
		System.out.println("-------Nach lšschen NR 4---------"); 
		baum.show();
		
		// Knoten mit 2 Nachfolger löschen
		baum.delete(17);
		assertEquals(null,baum.search(17));
		assertEquals("Chur",baum.search(12).getName());
		
		System.out.println("-------Nach lšschen NR 17---------"); 
		baum.show();
		
		//Knoten mit einem Nachfolger löschen
		baum.delete(19);
		assertEquals(null,baum.search(19));
		//Wurzel löschen
		
		System.out.println("-------Nach lšschen NR 19---------"); 
		baum.show();
		
		baum.delete(10);
		assertEquals(null,baum.search(10));
		assertEquals("Zürich",baum.search(2).getName());
		
		System.out.println("-------LOESCHEN NACHHER---------"); 
		baum.show();
		
	}
	
	@Test
	public void testHeight()
	{
		assertEquals(3,baum.height());
		
	}
	
	@Test
	public void testLength()
	{
		assertEquals(3,baum.height());
		
	}
	
	@Test
	public void testSearch2()
	{
		assertEquals(null,baum.search2(77));
		assertEquals("Bern",(baum.search2(10)).getName());
		assertEquals("Chur",(baum.search2(12)).getName());
		
	}
	


}
