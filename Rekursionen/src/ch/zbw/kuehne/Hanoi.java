package ch.zbw.kuehne;

public class Hanoi {

	public static int ZeitZumVerschieben(int turmhoehe, char quelle, char hilfe, char ziel)
	{
		int i = 0;
		if(turmhoehe > 0)
		{
			i = 1;
			i += ZeitZumVerschieben(turmhoehe - 1, quelle, ziel, hilfe);
			
			System.out.println("Verschiebe " + turmhoehe + "von " + quelle + " nach " + ziel);
			
			i += ZeitZumVerschieben(turmhoehe - 1, hilfe, ziel, quelle);
			
		}
		
		return i ;
	}
	
}
