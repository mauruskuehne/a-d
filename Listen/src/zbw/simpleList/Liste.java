 
package zbw.simpleList;

public interface Liste {
	
	/**
	 * Element am Anfang einfügen
	 */
	public boolean insertFirst(Element x);
	
	/**
	 * Element am Ende einfügen
	 */
	public boolean insertLast(Element x);
	
	/**
	 * liefert true, wenn Liste leer
	 */
	public boolean empty();
	
	
	/**
	 * Gibt das erste Element der Liste züruck; null wenn Liste leer
	 */
	public Element getFirst();
	
	/**
	 * Gibt das letzte Element der Liste züruck; null wenn Liste leer
	 */
	public Element getLast();
	
	/**
	 * Element mit der ID id suchen
	 */
	public Element search(int id);
	
	/**
	 * Element mit der ID id löschen
	 */	
	public boolean delete(int id);
	
	/**
	 * Elemente der Liste ausgeben
	 */	
	public void show();
	
	
	/**************************************************************************************
	 * Zusatzaufgaben
	 **************************************************************************************/
	/*
	 * Elemente in der Liste tauschen
	 */
	public boolean change(int id1, int id2);
	
	/**
	 * liefert einen Subliste der Liste zwischen pos1 und pos2; null wenn pos1 oder pos2 ausserhalb der Liste sind
	 */
	public Liste sublist(int pos1, int pos2);
	
	/**
	 * Sucht alle Elemente mit dem Schlüssel >= key1 und <= key2; null wenn nichts gefunden
	 */
	public Liste searchElements(int key1, int key2);
	
}
