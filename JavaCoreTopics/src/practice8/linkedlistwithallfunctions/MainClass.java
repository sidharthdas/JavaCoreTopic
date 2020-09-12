package practice8.linkedlistwithallfunctions;

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

	// Insert at First
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

	// Insert after
	public LinkedList insertAt(LinkedList list, Node prevNode, int data) {
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

	// remove element from linkedlist
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
				}
				currNode = currNode.next;
			}
		}

		return list;
	}

	// print
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

	// check circular
	public boolean checkCircular(LinkedList list) {
		if (list.head == null) {
			return false;
		}

		HashSet<Node> check = new HashSet<>();
		Node currNode = list.head;
		while (currNode.next != null) {
			if (check.contains(currNode)) {
				return true;
			}

			check.add(currNode);
			currNode = currNode.next;
		}

		return false;
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

		list = list.insertAt(list, list.head.next, 5);

		/*
		 * list.print(list); System.out.println(); System.out.println("removing 10");
		 * list = list.remove(list, 50);
		 */

		list.print(list);
		System.out.println();
		// list.head.next.next.next.next = list.head;
		System.out.println(list.checkCircular(list));

	}
}
