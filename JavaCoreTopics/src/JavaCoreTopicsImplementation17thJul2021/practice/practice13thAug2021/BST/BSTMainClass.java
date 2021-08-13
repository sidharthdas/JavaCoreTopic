package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.BST;

/**
 * @author sidharthdas on 14/08/21.
 */
class Node {
    int data;
    Node left;
    Node right;
}

class BST {

    public Node insert ( Node node, int data ) {
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

    private Node createNode ( int data ) {
        Node node = new Node();

        node.data = data;
        node.right = null;
        node.left = null;

        return node;
    }

    public Node removeNode ( Node node, int data ) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = removeNode(node.left, data);
        } else if (data > node.data) {
            node.right = removeNode(node.right, data);

        } else {

            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                node.data = getSuccessor(node);
                node.right = removeNode(node.right, node.data);
            }
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
