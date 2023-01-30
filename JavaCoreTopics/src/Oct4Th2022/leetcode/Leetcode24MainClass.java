package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sidharth Das
 * created on  23/01/23
 */
public class Leetcode24MainClass {

    public static void main(String[] args) {
        //System.out.println(deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}}));
        //System.out.println(countOperations(2, 3));
        System.out.println(distributeCandies(10,3));

    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int currIndex = 0;
        int initialCandy = 1;
        while(candies != 0){
            if(currIndex == num_people){
                currIndex = 0;
            }
            if(initialCandy < candies) {
                people[currIndex] += initialCandy;
                candies -= initialCandy;
                initialCandy += 1;
                currIndex++;
            }
            else{
                people[currIndex] += candies;
                break;
            }
        }

        return people;
    }

    public int alternateDigitSum(int n) {
        List<Integer> l = new ArrayList<>();

        while (n != 0) {
            l.add(n % 10);
            n = n / 10;
        }
        int sum = 0;
        boolean flag = true;
        int len = l.size();
        for(int i = len - 1; i >=0;i--){
            if(flag){
                sum += l.get(i);
                flag = false;
            }else{
                sum -= l.get(i);
                flag = true;
            }

        }
        return sum;
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;
        while(num1 != 0 && num2 != 0){
            if(num1 >= num2){
                count++;
                num1 -= num2;
            }else{
                count++;
                num2 -= num1;
            }
        }

        return count;
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

        return Math.abs(totalSum - digitSum);
    }

    private int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }

    public int pivotInteger(int n) {
        int mid = n /2;

        while(!(mid > n)){
            if(suminRange(1,mid) == suminRange(mid, n)){
                return mid;
            }
            mid += 1;
        }

        return -1;
    }

    private int suminRange(int l, int r)
    {
        return sumNatural(r) - sumNatural(l - 1);
    }

    private int sumNatural(int n)
    {
        int sum = (n * (n + 1)) / 2;
        return sum;
    }

    public int countDigits(int num) {
        int n = num;
        List<Integer> l = new ArrayList<>();
        while (num != 0) {
            int k = num % 10;
            num = num / 10;
            l.add(k);
        }

        return (int) l.stream().filter(x -> n % x == 0).count();
    }

    public double[] convertTemperature(double celsius) {
        return new double[]{(celsius + 273.15), ((celsius * 1.80) + 32.00)};
    }

    public static int deleteGreatestValue(int[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] array : grid) {
            list.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
            //Arrays.stream(array).boxed().collect(Collectors.im)
        }

        int len = list.get(0).size();
        int finalRes = 0;
        while (list.get(0).size() != 0) {
            List<Integer> maxDel = new ArrayList<>();
            for (List<Integer> l : list) {
                int max = l.stream().max(Integer::compare).get();
                l.remove(Integer.valueOf(max));
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