package Oct4Th2022.binarysearchtree;

public class BST {

    public Node createNode(int data){
        Node node = new Node();
        node.data = data;
        node.right = node.left = null;
        return node;
    }

    public Node insert(Node node, int data){
        if(node == null){
            return createNode(data);
        }
        if(data <  node.data){
            node.left = insert(node.left, data);
        }else if(data >= node.data){
            node.right = insert(node.right, data);
        }
        return node;
    }

    public Node delete(Node node, int data){
        if(node == null){
            return null;
        }
        if(data < node.data){
            node.left = delete(node.left, data);

        }else if(data > node.data){
            node.right = delete(node.right, data);
        }else{
            if(node.right == null){
                return node.left;
            }else if(node.left == null){
                return node.right;
            }else{
                int smallestNumber = getSuccessor(node.right);
                node.data = smallestNumber;
                node.right = delete(node.right, node.data);
            }
        }

        return node;
    }

    private int getSuccessor(Node node) {
        int data = node.data;
        while(node.left != null){
            data = node.left.data;
            node = node.left;
        }
        return data;
    }

}
