/**
 * 
 */
package practice18.linkedlist;

/**
 * @author sidharthdas
 *
 */

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

// insert at first
// insert at last
// insert after a node
// delete a node
// print node
// intersection point
// looping

class LinkedList {
	Node head = null;

	// 1. insert at first

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

	// 2. insert at last

	public LinkedList insertAtLast(LinkedList list, int data) {
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

	public LinkedList insertAfter(LinkedList list, int prevData, int data) {
		Node newNode = new Node(data);
		
		if(list.head == null) {
			return null;
		}else if(list.head.data == prevData) {
			newNode.next = list.head.next;
			list.head.next = newNode;
		}
		else {
		Node currNode = list.head;
		
		while(currNode.next != null) {
			if(currNode.next.data == prevData) {
				Node temp = currNode.next.next;
				newNode.next = temp;
				currNode.next.next = newNode;
			}	
			currNode = currNode.next;
		}
	}
		return list;
	}
	
	
	public LinkedList remove(LinkedList list, int data) {
		if(list.head == null) {
			return null;
		}
		
		
		
		if(list.head.data == data) {
			list.head = list.head.next;
		}else {
			Node currNode = list.head;
		
		while(currNode.next!= null) {
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
	public void printList(LinkedList list) {
		if(list.head == null) {
			return;
		}
		Node node = list.head;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	
}

public class MainClass {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list = list.insertAtLast(list, 10);
		list = list.insertAtLast(list, 20);
		list = list.insertAtLast(list, 30);
		
		list = list.insertAtLast(list, 40);
		list = list.insertAtLast(list, 50);
		list = list.insertAtLast(list, 60);
		list = list.insertAtLast(list, 70);
		list = list.insertAtLast(list, 80);
		list = list.insertAtLast(list, 90);
		
	list.printList(list);
	
	
	System.out.println("------------------------------------");
	
	System.out.println("insert after 40");
	
	list = list.insertAfter(list, 20, 100);
	
	list.printList(list);
	
	System.out.println("-----------------------------------------");
	
	System.out.println("remove 10");
	
	list = list.remove(list, 90);
	
	list.printList(list);
	
	}

}
