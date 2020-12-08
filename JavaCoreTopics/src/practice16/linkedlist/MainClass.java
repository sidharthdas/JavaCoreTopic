package practice16.linkedlist;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head = null;

	public LinkedList insertAtLast(LinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node lastNode = list.head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;

		}

		return list;
	}
	
	public LinkedList remove(LinkedList list, int data) {
		if(list.head == null) {
			return list;
		}
		else if(list.head.data == data) {
			Node node = list.head.next;
			list.head = node;
		}else {
			Node currNode = list.head;
			
			while(currNode.next != null) {
				if(currNode.next.data == data) {
					Node node = currNode.next.next;
					currNode.next = node;
				}
			}
		}
		
		return list;
	}
}

public class MainClass {

}
