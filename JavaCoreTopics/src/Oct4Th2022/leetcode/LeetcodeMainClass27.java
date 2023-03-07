package Oct4Th2022.leetcode;

import com.sun.source.tree.Tree;

/**
 * @author Sidharth Das
 * created on  07/03/23
 */
public class LeetcodeMainClass27 {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {


    }
}
class B {

    public TreeNode insert(int val, TreeNode node){
        if(node == null){
            return createNewNode(val);
        }

        node.left = insert(val, node);

        return node;
    }

    private TreeNode createNewNode(int val) {
        TreeNode node = new TreeNode();
        node.val = val;

        return node;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);

    }
}