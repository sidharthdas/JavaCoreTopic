package binarysearchtree20Feb2023;

/**
 * @author Sidharth Das
 * created on  28/02/23
 */
public class MainClass {

    public static void main(String[] args) {
        
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        Node root = null;

        root = binarySearchTree.insert(root, 10);
        root = binarySearchTree.insert(root, 110);
        root = binarySearchTree.insert(root, 130);
        root = binarySearchTree.insert(root, 150);
        root = binarySearchTree.insert(root, 135);
        root = binarySearchTree.insert(root, 150);
        root = binarySearchTree.insert(root, 1880);
        root = binarySearchTree.insert(root, 1560);
        root = binarySearchTree.insert(root, 13430);
        root = binarySearchTree.insert(root, 10);

        System.out.println("Check if 110 is present or not : "+ binarySearchTree.checkNode(root, 110));
        System.out.println("Check if 110 is present or not : "+ binarySearchTree.checkNode(root, 999999));
        System.out.println("InOrder : ");
        binarySearchTree.inOrder(root);
        System.out.println();
        System.out.println("PreOrder: ");
        binarySearchTree.preOrder(root);
        System.out.println();
        System.out.println("PostOrder: ");
        binarySearchTree.postOrder(root);
        System.out.println();
        System.out.println("Delete Node with key 1880");
        root = binarySearchTree.removeNode(root, 1880);
        binarySearchTree.inOrder(root);
        System.out.println();
        System.out.println("Height of tree : " + binarySearchTree.height(root));

        System.out.println("Mirror image:");
        binarySearchTree.inOrder(root);
        System.out.println();
        root = binarySearchTree.mirror(root);
        binarySearchTree.inOrder(root);
    }
}
