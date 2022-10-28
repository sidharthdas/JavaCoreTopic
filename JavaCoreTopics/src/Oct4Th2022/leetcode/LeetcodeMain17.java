package Oct4Th2022.leetcode;

/**
 * @author Sidharth Das
 * created on  28/10/22
 */
public class LeetcodeMain17 {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        int mid = len / 2;

        TreeNode root = null;

        for(int i = mid; i >=0; i--){
            root = insert(root, nums[i]);
        }

        for(int i = mid; i <len; i++){
            root = insert(root, nums[i]);
        }
        return root;
    }

    public TreeNode create(int data) {
        TreeNode t = new TreeNode(data);
        return t;
    }

    public TreeNode insert(TreeNode t, int data) {
        if (t == null) {
            return create(data);
        }
        if (data < t.val) {
            t.left = insert(t.left, data);
        } else if (data > t.val) {
            t.right = insert(t.right, data);
        }

        return t;
    }


}