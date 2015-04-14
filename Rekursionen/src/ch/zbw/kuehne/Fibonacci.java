package ch.zbw.kuehne;

public class Fibonacci {
	public static int Fibonacci(int zahl) 
	{
		if(zahl == 1) return 1;
		return Fibonacci(zahl - 1) * zahl; 
	}
}
