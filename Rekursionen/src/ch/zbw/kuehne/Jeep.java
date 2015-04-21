package ch.zbw.kuehne;

public class Jeep {

	public static double MaxReichweite(double anzahlFuellungen, double kapazitaet, double verbrauch)
	{
		if(anzahlFuellungen == 1)
			return anzahlFuellungen * (kapazitaet / (verbrauch / 100.0));
		return 0;
		//throw new Exception("aasdf");
	}
	
}
