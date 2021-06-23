package JUNE.practice.bstwithallfunctionalities;

/**
 * @author sidharthdas on 23/06/21.
 */

class Node {
    int data;
    Node left;
    Node right;
}

class BST {

    public Node insert ( Node root, int data ) {
        if (root == null) {
            return createNewNode(data);
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }else if(data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }

    private Node createNewNode ( int data ) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;
    }

    public Node remove(Node root, int data){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = remove(root.left, data);
        }else if(data > root.data){
            root.right = remove(root.right, data);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            root.data = getMinValue(root);

            root.right = remove(root.right, root.data);

             }
        return root;
    }

    private int getMinValue ( Node root ) {
        int minV = root.data;
        while(root.left != null){
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
}

public class BSTWithAllFunctionalitiesPracticeMainClass {

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
        System.out.println("After removing");
        b.remove(root, 819);
        b.inOrder(root);

    }
}
