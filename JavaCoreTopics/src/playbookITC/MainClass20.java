package playbookITC;

import java.util.HashSet;

/*
20.	Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.*/

class Node1 {
	int data;
	Node1 next;

	public Node1(int data) {
		this.data = data;
	}
}

class LinkedList {

	Node1 head = null;

	public LinkedList insertAtEnd(int data, LinkedList list) {
		Node1 newNode = new Node1(data);
		if (list.head == null) {
			list.head = newNode;
		} else {

			Node1 currNode = list.head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
		}

		return list;
	}

	public void print(LinkedList list) {
		if (list.head == null) {
			return;
		}

		Node1 currNode = list.head;

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	public LinkedList remove(LinkedList list, int data) {
		if(list.head == null){
			return null;
		}
		if(list.head.data == data) {
			list.head = list.head.next;
			return list;
		}
		
		Node1 currNode = list.head;
		while(currNode.next != null) {
			if(currNode.next.data == data) {
				Node1 node = currNode.next.next;
				currNode.next = node;
				break;
			}
			currNode = currNode.next;
		}
		
		return list;
		
	}

	public boolean checkLooping(LinkedList list) {
		if (list.head == null) {
			return false;
		}

		Node1 currNode = list.head;
		HashSet<Node1> h = new HashSet<>();
		while (currNode != null) {

			if (h.contains(currNode)) {
				return true;
			}

			h.add(currNode);
			currNode = currNode.next;
		}

		return false;
	}
}

public class MainClass20 {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list = list.insertAtEnd(10, list);
		list = list.insertAtEnd(20, list);
		list = list.insertAtEnd(30, list);
		list = list.insertAtEnd(40, list);
		list = list.insertAtEnd(50, list);
		list = list.insertAtEnd(60, list);
		list = list.insertAtEnd(70, list);

		list.print(list);
		System.out.println();

		//list.head.next.next.next.next = list.head;

		System.out.println(list.checkLooping(list));
		
		list.remove(list, 40);
		list.print(list);

	}

}
