package practice12.linkedlist;



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

	public LinkedList insertAtFirst(LinkedList list, int prevData, int data) {
		if (list.head == null) {
			return null;
		}

		Node currNode = list.head;

		while (currNode != null) {
			if (currNode.data == prevData) {
				Node newNode = new Node(data);

				newNode.next = currNode.next;
				currNode.next = newNode;

			}
		}

		return list;
	}

	public boolean isLoop(LinkedList list) {
		if (list == null) {
			return false;
		}

		Node slow, fast;

		slow = fast = list.head;

		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow.data == fast.data) {
				return true;
			}

		}

		return false;

	}
	
	public void print(LinkedList list) {
		if(list.head == null) {
			return;
		}
		
		Node currNode = list.head;
		while(currNode != null) {
			System.out.print(" "+ currNode.data);
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

		list = list.insertAtFirst(list, 10);
		list = list.insertAtFirst(list, 20);
		list = list.insertAtFirst(list, 30);
		list = list.insertAtFirst(list, 40);
		list = list.insertAtFirst(list, 50);
		list = list.insertAtFirst(list, 60);
		list = list.insertAtFirst(list, 70);

		//list = list.insertAfter(list, list.head.next, 5);

		list.print(list);
		System.out.println();

		System.out.println("removing 10");
		list = list.remove(list, 50);

		list.print(list);
		System.out.println();
		list.head.next.next.next.next = list.head;
		System.out.println(list.isLoop(list));

		/*
		 * list = list.reverse(list); list.print(list); System.out.println();
		 * 
		 * list = list.insertAfterGivenElement(list, 70, 100); list.print(list);
		 */

	}

}
