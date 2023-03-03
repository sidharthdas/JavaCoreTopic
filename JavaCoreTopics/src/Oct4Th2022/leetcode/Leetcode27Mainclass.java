package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Sidharth Das
 * created on  03/03/23
 */
public class Leetcode27Mainclass {

    public static void main(String[] args) {

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        BinarySearchTreeImpl b = new BinarySearchTreeImpl();
        while (b.checkTreeNode(root, target)) {
            root = b.removeTreeNode(root, target);
        }

        return root;

    }
}

class BinarySearchTreeImpl {


    public TreeNode createNewTreeNode(int data) {
        TreeNode TreeNode = new TreeNode();
        TreeNode.val = data;
        TreeNode.left = TreeNode.right = null;

        return TreeNode;
    }

    //---------------------------------Remove a TreeNode--------------------------------------------------------------------

    public TreeNode removeTreeNode(TreeNode TreeNode, int data) {
        if (TreeNode == null) {
            return null;
        }

        if (data < TreeNode.val) {
            TreeNode.left = removeTreeNode(TreeNode.left, data);
        } else if (data > TreeNode.val) {
            TreeNode.right = removeTreeNode(TreeNode.right, data);
        } else {
            if (TreeNode.left == null) {
                return TreeNode.right;
            } else if (TreeNode.right == null) {
                return TreeNode.left;
            } else {
                int minVal = minVal(TreeNode.right);
                TreeNode.val = minVal;
                TreeNode.right = removeTreeNode(TreeNode.right, TreeNode.val);
            }
        }
        return TreeNode;
    }

    public int minVal(TreeNode TreeNode) {
        int min = TreeNode.val;
        while (TreeNode.left != null) {
            min = TreeNode.left.val;
            TreeNode = TreeNode.left;
        }
        return min;
    }

    //---------------------------------Check TreeNode is Present------------------------------------------------------------
    public boolean checkTreeNode(TreeNode TreeNode, int data) {
        if (TreeNode == null) {
            return false;
        }
        boolean flag = false;
        while (TreeNode != null) {
            if (data < TreeNode.val) {
                TreeNode = TreeNode.left;
            } else if (data > TreeNode.val) {
                TreeNode = TreeNode.right;
            } else {
                flag = true;
                break;
            }
        }

        return flag;
    }
}

class BSTIterator {

    List<Integer> l;
    int len;
    int curr;

    public BSTIterator(TreeNode root) {
        BST1 B = new BST1();
        B.inOrder(root);
        this.l = B.l;
        len = this.l.size();
        this.curr = 0;

    }

    public int next() {
        int data = -1;
        if (curr < len) {
            data = l.get(curr);
            curr++;
        }

        return data;

    }

    public boolean hasNext() {
        return curr < len;

    }
}

class BST1 {

    List<Integer> l = new ArrayList<>();

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        l.add(root.val);
        inOrder(root.right);
    }
}


class CustomStack {

    Stack<Integer> stack;


    public CustomStack(int maxSize) {
    }

    public void push(int x) {

    }

    public int pop() {

    }

    public void increment(int k, int val) {

    }
}