package LoopList;

public class NodeLoop {
	public String name;
	
	public NodeLoop next;
	
	public NodeLoop(String nam)
	{
		this.name = nam;
	}
	
	public String toString()
	{
		return "Nombre: " + this.name + "\n";
	}
	
	public NodeLoop cloner()
	{
		NodeLoop clone = new NodeLoop(this.name); 
		return clone;
	}
}
