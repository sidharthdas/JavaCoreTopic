package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.bst;

/**
 * @author sidharthdas on 05/09/21.
 */

class Node {

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
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            }

            node.data = getSuccessor(node);
            node.right = remove(node.right, node.data);
        }

        return node;
    }

    private int getSuccessor ( Node node ) {
        int minValue = node.data;

        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }

        return minValue;
    }


    public Node mirror ( Node node ) {
        if (node == null) {
            return null;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.right = left;
        node.left = right;

        return node;
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


    public boolean isPresent ( Node node, int data ) {
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

}

public class BSTMainClass {
}
