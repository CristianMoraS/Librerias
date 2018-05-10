package listas;

public class NodeGeneral{
	// Atributos:
	public String name;
	public int age;
	public int id;
	
	//int* ponter = &a; en c/c++
	
	public NodeGeneral next;// <--- Este es el puntero
	
	public NodeGeneral() {}
	
	//nodo:
	public NodeGeneral(String name, int age, int id) 
	{
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	// metodo to string
	public String toString()
	{
		return "Name: " + this.name + "\tAge:" + this.age + "\tId: " + this.id +"\n" ;
	}
	public NodeGeneral clone() {
		NodeGeneral clone = new NodeGeneral(this.name,this.age,this.id);
		return clone;
	}
	
}
