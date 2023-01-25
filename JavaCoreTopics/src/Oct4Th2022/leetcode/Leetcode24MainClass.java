package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sidharth Das
 * created on  23/01/23
 */
public class Leetcode24MainClass {

    public static void main(String[] args) {

    }

    public int differenceOfSum(int[] nums) {

        int totalSum = Arrays.stream(nums).boxed().reduce(Integer::sum).get();
        int digitSum = 0;
        for (int i : nums) {
            if (i < 10) {
                digitSum += i;
            } else {
                digitSum += getSum(i);
            }
        }

        return  Math.abs(totalSum - digitSum);
    }

    private  int getSum(int n)
    {
        int sum = 0;

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }

    public int deleteGreatestValue(int[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] array : grid) {
            list.add(Arrays.stream(array).boxed().toList());
        }

        int len = list.get(0).size();
        int finalRes = 0;
        while(list.get(0).size() != 0){
            List<Integer> maxDel = new ArrayList<>();
            for(List<Integer> l : list){
                int max  = l.stream().max(Integer::compare).get();
                l.remove(new Integer(max));
                maxDel.add(max);
            }
            finalRes += maxDel.stream().max(Integer::compare).get();
        }

        return finalRes;
    }
}

class DataStream {
    int value;
    int k;
    List<Integer> l;

    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
        l = new ArrayList<>();
    }

    public boolean consec(int num) {
        l.add(num);
        if (l.size() < k) {
            return false;
        }
        int lastIn = l.size() - 1;
        int count = 0;
        while (lastIn >= 0) {
            if (l.get(lastIn) == value) {
                count++;
                if (count == k) {
                    return true;
                }
            } else {
                if (count != k) {
                    break;
                }
            }
            lastIn--;
        }

        return false;
    }
}