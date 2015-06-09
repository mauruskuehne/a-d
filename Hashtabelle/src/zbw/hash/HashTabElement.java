package zbw.hash;

public class HashTabElement {
	
	/**************************************************************************
	 * KONSTANTEN
	 **************************************************************************/

	public static final int FREI = 0;
	public static final int BESETZT = 1;
	public static final int GELOESCHT = 2;
	
	/**************************************************************************
	 * ATTRIBUTE
	 **************************************************************************/

	private int zustand;
	private Element element;
	
	public HashTabElement()
	{
		zustand = FREI;
		element = null;
	}
	
	public HashTabElement(Element e, int newZustand)
	{
		zustand = newZustand;
		element = e;
	}
	
	public Element getElement()
	{
		return element;
	}
	
	public void setElement(Element el)
	{
		element = el;
	}
	
	public int getZustand()
	{
		return zustand;
	}
	
	public void setZustand(int z)
	{
		zustand = z;
	}
}
