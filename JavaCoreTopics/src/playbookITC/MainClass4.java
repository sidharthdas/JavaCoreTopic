package playbookITC;

class Node {

	int data;
	Node left;
	Node right;
}

class BST {

	public Node create(int data) {
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
		System.out.print(node.data + " ");
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
			}else {
				isPresent = true;
				break;
			}
		}
		
		return isPresent;
	}
}

public class MainClass4 {

	public static void main(String[] args) {

		BST bst = new BST();

		int[] arr = { 2, 7, 3, 9, 3, 12, 77 };

		Node node = null;

		for (int a : arr) {
			node = bst.insert(node, a);
		}

		bst.inOrder(node);

		System.out.println();

		node = bst.remove(node, 12);
		bst.inOrder(node);
		
		System.out.println();
		
		
		System.out.println(bst.checkNode(node, 7));

	}

}
