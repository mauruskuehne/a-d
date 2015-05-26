package zbw;

public interface Tree {
	
	public boolean insert(Element e);
	
	public Element search(int id);
	
	public Element search2(int id);
	
	public void delete(int id);
	
	public int height();
	
	public double length();
	
	

}
