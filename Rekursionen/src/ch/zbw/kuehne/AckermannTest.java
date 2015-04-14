package ch.zbw.kuehne;

import static org.junit.Assert.*;

import org.junit.Test;

public class AckermannTest {

	@Test
	public void testAckermann() {
		assertEquals(8189, Ackermann.Ackermann(3, 10));	
	}

}
