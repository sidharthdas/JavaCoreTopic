package playbookITC.bst;

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

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(" " + node.data);
		inOrder(node.right);
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

				temp = node.right == null ? node.left : node.right;

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {

				Node successor = getSuccessor(node);

				node.right = remove(node.right, successor.data);
			}
		}

		return node;
	}

	private Node getSuccessor(Node node) {
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

		// System.out.println(a.check(root, 80));
		a.inOrder(root);
		System.out.println();

		root = a.remove(root, 70);

		System.out.println();
		a.inOrder(root);

	}

}
