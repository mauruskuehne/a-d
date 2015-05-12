package ch.kuehne.zbw;

import zbw.Isorter;

public class ShellSort implements Isorter {

	@Override
	public void sort(int[] zahlen) {
		int maxSteps = 10;
		int[] steps = new int[maxSteps];
		
		//Schritte errechnen
		for(int i = 0; i < maxSteps; i++) {
			if(i == 0) steps[i] = 1;
			else steps[i] = (steps[i - 1] * 3) + 1;
		}
		
		//Jede Schrittstufe 1x ausfŸhren (step[9]er Schritte, step[8]er Schritte...
		for(int i = maxSteps - 1; i >= 0; i--) {
			
			
			for(int j = 0; j < steps[i]; j++) {
				sortwithStep(zahlen, j, steps[i]);
			}
			
		}
		
	}

	private void sortwithStep(int[] zahlen, int offset, int step) {
		
		for(int i = offset; i < zahlen.length; i+= step) {
			//i = Erstes nicht sortiertes Element
			int j = 0;
			int tmp = zahlen[i];
			for(j = i; j > offset && tmp < zahlen[j - step]; j-=step) {
				//j == aktuell rŸckwŠrts zu suchende position
				
				zahlen[j] = zahlen[j - step];
			}
			zahlen[j] = tmp;
		}
	}
}
