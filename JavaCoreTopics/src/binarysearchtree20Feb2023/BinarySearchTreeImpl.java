package binarysearchtree20Feb2023;

/**
 * @author Sidharth Das
 * created on  28/02/23
 */

    /*-> For BST please follow this package src.binarysearchtreefullimplementation

    Insert a node
    Remove a node
    Check Node is Present
    inOrder
    preOrder
    postOrder
    Print left side of node
    Print right side of node
    Descending order
    Height of BST
    Mirror image of BST*/
public class BinarySearchTreeImpl implements BinarySearchTree {

    //---------------------------------Insert a node--------------------------------------------------------------------
    @Override
    public Node insert(Node node, int data) {
        if (node == null) {
            return createNewNode(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public Node createNewNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;

        return node;
    }

    //---------------------------------Remove a node--------------------------------------------------------------------
    @Override
    public Node removeNode(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = removeNode(node.left, data);
        } else if (data > node.data) {
            node.right = removeNode(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int minVal = minVal(node.right);
                node.data = minVal;
                node.right = removeNode(node.right, node.data);
            }
        }
        return node;
    }

    public int minVal(Node node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    //---------------------------------Check Node is Present------------------------------------------------------------
    @Override
    public boolean checkNode(Node node, int data) {
        if (node == null) {
            return false;
        }
        boolean flag = false;
        while (node != null) {
            if (data < node.data) {
                node = node.left;
            } else if (data > node.data) {
                node = node.right;
            } else {
                flag = true;
                break;
            }
        }

        return flag;
    }

    //---------------------------------inOrder--------------------------------------------------------------------------
    @Override
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //---------------------------------preOrder-------------------------------------------------------------------------
    @Override
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //---------------------------------postOrder------------------------------------------------------------------------
    @Override
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    //---------------------------------Print left side of node----------------------------------------------------------

    @Override
    public void leftSide(Node node) {
        if (node == null) {
            return;
        }
        leftSide(node.left);
        System.out.print(node.data + " ");
    }

    //---------------------------------Print right side of node---------------------------------------------------------

    @Override
    public void rightSide(Node node) {
        if (node == null) {
            return;
        }
        rightSide(node.right);
        System.out.print(node.data + " ");
    }
    //---------------------------------Descending order-----------------------------------------------------------------

    @Override
    public void decendingOrder(Node node) {
        if (node == null) {
            return;
        }
        decendingOrder(node.right);
        System.out.print(node.data + " ");
        decendingOrder(node.left);
    }
    //---------------------------------Height of BST--------------------------------------------------------------------

    @Override
    public int height(Node node) {
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
    //---------------------------------Mirror image of BST--------------------------------------------------------------

    @Override
    public Node mirror(Node node) {
        if (node == null) {
            return null;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

}
