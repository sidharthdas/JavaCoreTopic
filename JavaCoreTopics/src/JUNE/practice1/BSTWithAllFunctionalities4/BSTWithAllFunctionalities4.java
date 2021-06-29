package JUNE.practice1.BSTWithAllFunctionalities4;

/**
 * @author sidharthdas on 28/06/21.
 */

class Node{
    int data;
    Node left;
    Node right;
}

class BST{

    public Node insert(Node node, int data){
        if(node == null){
            return createNewNode(data);
        }
        if(data < node.data){
            node.left = insert(node.left, data);
        }else if(data > node.data){
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


    public Node remove(Node node , int data){
        if(node == null){
            return null;
        }
        if(data< node.data){
            node.left = remove(node.left, data);
        }else if(data > node.data){
            node.right = remove(node.right, data);
        }else{
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }

            node.data= getSuccessor(node);
            node.right = remove(node.right, node.data);
        }

        return node;
    }

    private int getSuccessor ( Node node ) {
        int minV = node.data;

        while(node.left != null){
            minV = node.left.data;
            node = node.left;
        }

        return minV;
    }

//java           100
}
public class BSTWithAllFunctionalities4 {

    public static void main ( String[] args ) {

    }
}
