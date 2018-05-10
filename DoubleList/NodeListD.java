package DoubleList;

public class NodeListD {
	public String name;
	
	public NodeListD next;
	public NodeListD prev;
	
	public NodeListD(String n) {
		this.name = n;
	}
	
	public String toString()
	{
		return "Nombre: " + this.name + "\n";
	}
}
