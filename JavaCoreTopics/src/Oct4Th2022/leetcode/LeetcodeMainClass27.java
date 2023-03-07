package Oct4Th2022.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  07/03/23
 */
public class LeetcodeMainClass27 {

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 1, 2, 3}, new int[]{9, 5, 1, 2}}));
    }


    //You are given a 0-indexed integer array nums and two integers key and k.
    // A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and nums[j] == key.
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        int len = nums.length;
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(Math.abs(i-j) <= k && nums[j] == key){
                    l.add(i);
                }
            }
        }

        return l.stream().sorted().collect(Collectors.toSet()).stream().toList();
    }

    public static int findMiddleIndex(int[] nums) {
        int left = 0;
        int right = 0;

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            left = 0;
            right = 0;

            for (int j = 0; i < i; j++) {
                left += nums[j];
            }

            for (int j = i + 1; i < len; j++) {
                right += nums[j];
            }

            if (left == right) {
                return i;
            }
        }

        return -1;
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 1; i < row; i++) {

            for (int j = 1; j < col; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
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