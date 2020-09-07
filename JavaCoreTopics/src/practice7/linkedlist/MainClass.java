package practice7.linkedlist;



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
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}

		return list;
	}

	public LinkedList insertAtFirst(LinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			newNode.next = list.head;
			list.head = newNode;
		}

		return list;
	}

	public LinkedList insertAt(LinkedList list, Node prevNode, int data) {
		if (prevNode == null) {
			return null;
		}
		if (list.head == null) {
			return null;
		}

		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;

		return list;
	}

	public void printList(LinkedList list) {
		if (list.head == null) {
			return;
		}

		Node currNode = list.head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

	}
	
	public LinkedList remove(LinkedList list, int data) {
		if(list.head == null) {
			return null;
		}
		if(list.head.data == data) {
			list.head = list.head.next;
			
		}else {
			Node currNode = list.head;
			while(currNode.next != null) {
				if(currNode.next.data == data) {
					Node node = currNode.next.next;
					currNode.next = node;
					break;
				}
				currNode = currNode.next;
			}
		}
		
		return list;
	}

}

public class MainClass {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list = list.insertAtEnd(list, 10);
		list = list.insertAtEnd(list, 20);
		list = list.insertAtEnd(list, 30);
		list = list.insertAtEnd(list, 40);
		list = list.insertAtEnd(list, 50);
		list = list.insertAtEnd(list, 60);
		list = list.insertAtEnd(list, 70);

		list = list.insertAt(list,list.head.next, 5);
		list.printList(list);
		
		System.out.println();
		
		list.printList(list);
		
		System.out.println();
		
		list.remove(list, 50);
		list.printList(list);
		

	}

}
