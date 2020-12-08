package practice15.linkedlist;

class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head = null;

	public LinkedList insertAtEnd(LinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {

			Node currNode = list.head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}

			currNode.next = newNode;

		}

		return list;

}
	
	public LinkedList insertAtFirst(LinkedList list, int data) {
		Node newNode = new Node(data);
		if(list.head == null) {
			list.head = newNode;
		}else {
			newNode.next = list.head;
			list.head = newNode;	
		}
		return list;
	}
	
	public LinkedList insertAfter(LinkedList list, int data, int prevData) {
		if(list.head == null) {
			return null;
		}
		Node newNode = new Node(data);
		if(list.head.data == data) {
			newNode.next = list.head.next;
			list.head.next = newNode;
		}else {
		
		Node currNode = list.head;
		while(currNode.next != null) {
			if(currNode.data == prevData) {
				Node node = currNode;
			}
		}
		}
		
		return null;
	}

}

public class MainClass {

	public static void main(String[] args) {

	}
}
