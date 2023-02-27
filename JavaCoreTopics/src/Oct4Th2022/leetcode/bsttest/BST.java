package Oct4Th2022.leetcode.bsttest;

/**
 * @author Sidharth Das
 * created on  27/02/23
 */
public class BST {

    public Node insert(Node node, int data){
        if(node == null){
            return createNewNode(data);
        }
        if(data < node.data){
            node.left = insert(node.left, data);
        }else{
            node.right = insert(node.right, data);
        }

        return node;
    }

    private Node createNewNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;
    }

    public Node delete(Node node, int data){
        if(node == null){
            return null;
        }

        if(data  < node.data){
            node.left = delete(node.left, data);
        }else if( data > node.data){
            node.right = delete(node.right, data);
        } else{
            if(node.right == null){
                return node.left;
            }else if(node.left == null){
                return node.right;
            } else {
                int min = minVal(node.right);
                node.data = min;
                node.right = delete(node.right, node.data);
            }
        }

        return node;
    }

    private int minVal(Node right) {
        int min = right.data;
        while(right.left != null){
            min = right.left.data;
            right = right.left;
        }

        return min;
    }
}
