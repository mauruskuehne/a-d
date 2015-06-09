package ch.zbw.kuehne;

import zbw.hash.*;


public class HashtabelleImpl  implements Hashtabelle{

	/**************************************************************************
	 * ATTRIBUTE
	 **************************************************************************/

	private final int MAX = 29;
	private HashTabElement tab[] = new HashTabElement[MAX];
	
	
	/**************************************************************************
	 * PRIVATE METHODEN
	 **************************************************************************/

	/**
	 * Hashfunktion: berechnet aus dem Schlüssel den Promärindex
	 * @param S Schlüssel
	 * @return Primärindex 
	 */
	private int hash(String s)
	{
		int value = (s.length()*(s.charAt(0) + s.charAt(s.length()-1))) % MAX; 
		return value;
	}
	
	/**
	 * Element anhand des Schlüssel in der Hashtabelle suchen
	 * @param id Schlüssel des ELementes
	 * @return Position des Elementes in der Hashtabelle; -1: Element nicht gefunden
	 */
	private int suchen(String id)
	{
		int idx = hash(id);
		
		int startIdx = idx;
		while(true) {
				
			
			Element e = tab[idx].getElement();
			
			if(e != null && e.getId() == id) {
				return idx;
			}
			
			idx++;

			if(idx == startIdx)
				return -1; //Komplett durchsucht, nix gefunden
			
			if(idx == tab.length)
				idx = 0;
	
		}
	}

	
	/**************************************************************************
	 * PUBLIC METHODEN
	 **************************************************************************/	
	
	/**
	 * Defaultkonstruktor
	 */
	public HashtabelleImpl()
	{
		for(int i = 0; i < MAX; i++) {
			tab[i] = new HashTabElement();
		}
	}
	
	/**
	 * Element in der Hashtabelle einfügen
	 * @param e einzufügendes Element
	 * @return true: Element wurde eingefügt; 
	 * 		   false: Hashtabelle voll; Element nicht eingefügt
	 */
	public boolean put(Element e)
	{
		int startIdx = hash(e.getId());
		int idx = startIdx;
		
		while(true) {
			
			if(tab[idx].getZustand() != HashTabElement.BESETZT) {
				tab[idx].setElement(e);
				tab[idx].setZustand(HashTabElement.BESETZT);
				return true;
			} else {
				Element el = tab[idx].getElement();
				if(el != null && el.getId() == el.getId())
					return false;
			}
			
			idx++;
			
			if(idx == tab.length)
				idx = 0;
		
			if(idx == startIdx)
				return false; //Komplett durchsucht, nix gefunden
		}
	}
	
	/**
	 * Element in der Hashtabelle suchen
	 * @param id Schlüssel des zu suchenden Elementes
	 * @return gesuchtes Element; null-> Element nicht gefunden 
	 */
	public Element get(String id)
	{
		int idx = suchen(id);
		if(idx == -1) return null;
		return tab[idx].getElement();
	}
	
	/**
	 * Element in der Hashtabelle löschen
	 * @param id Schlüssel des zu löschenden Elementes
	 * @return true: Element wurde gelöscht; 
	 * 		   false: Element nicht gefunden
	 */
	public boolean delete(String id)
	{
		int idx = suchen(id);
		if(idx == -1) 
			return false;
		
		tab[idx].setElement(null);
		tab[idx].setZustand(HashTabElement.GELOESCHT);
		
		return true;
	}
}
	
