/**
 * 
 */
package text.programming;

/**
 * @author sidharthdas
 *
 */

class Node{
	int data;
	Node left;
	Node right;
}

class BST{
	
	public Node insert(int data, Node node) {
		if(node == null) {
			return createNewNode(data);
		}
		if(data< node.data) {
			node.left = insert(data, node.left);
		}else {
			node.right = insert(data, node.right);
		}
		
		return node;
	}

	/**
	 * @param data
	 * @return
	 */
	private Node createNewNode(int data) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return node;
	}
	
	public boolean checkNode(Node node, int data) {
		if(node == null) {
			return false;
		}
		boolean flag = false;
		if(data< node.data) {
			node = node.left;
		}else if(data > node.data) {
			node = node.right;
		}else {
			flag = true;
			
		}
		
		return flag;
	}
	
	public Node remove(Node node, int data) {
		if(node == null) {
			return null;
		}
		if(data< node.data) {
			node.left = remove(node.left, data);
		}else if(data > node.data) {
			node.right = remove(node.right, data);
		}else {
			if(node.left == null || node.right == null) {
				Node temp = null;
				temp = node.left == null ? node.right : node.left;
				
				if(temp == null) {
					return null;
				}else {
					return temp;
				}
			}else {
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
		if(node == null) {
			return null;
		}
		Node temp = node.right;
		
		while(temp != null) {
			temp = temp.left;
		}
		return temp;
	}
	
	public int height(Node node) {
		if(node == null) {
			return 0;
		}
		
		int left = height(node.left);
		int right = height(node.right);
		
		if(left > right) {
			return left+1;
		}else return right+1;
	}
	
	
	public Node mirror(Node node) {
		if(node == null) {
			return null;
		}
		
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		
		node.left = right;
		node.right =left;
		
		return node;
	}
	
	
	
}
public class BSTApp {

}
