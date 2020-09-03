package linkedlist;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}

}

 class LinkedList{
	 
	 Node head = null;
	 
	//Insert new Node at end.
	 public LinkedList insertAtEnd(int data, LinkedList list) {
		 Node newNode = new Node(data);
		 if(list.head == null) {
			 list.head = newNode;
		 }else {
			 Node last = list.head;
			 while(last.next != null) {
				 last = last.next;
			 }
			 last.next = newNode;
		 }
		 
		 return list;
	 }
	 
	 //Insert new Node at begining.
	 public LinkedList insertAtFirst(int data, LinkedList list) {
		 Node newNode = new Node(data);
		 if(list.head == null) {
			 list.head = newNode;
		 }else {
			 newNode.next = list.head;
			 list.head = newNode;
		 }
		 
		 return list;
	 }
	 
	 
	 //Insert new Node at given position
	 public LinkedList insertAfter(Node prevNode, int data, LinkedList list) {
		 if(prevNode == null) {
			 System.out.println("Prev node cant be null");
			 return null;
		 }
		 Node newNode = new Node(data);
		 newNode.next = prevNode.next;
		 prevNode.next = newNode;
		 
		 return list;
	 }
	 
	 
	 
	 public void printList(LinkedList l) {
		 if(l.head == null) {
			 return;
		 }
		 Node currNode = l.head;
		 while(currNode != null) {
			 System.out.print(currNode.data+" ");
			 currNode = currNode.next;
		 }
	 }
 }

public class LinkedListMainClass {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list = list.insertAtFirst(10, list);
		list = list.insertAtFirst(20, list);
		list = list.insertAtFirst(30, list);
		list = list.insertAtFirst(40, list);
		list = list.insertAtFirst(50, list);
		list = list.insertAtFirst(60, list);
		list = list.insertAtFirst(70, list);
		
		list = list.insertAfter(list.head.next, 5, list);
		
		list.printList(list);
		
	}

}
