package practice6.linkedlist;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

class LinkedList {

	Node head = null;

	// Insert at end
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

	// insert at
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
	
	//insert after particular number
	public LinkedList insertAfterParticular(LinkedList list, int particularNum, int data) {
		if(list.head == null) {
			return null;
		}
		Node currNode = list.head;
		Node newNode = new Node(data);
		while(currNode.next != null) {
			if(currNode.data == particularNum) {
				newNode.next = currNode.next;
				currNode.next = newNode;
				break;
			}
			currNode = currNode.next;
			
		}
		return list;
	}

	public void print(LinkedList list) {
		if (list.head == null) {
			return;
		}

		Node currNode = list.head;

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}

	public LinkedList remove(int data, LinkedList list) {
		if (list.head == null) {
			return null;
		}
		if (list.head.data == data) {
			list.head = list.head.next;
		} else {
			Node currNode = list.head;
			while (currNode.next != null) {
				if (currNode.next.data == data) {
					currNode.next = currNode.next.next;
					break;
				}
				currNode = currNode.next;
			}

		}
		return list;
	}

}

public class LinkedListMainClass {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list = list.insertAtEnd(list, 10);
		list = list.insertAtEnd(list, 20);
		list = list.insertAtEnd(list, 30);
		list = list.insertAtEnd(list, 40);
		list = list.insertAtEnd(list, 50);
		list = list.insertAtEnd(list, 60);
		list = list.insertAtEnd(list, 70);

		list = list.insertAt(list, list.head.next, 5);

		list.print(list);

		//System.out.println("removing 40");
		//list = list.remove(50, list);
		
		System.out.println();

		list.print(list);
		
		System.out.println();
		
		list.insertAfterParticular(list, 30, 10);
		
		list.print(list);

	}

}
