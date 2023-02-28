package binarysearchtree20Feb2023;

/**
 * @author Sidharth Das
 * created on  28/02/23
 */
public interface BinarySearchTree {
    public Node insert(Node node, int data);

    public Node removeNode(Node node, int data);

    public boolean checkNode(Node node, int data);

    public void inOrder(Node node);

    public void preOrder(Node node);

    public void postOrder(Node node);

    public void leftSide(Node node);

    public void rightSide(Node node);

    public void decendingOrder(Node node);

    public int height(Node node);

    public Node mirror(Node node);
}
