package ch.kuehne.zbw;

import zbw.Isorter;

public class Quicksort implements Isorter {

	@Override
	public void sort(int[] zahlen) {
		
		quicksort(zahlen, 0, zahlen.length - 1);
	}
	
	public void quicksort(int[] fullArray, int beginOffset, int endOffset) {
		//Mitte auswählen
		int laenge = (endOffset - beginOffset);
		int mitteIdx = laenge / 2 + beginOffset;
		System.out.println("quickSort: " + beginOffset + " bis " + endOffset);
		if(laenge < 2) 
			return;
		else {
			int mitte = fullArray[mitteIdx];
			int lSearchIdx = beginOffset;
			int rSearchIdx = endOffset;
			
			
			while(lSearchIdx < rSearchIdx) {
				//Linke Hälfte durchsuchen nach Element das grösser als mitte ist
				while(fullArray[lSearchIdx] < mitte)
					lSearchIdx++;
				
				//rechte Hälfte durchsuchen nach Element das kleiner als Mitte ist
				while(fullArray[rSearchIdx] > mitte)
					rSearchIdx--;
				
				if(lSearchIdx < rSearchIdx)
					swap(fullArray, lSearchIdx, rSearchIdx);


			}

			quicksort(fullArray, beginOffset, mitteIdx);
			quicksort(fullArray, mitteIdx, endOffset);
		}

		
		return;
	}
	
	private void swap(int[] arr, int pos1, int pos2) {
		int tmp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = tmp;
	}

}
