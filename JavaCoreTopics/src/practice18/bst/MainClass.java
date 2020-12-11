/**
 * 
 */
package practice18.bst;



/**
 * @author sidharthdas
 *
 */

class Node {
	int data;
	Node left;
	Node right;

}

class BST {

	private Node createNode(int data) {
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
		} else if (data > node.data) {
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
				node.right = remove(node.right, successor.data);
			}
		}
		return node;

	}

	/**
	 * @param node
	 * @return
	 */
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

	public int height(Node node) {
		if (node == null) {
			return 0;
		}

		int left = height(node.left);
		int right = height(node.right);

		if (left > right) {
			return left + 1;
		} else {
			return right + 1;
		}
	}

	public Node mirror(Node node) {
		if (node == null) {
			return null;
		}

		Node left = mirror(node.left);
		Node right = mirror(node.right);

		node.left = right;
		node.right = left;

		return node;
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
		System.out.print(node.data + " ");

		preOrder(node.left);

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

public class MainClass {
	
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

		System.out.println(a.checkNode(root, 80));
		System.out.println("inorder");
		a.inOrder(root);

		System.out.println("\npreOrder");
		a.preOrder(root);
		System.out.println("\npostorder");
		a.postOrder(root);

		System.out.println();
		root = a.remove(root, 90);
		System.out.println();
		a.preOrder(root);

		System.out.println();
		System.out.println("Height of BST : " + a.height(root));

		root = a.mirror(root);
		a.inOrder(root);
	}

}
