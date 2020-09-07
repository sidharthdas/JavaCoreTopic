package practice7.bst;



class Node {

	int data;
	Node left;
	Node right;
}

class BST {

	public Node createNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;

		return node;
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			return createNode(data);
		}

		if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data >= node.data) {
			node.right = insert(node.right, data);
		}

		return node;
	}

	public boolean checkNode(Node node, int data) {
		if (node == null) {
			return false;
		}
		boolean isPresent = false;

		while (node != null) {
			if (data < node.data) {
				node = node.left;
			} else if (data > node.data) {
				node = node.right;
			} else {
				isPresent = true;
				break;
			}
		}

		return isPresent;
	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}

	public void decOrder(Node node) {
		if (node == null) {
			return;
		}

		decOrder(node.right);
		System.out.print(node.data+" ");
		decOrder(node.left);
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

		System.out.println(a.checkNode(root, 820));

		a.inOrder(root);
		System.out.println();
		a.decOrder(root);
		System.out.println();
		a.preOrder(root);
		System.out.println();
		a.postOrder(root);
		System.out.println();
		

	}

}
