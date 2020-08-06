package practicedatastructure;

class Node {
	int data;

	Node left;
	Node right;

}

class BST {

	public Node createNewNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;

		return node;

	}

	public Node insert(Node node, int data) {

		if (node == null) {
			return createNewNode(data);
		}
		if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data >= node.data) {
			node.right = insert(node.right, data);
		}

		return node;
	}

	public boolean check(Node node, int data) {
		if (node == null) {
			return false;
		}
		boolean isPresent = false;
		while (node != null) {
			if (data < node.data) {
				node = node.left;
			} else if (data > node.data) {
				node = node.right;
			} else if (data == node.data) {
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
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		preOrder(node.left);
		System.out.print(node.data + " ");
		preOrder(node.right);
	}
	
	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");

	}
}

public class BSTApp {

	public static void main(String[] args) {

		BST b = new BST();

		Node root = null;

		root = b.insert(root, 10);
		root = b.insert(root, 60);
		root = b.insert(root, 50);
		root = b.insert(root, 190);
		root = b.insert(root, 120);
		root = b.insert(root, 310);
		root = b.insert(root, 150);
		root = b.insert(root, 610);

		root = b.insert(root, 170);

		System.out.println(b.check(root, 50));
		System.out.println("in order");
		b.inOrder(root);
		System.out.println("pre order");
		b.preOrder(root);
		System.out.println("post order");
		b.postOrder(root);
	}

}
