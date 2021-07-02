package JUNE.programmingQuestion;

import java.util.List;

/**
 * @author sidharthdas on 01/07/21.
 */
/*
Input: root = [1,2,3,null,5]
        Output: ["1->2->5","1->3"]*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {
    }

    TreeNode ( int val ) {
        this.val = val;
    }

    TreeNode ( int val, TreeNode left, TreeNode right ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BST {


    public TreeNode insert ( TreeNode node, int val ) {
        if (node == null) {
            return createNewNode(val);
        }

        if(val < node.val){
            node.left = insert(node.left, val);
        }else if(val > node.val){
            node.right = insert(node.right, val);
        }
        return node;
    }

    private TreeNode createNewNode ( int val ) {

        TreeNode treeNode = new TreeNode(val);
        return treeNode;
    }

    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.val+" ,");
    }


}

public class LeetCodeBST {

    public static void main ( String[] args ) {

        BST b = new BST();
        TreeNode root = null;
       root = b.insert(root, 1);
        root = b.insert(root, 2);
        root = b.insert(root, 3);
        root = b.insert(root, 5);

        LeetCodeBST leetCodeBST = new LeetCodeBST();
        b.inOrder(root);



    }

    public List< String > binaryTreePaths ( TreeNode root ) {

        return null;

    }

    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.val+" ,");
    }
}
