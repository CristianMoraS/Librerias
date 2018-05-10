package LoopList;

import java.io.*;

import listas.NodeGeneral;

public class ListL {
	
	NodeLoop head = null;
	
	public boolean isEmpty() {		
		return head == null ? true : false;
	}
	
	/** -- INSERT -- **/
	public void insertAtBegin(NodeLoop newNode) {
		if(isEmpty())
		{
			newNode.next = head;
			head = newNode;
			head.next = head;
		}else {
			NodeLoop temp = head;
			newNode.next = temp;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = newNode;
			head = newNode;
		}
	}
	public void insertAtEnd(NodeLoop newNode) {
		if(isEmpty())
		{
			newNode.next = head;
			head = newNode;
			head.next = head;
		}else{
			NodeLoop temp = head;
			while(temp.next != head)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}
	}	
	public void insertAtIndex(NodeLoop newNode, int Index){
		NodeLoop temp;
		NodeLoop pre = head;
		for(int i = 0; i < Index-2; i++){
			pre = pre.next;
		}
		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;
	}
	
	/** -- DELETE -- **/
	public void deleteAtBegin(){
		if(!isEmpty())
		{
			NodeLoop temp = head;
			NodeLoop aux = temp.next;
			while(temp.next != head)
			{
				temp = temp.next;
			}
			temp.next = aux;
			temp = null;
			head = aux;
			System.gc();
		}
	}
	public void deleteAtEnd(){
		if(!isEmpty())
		{
			NodeLoop temp;
			NodeLoop pre = head;
			while(pre.next.next != head)
			{
				pre = pre.next;
			}
			temp = pre.next;
			pre.next = head;
			temp = null;
			System.gc();
		}
	}
	public void deleteAtIndex(int Index) {
		NodeLoop temp;
		NodeLoop pre = head;
		for(int i = 0; i < Index-2; i++) {
			pre = pre.next;
		}
		temp = pre.next;
		pre.next = temp.next;
		temp = null;
		System.gc();
		
	}
	/** -- Size -- **//*-- TIENE PROBLAMAS --*/
	public void sizeList() {
		NodeLoop temp = head;
		int count = 0;
		while(temp.next != head)
		{
			count++;
			temp = temp.next;
		}
	}
	/** -- PRINT -- **/
	public void printList() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(!isEmpty())
		{
			NodeLoop temp = head;
			do {
				bw.write(temp.toString());
				temp = temp.next;
			}while(temp != head);
			bw.flush();
		}
    }
	
	
	public static void main(String[]args) throws IOException {
		ListL ls = new ListL();
		ls.insertAtEnd(new NodeLoop("Cristian"));
		ls.insertAtBegin(new NodeLoop("David"));
		ls.insertAtEnd(new NodeLoop("Maria"));
		ls.insertAtBegin(new NodeLoop("Paula"));
		ls.insertAtEnd(new NodeLoop("Lina"));
		ls.insertAtBegin(new NodeLoop("Gabriela"));
		ls.insertAtEnd(new NodeLoop("Evelyn"));
		ls.insertAtBegin(new NodeLoop("Babitas"));
		ls.insertAtIndex(new NodeLoop("Morita"), 4);
		ls.deleteAtBegin();
		ls.deleteAtEnd();
		ls.deleteAtIndex(6);
		ls.printList();
	}
	
}
