package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  09/10/22
 */
public class LeetcodeMain6 {

    public static void main(String[] args) {

        System.out.println(Math.abs(-10 - 20));
        //System.out.println(checkAlmostEquivalent("zzzyyy", "iiiiii"));
    }

    public long appealSum(String s) {
        List<String> list = allSubSet(s);
        long sum = 0;
        for (String s1 : list) {
            sum +=Arrays.stream(s1.split("")).collect(Collectors.toSet()).size();
        }
        return sum;
    }

    private List<String> allSubSet(String str) {

        int len = str.length();
        List<String> list = new ArrayList<>(len * (len + 1) / 2);
        int temp = 0;
        //This loop maintains the starting character
        for (int i = 0; i < len; i++) {
            //This loop adds the next character every iteration for the subset to form and add it to the array
            for (int j = i; j < len; j++) {
                list.add(str.substring(i, j + 1));
                temp++;
            }
        }
        return list;
    }

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int rem = len * 5 / 100;
        double sum = 0.0;

        for (int i = rem; i < len - rem; i++) {
            sum += arr[i];
        }

        return sum / (len - (2 * rem));

    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int count = 0;
        for (int a : arr1) {
            boolean flag = true;
            for (int b : arr2) {
                if (d >= Math.abs(a - b)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count += 1;
            } else {
                flag = true;
            }
        }

        return count;
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (n > 0) {
                set.add(n);
            }
        }

        return set.size();
    }


    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int numArr[] = new int[len];
        for (int i = 0; i < len; i++) {
            numArr[i] = nums[nums[i]];
        }

        return numArr;

    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        String[] arr1 = word1.split("");
        String[] arr2 = word2.split("");
        Map<String, Integer> map1 = new HashMap<>();
        Set<String> s = new HashSet<>();

        for (String s1 : arr1) {
            s.add(s1);
            if (map1.containsKey(s1)) {
                map1.put(s1, map1.get(s1) + 1);
            } else {
                map1.put(s1, 1);
            }
        }
        Map<String, Integer> map2 = new HashMap<>();

        for (String s2 : arr2) {
            s.add(s2);
            if (map2.containsKey(s2)) {
                map2.put(s2, map2.get(s2) + 1);
            } else {
                map2.put(s2, 1);
            }
        }
        boolean flag = true;
        for (String s1 : s) {
            int c1 = 0;
            if (map1.containsKey(s1)) {
                c1 = map1.get(s1);
            }

            int c2 = 0;
            if (map2.containsKey(s1)) {
                c2 = map2.get(s1);
            }

            if (c1 != c2) {
                if ((c1 > c2) && (c1 - c2) > 3) {
                    flag = false;
                    break;
                } else if ((c1 < c2) && (c2 - c1) > 3) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
