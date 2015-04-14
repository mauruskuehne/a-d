package ch.zbw.kuehne;

import static org.junit.Assert.*;

import org.junit.Test;

public class HanoiTest {

	@Test
	public void testHanoi() {
		//fail("Not yet implemented");
		
		assertEquals(7, Hanoi.ZeitZumVerschieben(3, 'A', 'B', 'C'));
		
	}

}
