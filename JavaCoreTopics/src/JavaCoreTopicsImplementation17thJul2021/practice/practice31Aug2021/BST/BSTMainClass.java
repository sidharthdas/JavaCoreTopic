package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.BST;

/**
 * @author sidharthdas on 31/08/21.
 */

class Node {
    int data;
    Node left;
    Node right;

}

class BST {


    public Node insert ( Node node, int data ) {
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

    private Node create ( int data ) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;

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
        }

        return node;
    }

    private int getSuccessor ( Node node ) {
        int minVal = node.data;

        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }

        return minVal;
    }
}

public class BSTMainClass {
}
