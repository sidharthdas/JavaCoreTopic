package practice4.linkedlist;



class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

class LinkedList {

	Node head = null;

	// insert at end
	public LinkedList insertAtEnd(LinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {

			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;

		}
		return list;
	}

	// insert at first
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

	// insert at particular index
	public LinkedList insertAt(Node prevNode, LinkedList list, int data) {
		if(prevNode == null) {
			return null;
			
		}
		if(list.head == null) {
			return null;
		}
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		
		return list;
	}
	
	//remove element
	public LinkedList remove(int data, LinkedList list) {
		if(list.head == null) {
			return null;
		}
		if(list.head.data == data) {
			list.head = list.head.next;
			return list;
		}
		
		Node currNode = list.head;
		while(currNode.next != null) {
			if(currNode.next.data == data) {
				Node node = currNode.next.next;
				currNode.next = node;
				break;
			}
			
			currNode = currNode.next;
		}
		
		return list;
	}
	
	public void print(LinkedList list) {
		if(list.head == null) {
			return;
		}
		
		Node currNode = list.head;
		
		while(currNode != null) {
			System.out.print(currNode.data+" ");
			currNode = currNode.next;
		}
	}
}

public class LinkedListMainClass {

	public static void main(String[] args) {
		
LinkedList list = new LinkedList();
		
		list = list.insertAtFirst(list, 10);
		list = list.insertAtFirst(list, 20);
		list = list.insertAtFirst(list, 30);
		list = list.insertAtFirst(list, 40);
		list = list.insertAtFirst(list, 50);
		list = list.insertAtFirst(list, 60);
		list = list.insertAtFirst(list, 70);
		
		list = list.insertAt(list.head.next, list, 5);
		
		list.print(list);
		
		System.out.println("removing 40");
		list = list.remove(70, list);
		
		list.print(list);

	}

}
