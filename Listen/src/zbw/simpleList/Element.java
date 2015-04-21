package zbw.simpleList;
/**
 * 
 * @author Marcel Egloff
 * @version 1.0
 *
 * 
 */
public class Element 
{	
	private int id;
	private String name;
/**
 * 
 * 	
 */	
	
	
	public Element()
	{
		this.id = 0;
		name = "";
	}
	public Element(int newId, String newName)
	{
		this.id = newId;
		name = newName;
	}
	public int getId()
	{
		return id;
	}

	public void setId(int newId)
	{
		this.id = newId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public String toString()
	{
		return(this.id + " " + this.name);
	}
	
	public void show()
	{
		System.out.println(this.id + " " + this.name);
	}
}
