package ch.zbw.kuehne;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testFibonacci() {
		assertEquals(5*4*3*2*1, Fibonacci.Fibonacci(5))
		;
	}

}
