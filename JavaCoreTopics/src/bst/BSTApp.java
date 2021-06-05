package bst;

import java.util.ArrayList;
import java.util.List;

class Node{
	
	int data;
	Node left;
	Node right;
}

class BST{
	
	List<Integer> num = new ArrayList<>();
	
	public Node createNewNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		
		return node;
	}
	
	public Node insert(Node node, int data) {
		
		if(node == null) {
			return createNewNode(data);
		}
		if(data < node.data) {
			node.left = insert(node.left, data);
		}else if(data >= node.data) {
			node.right = insert(node.right, data);
		}
		
		return node;
	}
	
	public boolean checkNode(Node node, int data) {
		if(node == null) {
			return false;
		}
		boolean isPresent = false;
		while(node != null) {
			if(data < node.data) {
				node = node.left;
			}else if(data > node.data) {
				node = node.right;
			}else if(node.data == data){
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}
	
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data+ " ");
		num.add(node.data);
		inOrder(node.right);
		
	}
	
	public void preDestory() {
		this.num = new ArrayList<>();
	}
}

public class BSTApp {
	
	public static void main(String[] args) {
		BST a = new BST();
		
		Node root = null;
		root = a.insert(root, 10);
		root = a.insert(root, 20);
		root = a.insert(root, 30);
		root = a.insert(root, 40);
		root = a.insert(root, 50);
		root = a.insert(root, 60);
		root = a.insert(root, 70);
		root = a.insert(root, 80);
		root = a.insert(root, 90);
		root = a.insert(root, 100);
		
		a.inOrder(root);
		
		System.out.println("----------------------------");
		
		System.out.println(a.num);
		a.preDestory();
		
		System.out.println(a.num);
	}

}
