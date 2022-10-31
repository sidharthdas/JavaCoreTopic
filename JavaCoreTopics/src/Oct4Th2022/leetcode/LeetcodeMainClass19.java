package Oct4Th2022.leetcode;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  29/10/22
 */
public class LeetcodeMainClass19 {

    public static void main(String[] args) {

    }

    public int minimumDifference(int[] nums, int k) {
        if(k == 1){
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < len; i++){
            if(i+k < len) {
                l.add(nums[i + k] - nums[i]);
            }
        }

        Collections.sort(l);
        return l.get(0);

    }

    public int arrayPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < len; i+=2){
            sum += nums[i];
        }

        return sum;

    }

    public int minimumSum(int num) {

        List<Integer> l = new ArrayList<>();

        while(num > 0){
            l.add(num % 10);
            num = num / 10;
        }

        Collections.sort(l);

        return (l.get(3) * 10 + l.get(0) ) + (l.get(2) * l.get(1));

    }
    List<Integer> lPre;
    public List<Integer> preorder(Node root) {
        lPre = new ArrayList<>();
        pre(root);
        return lPre;

    }

    public void pre(Node root){
        if(root == null){
            return;
        }
        lPre.add(root.val);

        for(Node child : root.children){
            pre(child);
        }
    }

    List<Integer> l;

    public List<Integer> postorder(Node root) {
        l = new ArrayList<>();
        postorder(root);
        return l;


    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            postorder(child);
        }
        l.add(root.val);
    }
}


class Solution1 {

    Map<Integer, List<Integer>> map;

    public Solution1(int[] nums) {
        map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> l = map.get(nums[i]);
                l.add(i);
                map.put(nums[i], l);

            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            }
        }

    }

    public int pick(int target) {

        int len = map.get(target).size();
        Random random = new Random();
        int i = random.nextInt((len - 1) - 0 + 1) + 0;
        return map.get(target).get(i);

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
