package JUNE.practice.bstwithallfunctionalities1;

/**
 * @author sidharthdas on 24/06/21.
 */

/*-> For BST please follow this package JUNE.BSTWithFullImplementation

Insert a node
Remove a node
inOrder
preOrder
postOrder
Print left side of node
Print right side of node
Descending order
Height of BST
Mirror image of BST*/

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
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public void inOrder ( Node node ) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(" " + node.data);
        inOrder(node.right);
    }

    public void preOrder ( Node node ) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder ( Node node ) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(" " + node.data);
    }

    public void leftSide ( Node node ) {
        if (node == null) {
            return;
        }
        leftSide(node.left);
        System.out.print(" " + node.data);
    }

    public void rightSide ( Node node ) {
        if (node == null) {
            return;
        }
        rightSide(node.right);
        System.out.print(" " + node.data);
    }

    public void descendingOrder ( Node node ) {
        if (node == null) {
            return;
        }
        descendingOrder(node.right);
        System.out.print(" " + node.data);
        descendingOrder(node.left);
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

    public Node mirrorImage ( Node node ) {
        if (node == null) {
            return null;
        }

        Node left = mirrorImage(node.left);
        Node right = mirrorImage(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

}

public class BSTWithAllFunctionalities1MainClass {

    public static void main ( String[] args ) {

        BST b = new BST();

        Node root = null;

        root = b.insert(root, 89);
        root = b.insert(root, 819);
        root = b.insert(root, 9);
        root = b.insert(root, 8);
        root = b.insert(root, 8900);
        root = b.insert(root, 8912);
        root = b.insert(root, 89);
        root = b.insert(root, 893333);
        root = b.insert(root, 8933);
        root = b.insert(root, 8449);
        root = b.insert(root, 85559);


        System.out.println("Printing inOrder");
        b.inOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("Delete 819 inOrder");
        b.remove(root, 819);
        b.inOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("Printing preOrder");
        b.preOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("Printing postOrder");
        b.postOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("Printing leftSide");
        b.leftSide(root);
        System.out.println();
        System.out.println();
        System.out.println("Printing rightSide");
        b.rightSide(root);
        System.out.println();
        System.out.println();
        System.out.println("Printing descending order");
        b.descendingOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("Height of BST: "+b.height(root));
        System.out.println();

        System.out.println("Mirror Image:");
        root = b.mirrorImage(root);
        b.inOrder(root);
        System.out.println();







    }
}
