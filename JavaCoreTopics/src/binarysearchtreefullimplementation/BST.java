package src.binarysearchtreefullimplementation;

/**
 * @author sidharthdas on 12/09/22.
 */
public class BST {

    public Node createNewNode ( int data ) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;

        return node;
    }

    public Node insert ( Node root, int data ) {
        if (root == null) {
            return createNewNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data >= root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public Node delete ( Node root, int data ) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minVal(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private int minVal ( Node root ) {
        int minV = root.data;
        while (root.left != null) {
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }

    public void inOrder ( Node root ) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder ( Node root ) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder ( Node root ) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public boolean check ( Node root, int data ) {
        if (root == null) {
            return false;
        }
        boolean flag = false;
        while (root != null) {
            if (data < root.data) {
                root = root.left;
            } else if (data > root.data) {
                root = root.right;
            } else {
                flag = true;
                break;
            }

        }
        return flag;
    }

    public int height ( Node root ) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public Node mirror(Node root){
        if(root == null){
            return null;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
