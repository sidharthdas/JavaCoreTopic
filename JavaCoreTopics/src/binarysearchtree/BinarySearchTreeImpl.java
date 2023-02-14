package binarysearchtree;

/*      Insert a node
        Remove a node
        inOrder
        preOrder
        postOrder
        Print left side of node
        Print right side of node
        Descending order
        Height of BST
        Mirror image of BST*/
public class BinarySearchTreeImpl {

//--------------------------Insert------------------------------------------

    public Node insert(int data, Node root) {
        if (root == null) {
            return createNewNode(data);
        }
        if (data < root.data) {
            root.left = insert(data, root.left);
        } else {
            root.right = insert(data, root.right);
        }

        return root;
    }

    private Node createNewNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;

        return node;
    }

//-------------------------------------------------------------------------------

//--------------------------Delete-----------------------------------------------

    public Node delete(int data, Node root) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(data, root.left);
        } else if (data > root.data) {
            root.right = delete(data, root.right);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int minVal = minVal(root.right);
                root.data = minVal;
                root.right = delete(root.data, root.right);
            }
        }

        return root;
    }

    private int minVal(Node node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

//-------------------------------------------------------------------------------

//--------------------------checkNode-----------------------------------------------
}
