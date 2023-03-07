package Oct4Th2022.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  07/03/23
 */
public class LeetcodeMainClass27 {

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{new int[]{1,2,3,4},new int[]{5,1,2,3},new int[]{9,5,1,2}}));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 1; i < row; i++) {

            for (int j = 1; j < col; j++) {
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] diStringMatch(String s) {
        int len = s.length();
        String[] srr = s.split("");
        int lower = 0;
        int upper = len;

        List<Integer> l = new ArrayList<>();

        for (String s1 : srr) {
            if (s1.equals("I")) {
                l.add(lower);
                lower++;
            } else if (s1.equals("D")) {
                l.add(upper);
                upper--;
            }
        }
        int missingNumber = (len * (len + 1)) / 2 - l.stream().reduce(Integer::sum).get();
        l.add(missingNumber);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}

class B {

    public TreeNode insert(int val, TreeNode node) {
        if (node == null) {
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

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

    }
}