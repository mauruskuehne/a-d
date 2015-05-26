package ch.zbw.kuehne;

import zbw.Element;
import zbw.Node;
import zbw.Tree;

public class TreeImpl implements Tree{
	
	private Node root=null;
	
	private int hoehe=0;
	private int anzKnoten=0;
	private double pfadlaenge = 0;
	
//-------------------------- Oeffentliche Methoden -----------------------------------------
	
	/**
	 * Element einfügen
	 * @param e einzufügendes Element
	 *  @return true: Element eingefügt
	 */
	public boolean insert(Element e)
	{
		root = insertTree(root,e);
		return true;
		
	}
	
	/**
	 * Element suchen
	 * @param id Schlüssel des zu suchenden Elementes
	 *  @return gesuchtes Element; null : Element nicht gefunden
	 */
	public Element search(int id)
	{
		Element e = search(root, id);
		return e;
		
	}
	
	/**
	 * Element suchen (nicht rekursive Variante)
	 * @param id Schlüssel des zu suchenden Elementes
	 *  @return gesuchtes Element; null : Element nicht gefunden
	 */
	public Element search2(int id)
	{
		Element e = search(root, id);
		return e;
		
	}
	
	/**
	 * Element löschen 
	 * @param id Schlüssel des zu löschenden Elementes
	 */
	public void delete(int id)
	{
		System.out.println("should delete " + id);
		root = delete(root,id);
	}
	
	/**
	 * Baum ausgeben (Inorder 
	 */
	public void show()
	{
		showInorder(root, 0);
	}
	
	/**
	 * Höhe des Baums bestimmen
	 * @return Höhe des Baumes
	 */
	public int height()
	{
		hoehe = 0;
		height(root,0);
		return hoehe;
	}
	
	/**
	 * Durchschnittliche Pfadlänge des Baums bestimmen
	 * @return Durchschnittliche Pfadlänge
	 */
	public double length()
	{
		pfadlaenge = 0;
		anzKnoten = 0;
		length(root, 0);
		return (pfadlaenge/anzKnoten);
	}
	
	
//-------------------------- Private Methoden -----------------------------------------
	
	private void showInorder(Node r, int indent)
	{
		 if(r == null) return;
		 indent++;
		 showInorder(r.getLeft(), indent);
		 
		 for(int i = 0; i < indent; i++)
			 System.out.print("-");
		 
		 r.show();
		 
		 showInorder(r.getRight(), indent);
		
	}
	
	private Element search(Node r, int id)
	{
		if(r == null)
			return null;
		int currentId = r.getItem().getId();
		if(currentId == id)
			return r.getItem();
		else if(currentId > id)
			return search(r.getLeft(), id);
		else
			return search(r.getRight(), id);
	}
	
	/**
	 * nicht rekursive Variante von search
	*/
	private Element search2(Node root, int id)
	{
		return null;
	}
	
	
	
	private Node delete(Node root, int id)
	{
		if(root == null)
			return null;
		
		if(root.getItem().getId() == id) {
			Node replacement = null;
			if(root.getLeft() != null && root.getRight() == null)
				replacement = root.getLeft(); //nur linke Seite vorh.
			else if (root.getRight() != null && root.getLeft() == null)
				replacement = root.getRight(); //nur rechte Seite vorh.
			else if(root.getRight() != null && root.getLeft() != null){
				//beide seiten vorhanden
				//nŠchstgršsseres Element suchen, Wert Ÿbernehmen, lšschen
				Node nextSmallestNode = findRightEnd(root.getLeft());
				System.out.printf("%s has 2 subtrees, replacing with %s\n", root, nextSmallestNode);
				root.setLeft(delete(root.getLeft(), nextSmallestNode.getItem().getId()));
				System.out.printf("replacing content of %s with %s\n", root, nextSmallestNode);
				root.setItem(nextSmallestNode.getItem());
				replacement = root;
			}
			return replacement;
		} 
		else if(id < root.getItem().getId()) {
			Node newleft = delete(root.getLeft(), id);
			System.out.printf("set l of %s from %s to %s\n", root, root.getLeft(), newleft);
			root.setLeft(delete(root.getLeft(), id));
		}
		else if(id > root.getItem().getId()) {
			Node newright = delete(root.getRight(), id);
			System.out.printf("set r of %s from %s to %s\n", root, root.getRight(), newright); 
			root.setRight(newright);
		}
		return root;
	}
	
	private Node findRightEnd(Node root) {
		Node prev = null, n = root;
		while(n != null) {
			prev = n;
			n = n.getRight();
		}
		return prev;
	}
	
	private Node insertTree(Node root, Element e)
	{
		if(root == null)
		{
			Node n = new Node();
			n.setItem(e);
			return n;
		}
		if(root.getItem().getId() > e.getId())
			root.setLeft(insertTree(root.getLeft(), e));
		else if(root.getItem().getId() < e.getId())
			root.setRight(insertTree(root.getRight(), e));
		
		return root;
	}
	

	private void height(Node root, int h)
	{
		if(root == null) return;

		h++;
		
		if(root.getLeft() == null && root.getRight() == null && hoehe < h)
			hoehe = h;
		
		height(root.getLeft(), h);
		height(root.getRight(), h);		
	}
	
	private void length(Node root, int h)
	{
		if(root == null) return;
		
		pfadlaenge = h++;
		anzKnoten++;
		
		length(root.getLeft(), h);
		length(root.getRight(), h);	
	}

}

