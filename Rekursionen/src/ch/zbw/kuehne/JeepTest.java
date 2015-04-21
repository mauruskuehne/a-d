package ch.zbw.kuehne;

import static org.junit.Assert.*;

import org.junit.Test;

public class JeepTest {

	@Test
	public void test() {
		assertEquals(800, Jeep.MaxReichweite(1, 40, 5), 5);
	}

}
