/**
 *
 */
package JUNE.BSTWithFullImplementation;

/**
 * @author sidharthdas
 *
 */

/* * BST - Binary Search Tree.
 *     1. Insert a node
 *     2. Remove a node
 *     3. inOrder
 *     4. preOrder
 *     5. postOrder
 *     6. print left side of node
 *     7. print right side of node
 *     8. Descending order
 *     9. Height of BST
 *    10. Mirror image of BST

 * */
    //For BST please follow this package JUNE.BSTWithFullImplementation



class Node {

    int data;
    Node left;
    Node right;
}

class BST {
    // 1.
    public Node insert ( Node node, int data ) {
        if (node == null) {
            return createNewNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if(data > node.data) {
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

    // 2.
    public Node remove(Node node, int data){
        if(node == null){
            return null;
        }
        if(data < node.data){
            node.left = remove(node.left, data);
        }else if(data > node.data){
            node.right = remove(node.right, data);
        }else{
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }

            node.data = getSuccessor(node);
            node.right = remove(node.right, node.data);
        }
        return node;
    }

    private int getSuccessor ( Node node ) {
        int minV = node.data;
        while(node.left!= null){
            minV = node.left.data;
            node = node.left;
        }
        return minV;
    }

    // 3.
    public void inOrder ( Node node ) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // 4.
    public void preOrder ( Node node ) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 5.
    public void postOrder ( Node node ) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // 6.
    public void leftSide ( Node node ) {
        if (node == null) {
            return;
        }
        leftSide(node.left);
        System.out.print(node.data + " ");

    }

    // 7.
    public void rightSide ( Node node ) {
        if (node == null) {
            return;
        }
        rightSide(node.right);
        System.out.print(node.data + " ");

    }

    // 8.
    public void descendingOrder ( Node node ) {
        if (node == null) {
            return;
        }
        descendingOrder(node.right);
        System.out.print(node.data + " ");
        descendingOrder(node.left);
    }

    // 9.
    public int height(Node node) {
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);

        if(left > right){
            return left + 1;
        }else{
            return right +1;
        }
    }

    // 10.
    public Node mirror(Node node){
        if(node == null){
            return null;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    //Testing
    public Node delete(Node root, int data){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = delete(root.left, data);
        }else if(data > root.data){
            root.right = delete(root.right, data);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            root.data = getMinValue(root);

        }

        return null;
    }
    //Testing
    private int getMinValue ( Node root ) {
        int minV = root.data;

        while(root.left != null){
            minV = root.left.data;
            root = root.left;
        }

        return minV;
    }


}

public class BSTWithFullImplementationMainClass {

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
