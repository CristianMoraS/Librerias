package listas;
import java.io.*;
import java.util.*;
public class Lista {
	
	NodeGeneral head = null;//Empty List
	
	/** -- EMPTY -- **/
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	/** -- INSERT -- **/
	public void insertAtEnd(NodeGeneral newNode){
		if(isEmpty()) {
			head = newNode;
		}else {
		NodeGeneral temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		}
	}
	public void insertAtIndex(NodeGeneral newNode, int Index){
		NodeGeneral temp;
		NodeGeneral pre = head;
		for(int i = 0; i < Index-1; i++){
			pre.next=pre;
		}
		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;
	}
	
	public void insertAtBegin(NodeGeneral newNode){
		newNode.next = head;
		head = newNode;
	}
	
	/** -- DELETE -- **/
	public void deletAtIndex(int delIndex) {// here is the delete index
		NodeGeneral temp;
		NodeGeneral pre = head;
		for(int i = 0; i < delIndex-1; i++) {
			temp = pre.next;
			pre.next = temp.next;
			temp = null;
			System.gc();
		}
	}
	public void deleteAtBegin(){
		NodeGeneral temp = head;
		head = head.next;
		temp = null;
		System.gc();
	}
	public void deleteAtEnd() {
		NodeGeneral temp;
		NodeGeneral pre = head;
		while(pre.next.next != null){
			pre = pre.next;
		}
		temp = pre.next;
		pre.next = null;
		temp = null;
		System.gc();
	}
	
	/** -- PRINT -- **/
	public void printList() throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		NodeGeneral temp = head;
		while(temp != null)
		{
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.flush();
	}
	
	/** -- REVERSE -- **/
	public void reverse() {
		Stack tempList = new Stack();
		NodeGeneral temp = head;
		
		while(temp != null) {
			
			tempList.push(temp.clone());
			temp = temp.next;
		}
		head = tempList.head;
	}
	
	/** -- QUICKSORT -- **/
	public NodeGeneral quickSort() {
		if(!isEmpty()) {
			
		Lista leftList = new Lista();
		Lista rightList = new Lista();
		
		NodeGeneral pivot = head;
		NodeGeneral temp = head.next;
		
		while(temp !=null)
		{
			if(temp.age < pivot.age)
				leftList.insertAtEnd(temp.clone());
			else
				rightList.insertAtEnd(temp.clone());
			temp = temp.next;
		}
		
		leftList.quickSort();
		rightList.quickSort();
		pivot.next = rightList.head;
		leftList.insertAtEnd(pivot);
		head = leftList.head;
		
		}	
		return null;
	}
	
	/** -- SIZE AND UPDATE -- **/
	public int Size()
	{
		int count = 0;
		NodeGeneral temp = head;
		while(temp != null)
		{
			count += 1;
			temp = temp.next;
		}
		return count;
	}
	public void update_List(int index, int newAge) {
		NodeGeneral temp = head;
		for(int i = 1 ; i < index ; i++ ) {
			temp = temp.next;
		}
		temp.age = newAge;
		newAge = temp.age;
		System.gc();
	}
	
	public NodeGeneral getNode(int index)
	{
		if (Size() < index) {
			return null;
		}else {
			NodeGeneral temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}
	
	/** -- BINARY SEARCH -- **/
	public void binarySearch(int ide)
	{
		Lista ls = new Lista();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		NodeGeneral temp = head;
		int max = Size();
		int min = 0;
		int middle = (max+min)/2;
		while(min != max)
		{
			for(int i = min; i < middle-1 ;i++) {
				temp = temp.next;
			}
			if(temp.age == ide)
			{	
				System.out.println(temp);
			}else if(ide < temp.age)
			{
				 temp = head;
				 max = middle;
			}else {
				min = middle;
			}
			middle = min + ((max - min)/2);
			getNode(middle);
		}
	}
	
	/** -- MAIN -- **/
	public static void main(String []args) throws IOException{
		Lista students = new Lista();
		
		students.insertAtBegin(new NodeGeneral("Cristian", 17, 610171));
		students.insertAtEnd(new NodeGeneral("Camilo", 19, 601171));
		students.insertAtBegin(new NodeGeneral("ElmO", 10, 45845212));
		students.insertAtBegin(new NodeGeneral("David", 22, 610171));
		students.insertAtEnd(new NodeGeneral("Diego", 56, 601171));
		students.insertAtBegin(new NodeGeneral("Andres", 30, 45845212));
		students.update_List(4, 18);
		students.deleteAtBegin();
		students.deleteAtEnd();
		
		
		students.printList();
		
		
		/*
		System.out.println("-----------------");
		students.deleteAtBegin();
		students.printList();
		
		System.out.println("------------------");
		students.deleteAtEnd();
		students.printList();
		
		System.out.println("----------------------");
		students.deletAtIndex(1);
		students.printList();
		*/
		/*
		System.out.println("----------------------------");
		students.reverse();
		students.printList();
		*/
		
		
		
	}
}
