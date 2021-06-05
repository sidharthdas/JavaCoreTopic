/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left;
	Node right;
}

class BST {

	List<Integer> result = new ArrayList<>();

	public Node createNewNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;

		return node;
	}

	public Node insertNewNode(Node node, int data) {
		if (node == null)
			return createNewNode(data);
		if (data < node.data)
			node.left = insertNewNode(node.left, data);
		if (data > node.data)
			node.right = insertNewNode(node.right, data);

		return node;
	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data+" ");
		result.add(node.data);
		inOrder(node.right);
	}
}

public class GFGBST {

	public static void main(String[] args) {
// TODO Auto-generated method stub

		int[] nums = { 5, 2, 3, 1 };

		int[] finalRes = sortArray(nums);
		
		System.out.println("Size is : " + finalRes.length);
		for (int i : finalRes) {
			System.out.println(i);
		}

	}

	public static int[] sortArray(int[] nums) {

		BST b = new BST();
		Node root = null;
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			root = b.insertNewNode(root, nums[i]);
		}
		b.inOrder(root);
		System.out.println();
		List<Integer> result = b.result;

		int[] resultArr = new int[result.size()];
		int count = 0;
		for (int i : result) {
			resultArr[count] = i;
			count++;

		}

		return resultArr;
	}

}