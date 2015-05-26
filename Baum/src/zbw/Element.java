package zbw;



public class Element {
	
	private int id;
	private String name;
	
	public Element()
	{
		id = 0;
		name = "";
	}
	
	public Element(int newId, String newName)
	{
		this.id = newId;
		this.name = newName;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setId(int newId)
	{
		this.id = newId;
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