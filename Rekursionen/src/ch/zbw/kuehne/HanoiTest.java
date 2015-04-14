package ch.zbw.kuehne;

import static org.junit.Assert.*;

import org.junit.Test;

public class HanoiTest {

	@Test
	public void testHanoi() {
		//fail("Not yet implemented");
		
		assertEquals(3, Hanoi.ZeitZumVerschieben(2, 'A', 'B', 'C'));
		
	}

}
