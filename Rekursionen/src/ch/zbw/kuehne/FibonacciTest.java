package ch.zbw.kuehne;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testFibonacci() {
		assertEquals(5, Fibonacci.Fibonacci(5));
	}

	@Test
	public void testFibonacci2() {
		assertEquals(55, Fibonacci.Fibonacci(10));
	}
	
	@Test
	public void testFibonacci3() {
		assertEquals(1, Fibonacci.Fibonacci(1));
	}
}
