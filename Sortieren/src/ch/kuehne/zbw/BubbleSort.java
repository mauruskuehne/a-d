package ch.kuehne.zbw;

import zbw.Isorter;

public class BubbleSort implements Isorter{

	@Override
	public void sort(int[] zahlen) {
		for (int i = zahlen.length - 1; i > 0; i--) {
			//i = Position bis wohin wir sortiert haben
			
			boolean didChangeAPosition = false;
			
			for (int j = 1; j <= i; j++) {
				//j = nŠchste zu prŸfende Position
				
				//ist nŠchstes Element kleiner?
				//wenn ja, j-1 eins weiter schieben
				if(zahlen[j] < zahlen[j - 1]) {
					
					//Tauschen
					int oldVal = zahlen[j - 1];
					zahlen[j - 1] = zahlen[j];
					zahlen[j] = oldVal;
					didChangeAPosition = true;
				}
			}
			if(!didChangeAPosition) 
				return;
		}
	}

}
