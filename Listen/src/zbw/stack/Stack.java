package zbw.stack;

import zbw.simpleList.Element;

public interface Stack {
	
	/**
	 * Legt ein Objekt auf dem Stack ab
	 */
	public boolean  push(Element obj);
	
	/**
	 * Gibt das oberste Element zurück und entfernt dieses
	 */
	public Element pop();
	
	/**
	 * Gibt das oberste Element zurück 
	 */
	public Element top();
	
	/**
	 * liefert true, falls der Stack leer ist
	 */
	public boolean empty();

}