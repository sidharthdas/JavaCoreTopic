package practice17.bst1;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Node {
	int data;
	Node left;
	Node right;
}

class BST {

	private Node create(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;

		return node;
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			return create(data);
		}
		if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data > node.data) {
			node.right = insert(node.right, data);
		}

		return node;
	}

	public Node remove(Node node, int data) {
		if (node == null) {
			return null;
		}

		if (data < node.data) {
			node.left = remove(node.left, data);
		} else if (data > node.data) {
			node.right = remove(node.right, data);
		} else {
			if (node.left == null || node.right == null) {
				Node temp = null;
				temp = node.left == null ? node.right : node.left;

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = getSuccessor(node);
				node.right = remove(node, successor.data);
			}
		}
		return node;
	}

	private Node getSuccessor(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return null;
		}

		Node temp = node.right;
		while (temp != null) {
			temp = temp.left;
		}
		return temp;
	}

}

public class MainClass {

	public static void main(String[] args) {

		List<HashMap<String, Integer>> list = new ArrayList<>();

		List<Integer> listInt = new ArrayList<>();

		list.stream().forEach(x -> x.entrySet().stream().filter(y -> y.getValue() > 500)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
	}

}
