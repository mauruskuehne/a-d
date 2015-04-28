package zbw.stack;

import org.junit.Before;
import org.junit.Test;

import zbw.simpleList.Element;
import ch.zbw.kuehne.Stack_ImplArray;
import ch.zbw.kuehne.Stack_ImplListe;
import junit.framework.TestCase;

public class TestStackJUnit extends TestCase {
	
	private Stack myStack;
	
	
	public TestStackJUnit()
	{
		super();
		
	}

	@Before
	public void setUp()
	{
		myStack = new Stack_ImplArray();
//		myStack = new Stack_ImplListe();
	}
	
	@Test
	public void testEmpty()
	{
		assertEquals(true, myStack.empty());	
		assertEquals(null, myStack.pop());
		myStack.push(new Element(33,"Genf"));
		assertEquals(false, myStack.empty());	

		
	}

@Test
	public void testPush()
	{
		assertEquals(true, myStack.push(new Element(2,"Basel")));	
		assertEquals(2 , myStack.top().getId());	
		assertEquals(true, myStack.push(new Element(4,"Wil")));	
		assertEquals(true, myStack.push(new Element(27,"Chur")));	
		assertEquals(27, myStack.top().getId());	

	}

@Test
	public void testPop()
	{
		// lesen im leeren Stack
		assertEquals(null,myStack.pop());
	
		assertEquals(true, myStack.push(new Element(2,"Basel")));	
		assertEquals(true, myStack.push(new Element(4,"Wil")));	
		assertEquals(true, myStack.push(new Element(27,"Chur")));
		assertEquals(27,myStack.top().getId());
		assertEquals("Chur",myStack.pop().getName());
		assertEquals(4,myStack.pop().getId());
		assertEquals(2,myStack.pop().getId());
		
		// leerer Stack
		assertEquals(null,myStack.pop());
		assertEquals(null,myStack.top());
	}

@Test
public void testTop()
{
	// lesen im leeren Stack
	assertEquals(null,myStack.top());

	assertEquals(true, myStack.push(new Element(2,"Basel")));	
	assertEquals(true, myStack.push(new Element(4,"Wil")));	
	assertEquals(true, myStack.push(new Element(27,"Chur")));
	assertEquals(27,myStack.top().getId());
	assertEquals(27,myStack.pop().getId());
	assertEquals(4,myStack.top().getId());
	assertEquals(4,myStack.pop().getId());
	assertEquals(2,myStack.pop().getId());
	
	// Stack leer
	assertEquals(null,myStack.top());

}
		
}
