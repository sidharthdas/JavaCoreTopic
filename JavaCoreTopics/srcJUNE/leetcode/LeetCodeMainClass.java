package srcJUNE.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sidharthdas on 04/07/21.
 */
public class LeetCodeMainClass {
    public static void main ( String[] args ) {

        int[] arr = {3,3};

        LeetCodeMainClass mainClass = new LeetCodeMainClass();

        int[] outPut =  mainClass.twoSum1(arr, 6);

        for(int i : outPut){
            System.out.println(i);
        }

    }

    public int[] twoSum(int[] nums, int target) {

        int x = 0;
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++) {

            if (contain(nums, target - nums[i])) {
                indexes[x] = index(nums, nums[i]);
                x += 1;
                indexes[x] = index(nums, (target - nums[i]));
                break;
            }
        }

        return indexes;

    }

    public static boolean contain(int[] arr, int num) {
        boolean isPresent = false;
        for (int i : arr) {
            if (i == num) {
                isPresent = true;
                break;
            }
        }

        return isPresent;
    }

    public static int index(int[] arr, int num) {
        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }

        return -1;

    }


    public int[] twoSum1(int[] nums, int target) {
        int x = 0;
        int[] indexes = new int[2];

        for(int i = 0; i < nums.length; i++){
            int numToBeSerched = target - nums[i];
            if(numToBeSerched != nums[i]){
                if (contain(nums, target - nums[i])) {
                    indexes[x] = index(nums, nums[i]);
                    x += 1;
                    indexes[x] = index(nums, (target - nums[i]));
                    break;
                }

            }else{
                int count = 0;
                List<Integer> ind = new ArrayList<>();
                for(int j = 0; j < nums.length; j++){

                    if(nums[i] == nums[j]){
                        count++;
                        ind.add(j);
                    }

                }
                if(count == 2){
                    int[] indexArr = new  int[2];
                    for(int z = 0; z < 2; z++){
                        indexArr[z] = ind.get(z);
                    }

                    return indexArr;
                }

            }
        }
        return indexes;

    }


}
