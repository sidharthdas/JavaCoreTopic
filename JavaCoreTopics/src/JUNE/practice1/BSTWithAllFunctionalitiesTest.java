package JUNE.practice1;

/**
 * @author sidharthdas on 25/06/21.
 */

/*Insert a node
        Remove a node
        inOrder
        preOrder
        postOrder
        Print left side of node
        Print right side of node
        Descending order
        Height of BST
        Mirror image of BST*/

class Node{
    int data;
    Node left;
    Node right;
}

class BST {


    public Node insert ( Node node, int data ) {
        if (node == null) {
            return createNewNode(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    private Node createNewNode ( int data ) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;
    }

    public Node remove ( Node node, int data ) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = remove(node.left, data);
        } else if (data > node.data) {
            node.right = remove(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = getSuccessor(node);
            node.right = remove(node.right, node.data);
        }
        return node;
    }

    private int getSuccessor ( Node node ) {
        int minV = node.data;

        while (node.left != null) {
            minV = node.left.data;
            node = node.left;
        }
        return minV;
    }


    public int height ( Node node ) {
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



}

public class BSTWithAllFunctionalitiesTest {

    public static void main ( String[] args ) {

    }
}
