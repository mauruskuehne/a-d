 package zbw.hash;
/**
 * 
 * @author Marcel Egloff
 * @version 1.0
 *
 * 
 */
public class Element {
	
	private String id;
	private String name;
	
	public Element()
	{
		id = "";
		name = "";
	}
	public Element(String newId, String newName)
	{
		this.id = newId;
		name = newName;
	}
	public String getId()
	{
		return id;
	}

	public void setId(String newId)
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
	
	public void show()
	{
		System.out.println(this.id + " " + this.name);
	}
}
