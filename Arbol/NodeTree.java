package Arbol;

public class NodeTree {
	int value;
	
	public NodeTree left;
	public NodeTree right;
	
	public NodeTree(int val) {
		this.value = val;
	}
	
	public String toString() {
		return "Valor: " + this.value + "\n";
	}
}
