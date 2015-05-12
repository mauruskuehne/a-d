package zbw;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import ch.kuehne.zbw.BubbleSort;
import ch.kuehne.zbw.Quicksort;
import ch.kuehne.zbw.ShellSort;
import ch.kuehne.zbw.StraightInsertation;
import ch.kuehne.zbw.StraightSelection;

public class TestSortJUNIT {

	private final int MAX=100;
			;
	private int[] zahlen;

	private long s,e;
	
	@Before
	public void setUp() throws Exception {
		Random r = new Random();
		zahlen = new int[MAX];
		
		// Zahlenwerte einfügen
		for(int i=0; i<MAX;i++)
		{
			zahlen[i] = r.nextInt(10 * MAX);
//			zahlen[i] = i;
		}
	}

	@Test
	public void testStraightSelection() {
		
		StraightSelection sorter = new StraightSelection();
		
		s = System.currentTimeMillis();
		sorter.sort(zahlen);
		e = System.currentTimeMillis();
		System.out.println();
		System.out.println("StraightSelection");
		System.out.println("Das Sortieren dauerte "+ (e-s) + " Millisekunden");
		// Ausgabe
		if (MAX <= 1000)
		{
			for(int i=0; i < MAX; i++)
			{
				System.out.print(" " + zahlen[i]);
				if (i%20 == 0 && i > 0)
				{
					System.out.println("");
				}
			}
		}
	}

	@Test
	public void testStraightInsertation() {
		
		StraightInsertation sorter = new StraightInsertation();
		
		s = System.currentTimeMillis();
		sorter.sort(zahlen);
		e = System.currentTimeMillis();
		System.out.println();
		System.out.println("StraightInsertation");
		System.out.println("Das Sortieren dauerte "+ (e-s) + " Millisekunden");
		// Ausgabe
		if (MAX <= 1000)
		{
			for(int i=0; i < MAX; i++)
			{
				System.out.print(" " + zahlen[i]);
				if (i%20 == 0 && i > 0)
				{
					System.out.println("");
				}
			}
		}
	}

	@Test
	public void testBubbleSort() {
		
		BubbleSort sorter = new BubbleSort();
		
		s = System.currentTimeMillis();
		sorter.sort(zahlen);
		e = System.currentTimeMillis();
		System.out.println();
		System.out.println("BubbleSort");
		System.out.println("Das Sortieren dauerte "+ (e-s) + " Millisekunden");
		// Ausgabe
		if (MAX <= 1000)
		{
			for(int i=0; i < MAX; i++)
			{
				System.out.print(" " + zahlen[i]);
				if (i%20 == 0 && i > 0)
				{
					System.out.println("");
				}
			}
		}
	}
	
	@Test
	public void testQuicksort() {
		
		Quicksort sorter = new Quicksort();
		
		s = System.currentTimeMillis();
		sorter.sort(zahlen);
		e = System.currentTimeMillis();
		System.out.println();
		System.out.println("Quicksort");
		System.out.println("Das Sortieren dauerte "+ (e-s) + " Millisekunden");
		// Ausgabe
		if (MAX <= 1000)
		{
			for(int i=0; i < MAX; i++)
			{
				System.out.print(" " + zahlen[i]);
				if (i%20 == 0 && i > 0)
				{
					System.out.println("");
				}
			}
		}
	}
	
	@Test
	public void testShellSort() {
		
		ShellSort sorter = new ShellSort();
		
		s = System.currentTimeMillis();
		sorter.sort(zahlen);
		e = System.currentTimeMillis();
		System.out.println();
		System.out.println("ShellSort");
		System.out.println("Das Sortieren dauerte "+ (e-s) + " Millisekunden");
		// Ausgabe
		if (MAX <= 1000)
		{
			for(int i=0; i < MAX; i++)
			{
				System.out.print(" " + zahlen[i]);
				if (i%20 == 0 && i > 0)
				{
					System.out.println("");
				}
			}
		}
	}

}
