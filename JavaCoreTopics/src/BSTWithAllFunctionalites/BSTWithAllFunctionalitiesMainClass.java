package BSTWithAllFunctionalites;

class Node {

    int data;
    Node left;
    Node right;

}

class BST {
    //Insert into BST
    public Node insert ( Node node, int data ) {
        if (node == null) {
            return createNewNode(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else  if(data > node.data){
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

    //Removing Node from the BST
    public Node remove ( Node node, int data ) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = remove(node.right, data);
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
                node.right = remove(node, successor.data);
            }
        }
        return node;
    }

    private Node getSuccessor ( Node node ) {
        if (node == null) {
            return null;
        }
        Node temp = node.right;

        while (temp != null) {
            temp = temp.left;
        }
        return temp;
    }

    //Height of BST
    public int height ( Node node ) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);

        return left > right ? left + 1 : right + 1;
    }

    // Mirror image of BST
    public Node mirror ( Node node ) {
        if (node == null) {
            return null;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    //Print left side of BST
    public void leftSide ( Node node ) {
        if (node == null) {
            return;
        }
        leftSide(node.left);
        System.out.print(node.data + " ");
    }

    //Print right side of BST
    public void rightSide ( Node node ) {
        if (node == null) {
            return;
        }
        rightSide(node.right);
        System.out.print(node.data + " ");
    }


    //Printing Code in Ascending Order(inOrder)
    public void inOrder ( Node node ) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //Printing Code in Decending Order
    public void decendingOrder ( Node node ) {
        if (node == null) {
            return;
        }
        decendingOrder(node.right);
        System.out.print(node.data + " ");
        decendingOrder(node.left);
    }

    //Pre order
    public void preOrder ( Node node ) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //Post order
    public void postOrder ( Node node ) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }


}

public class BSTWithAllFunctionalitiesMainClass {


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

        b.inOrder(root);

        System.out.println();

        b.rightSide(root);


    }
}
