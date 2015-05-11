package ch.kuehne.zbw;

import zbw.Isorter;

public class StraightSelection implements Isorter {

	@Override
	public void sort(int[] zahlen) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < (zahlen.length - 1); i++) {
			int unsortiertAnfang = i;
			
			for(int j = i+1; j < zahlen.length;j++) {
				if(zahlen[j] < zahlen[unsortiertAnfang]) {
					unsortiertAnfang = j;
				}
			}
			
			int oldVal = zahlen[i];
			zahlen[i] = zahlen[unsortiertAnfang];
			zahlen[unsortiertAnfang] = oldVal;
		}
		
	}

}
