package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  10/10/22
 */
public class LeecodeMainClass8 {

    public static void main(String[] args) {
        countSmaller(new int[]{5,2,6,1});

    }

    public static  List<Integer> countSmaller(int[] nums) {

        int count = 0;
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            list.add(count);
            count  = 0;

        }
        //list.add(count);
        return list;
    }

    public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(2);
        return 0;

    }


    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = Arrays.stream(nums).boxed().filter(x -> x > 0).toList();
        int num = 0;
        int last = nums.length;
        for (int i = 1; i <= last; i++) {
            if (!l.contains(i)) {
                num = i;
                break;
            }
        }

        return num;
    }


}
