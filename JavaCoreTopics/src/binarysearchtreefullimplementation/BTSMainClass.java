package src.binarysearchtreefullimplementation;
import src.binarysearchtreefullimplementation.Node;
import src.binarysearchtreefullimplementation.BST;

/**
 * @author sidharthdas on 12/09/22.
 */
public class BTSMainClass {
    public static void main ( String[] args ) {
        BST b = new BST();
        Node root = null;

        root = b.insert(root, 10);
        root = b.insert(root, 110);
        root = b.insert(root, 130);
        root = b.insert(root, 150);
        root = b.insert(root, 135);
        root = b.insert(root, 150);
        root = b.insert(root, 1880);
        root = b.insert(root, 1560);
        root = b.insert(root, 13430);
        root = b.insert(root, 10);

        System.out.println("Check if 110 is present or not : "+ b.check(root, 110));
        System.out.println("InOrder : ");
        b.inOrder(root);
        System.out.println();
        System.out.println("PreOrder: ");
        b.preOrder(root);
        System.out.println();
        System.out.println("PostOrder: ");
        b.postOrder(root);
        System.out.println();
        System.out.println("Delete Node with key 1880");
        root = b.delete(root, 1880);
        b.inOrder(root);
        System.out.println();
        System.out.println("Height of tree : " + b.height(root));

        System.out.println("Mirror image:");
        b.inOrder(root);
        System.out.println();
        root = b.mirror(root);
        b.inOrder(root);



    }
}
