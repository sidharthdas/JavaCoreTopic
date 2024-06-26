package practice10.linkedlist;

import java.util.HashSet;

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

	public LinkedList insertAfter(LinkedList list, Node prevNode, int data) {
		if (list.head == null) {
			return null;
		}
		if (prevNode == null) {
			return null;
		}
		Node newNode = new Node(data);

		newNode.next = prevNode.next;
		prevNode.next = newNode;

		return list;
	}

	public LinkedList remove(LinkedList list, int data) {
		if (list.head == null) {
			return null;
		}
		if (list.head.data == data) {
			list.head = list.head.next;
		} else {

			Node currNode = list.head;
			while (currNode.next != null) {
				if (currNode.next.data == data) {
					Node node = currNode.next.next;
					currNode.next = node;
					break;
				}
				currNode = currNode.next;
			}
		}

		return list;
	}

	public void print(LinkedList list) {
		if (list.head == null) {
			return;
		}

		Node currNode = list.head;
		while (currNode != null) {
			System.out.print(" " + currNode.data);
			currNode = currNode.next;
		}
	}

	public boolean checkCircular(LinkedList list) {
		if (list.head == null) {
			return false;
		}
		HashSet<Node> check = new HashSet<>();
		Node currNode = list.head;
		while (currNode != null) {
			if (check.contains(currNode)) {
				return true;
			}

			check.add(currNode);
			currNode = currNode.next;
		}

		return false;
	}
	//reverse a linkedlist
	public LinkedList reverse(LinkedList list) {
		if (list.head == null) {
			return null;
		}

		Node prevNode = null;
		Node currNode = list.head;
		Node nextNode = null;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}

		list.head = prevNode;

		return list;
	}
	
	//insert before element
	public LinkedList insertAfterElement(LinkedList list, int prevElement, int data) {
		if(list.head == null) {
			return null;
		}
		Node currNode = list.head;
		
		while(currNode != null) {
			if(currNode.data == prevElement) {
				Node prevNode = currNode;
				Node node = new Node(data);
				node.next = prevNode.next;
				prevNode.next = node;
				break;
			}
			currNode = currNode.next;
		}
		
		return list;
	}
	

}

public class MainClass {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list = list.insertAtFirst(list, 10);
		list = list.insertAtFirst(list, 20);
		list = list.insertAtFirst(list, 30);
		list = list.insertAtFirst(list, 40);
		list = list.insertAtFirst(list, 50);
		list = list.insertAtFirst(list, 60);
		list = list.insertAtFirst(list, 70);

		list = list.insertAfter(list, list.head.next, 5);

		list.print(list);
		System.out.println();
		/*
		 * System.out.println("removing 10"); list = list.remove(list, 50);
		 * 
		 * list.print(list); System.out.println(); //list.head.next.next.next.next =
		 * list.head; System.out.println(list.checkCircular(list));
		 * 
		 * list = list.reverse(list); list.print(list); System.out.println();
		 */
		
		list = list.insertAfterElement(list, 70, 100);
		list.print(list);
	}

}
