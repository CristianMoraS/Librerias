package DoubleList;
import java.io.*;
public class ListD {
	NodeListD head = null;
	/** -- EMPTY -- **/
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	/** -- INSERT -- **/
	public void insertAtBegin(NodeListD newNode) {
		if(!isEmpty())
		{
			NodeListD temp;
			temp = head;
			newNode.next = temp;
			head = newNode;
			temp.prev = head;
			head.prev = null;
		}else {
			head = newNode;
			newNode.next = null;
			newNode.prev = null;
		}
	}
	public void insertAtEnd(NodeListD newNode) {
		if(!isEmpty())
		{
			NodeListD temp;
			temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = null;
		}else {
			head = newNode;
			newNode.next = null;
			newNode.prev = null;
		}
	}
	/** -- DELETE -- **/
	public void deleteAtBegin() {
		NodeListD temp = head;
		head = head.next;
		temp = null;
		System.gc();
	}
	public void deleteAtEnd() {
		NodeListD temp = head;
		NodeListD pre;
		while(temp.next.next != null )
		{
			temp = temp.next.next;
		}
		pre = temp.next;
		temp.prev = temp;
		temp.next = null;
		pre = null;
		System.gc();	
	}
	/** -- SIZE -- **/
	public void size() {
		NodeListD temp = head;
		int count = 0;
		while(temp != null)
		{
			temp = temp.next;
			count++;
		}
		System.out.print("La lista tiene un tamaño de: " + count + "\n");
			
	}
	/** -- PRINT -- **/
	public void printListD() throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		NodeListD temp = head;
		while(temp != null)
		{
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.flush();
	}
	public static void main(String[]args) throws IOException{
		ListD ld = new ListD();
		ld.insertAtBegin(new NodeListD("Babitas"));
		ld.insertAtBegin(new NodeListD("Lina"));
		ld.insertAtBegin(new NodeListD("David"));
		ld.insertAtEnd(new NodeListD("Gabriela"));
		ld.insertAtBegin(new NodeListD("Evelyn"));
		ld.insertAtBegin(new NodeListD("Cristian"));
		ld.insertAtBegin(new NodeListD("Daniela"));
		ld.insertAtBegin(new NodeListD("Maria"));
		ld.deleteAtEnd();
		ld.deleteAtBegin();
		ld.size();
		ld.printListD();
	}
}
