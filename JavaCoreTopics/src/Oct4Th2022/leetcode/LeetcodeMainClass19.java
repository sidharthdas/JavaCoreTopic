package Oct4Th2022.leetcode;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  29/10/22
 */
public class LeetcodeMainClass19 {

    public static void main(String[] args) {

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