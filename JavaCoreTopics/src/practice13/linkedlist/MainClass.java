package practice13.linkedlist;

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
		if (list.head == null) {
			list.head = newNode;
		} else {
			newNode.next = list.head;
			list.head = newNode;
		}

		return list;
	}

	public LinkedList insertAt(LinkedList list, int prevData, int data) {
		if (list.head == null) {
			return null;
		}
		Node newNode = new Node(data);
		if (list.head.data == prevData) {
			newNode.next = list.head.next;
			list.head = newNode;
		} else {
			Node currNode = list.head;
			while (currNode.next == null) {
				if (currNode.data == prevData) {
					Node node = currNode.next;
					newNode.next = node;
					currNode.next = newNode;

				}
				currNode = currNode.next;
			}

		}
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
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
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

		list = list.insertAt(list, 30, 5);

		list.print(list);
		System.out.println();

		System.out.println("removing 10");
		list = list.remove(list, 50);

		list.print(list);
		System.out.println();

	}

}
