package zbw.hash;

public interface Hashtabelle {
	
	/**
	 * Element in der Hashtabelle einfügen
	 * @param e einzufügendes Element
	 * @return true: Element wurde eingefügt; 
	 * 		   false: Hashtabelle voll; Element nicht eingefügt
	 */
	public boolean put(Element e);
	
	
	/**
	 * Element in der Hashtabelle suchen
	 * @param id Schlüssel des zu suchenden Elementes
	 * @return gesuchtes Element; null-> Element nicht gefunden 
	 */
	public Element get(String id);
	
	
	/**
	 * Element in der Hashtabelle löschen
	 * @param id Schlüssel des zu löschenden Elementes
	 * @return true: Element wurde gelöscht; 
	 * 		   false: Element nicht gefunden
	 */
	public boolean delete(String id);

}
