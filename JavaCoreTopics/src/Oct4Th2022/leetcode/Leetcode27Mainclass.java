package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  03/03/23
 */
public class Leetcode27Mainclass {

    public static void main(String[] args) {

        CustomStack1 stk = new CustomStack1(3); // Stack is Empty []
        stk.push(1);                          // stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.push(3);                          // stack becomes [1, 2, 3]
        stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
        stk.increment(5, 100);                // stack becomes [101, 102, 103]
        stk.increment(2, 100);                // stack becomes [201, 202, 103]
        stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
        stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
        stk.pop();                            // return -1 --> Stack is empty return -1.

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


class CustomStack1 {

    Stack<Integer> stack;
    int maxSize;
    int currentSize;


    public CustomStack1(int maxSize) {
        stack = new Stack<>();
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public void push(int x) {
        if (currentSize < maxSize) {
            stack.push(x);
            currentSize++;
        }

    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        currentSize--;
        return stack.pop();
    }

    public void increment(int k, int val) {

        List<Integer> l1 = new ArrayList<>();
        while (!stack.isEmpty()) {
            l1.add(0, stack.pop());
        }
        if (l1.size() <= k) {
            l1 = l1.stream().map(x -> x + val).collect(Collectors.toList());
        } else {
            int len = l1.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (k >= 1) {
                    temp.add(l1.get(i) + val);
                    k--;
                } else {
                    temp.add(l1.get(i));
                }
            }
            l1 = temp;
        }
        l1.forEach(x -> {
            stack.push(x);
        });
    }
}