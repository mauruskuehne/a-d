package ch.kuehne.zbw;

import zbw.Isorter;

public class StraightInsertation implements Isorter {

	@Override
	public void sort(int[] zahlen) {
		// TODO Auto-generated method stub
		
		
		for(int i = 0; i < zahlen.length; i++) {
			//i = Erstes nicht sortiertes Element
			int j = 0;
			int tmp = zahlen[i];
			for(j = i; j > 0 && tmp < zahlen[j - 1]; j--) {
				//j == aktuell rŸckwŠrts zu suchende position
				
				zahlen[j] = zahlen[j - 1];
			}
			zahlen[j] = tmp;
		}
	}

}
