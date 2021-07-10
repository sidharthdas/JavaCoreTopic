package JUNE.practice1;

import java.util.*;

/**
 * @author sidharthdas on 10/07/21.
 */
public class LeetCode10July {

    public static void main ( String[] args ) {
        LeetCode10July leetCode10July = new LeetCode10July();
        // System.out.println(leetCode10July.totalMoney(10));
        int[] arr = {2, 2, 2, 3, 3};


        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        //  System.out.println(leetCode10July.topKFrequent(nums, k).length);
        int[] l = {3, 2, 1, 5, 6, 4};
        System.out.println(leetCode10July.findKthLargest(l, 2));
    }

    public int numIdenticalPairs ( int[] nums ) {

        int count = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (i < j && nums[i] == nums[j]) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public int subtractProductAndSum ( int n ) {
        String s = String.valueOf(n);
        String[] srr = s.split("");
        int size = srr.length;
        int product = 1;

        int sum = 0;
        for (int i = 0; i < size; i++) {
            product *= Integer.parseInt(srr[i]);
        }

        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(srr[i]);

        }
        return product - sum;

    }

    public int numberOfSteps ( int num ) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
                count += 1;
            } else if (num % 2 == 1) {
                num = num - 1;
                count += 1;
            }
        }
        return count;
    }

    public int totalMoney ( int n ) {
        int mondayCount = 0;
        int interval = 7;
        int totalMoney = 0;
        int i = 1;
        while (n != 0) {
            if (i > interval) {
                mondayCount += 1;
                interval = interval + 7;
                i = 1;
            }

            totalMoney += i + mondayCount;
            n = n - 1;
        }
        return totalMoney;
    }

    public boolean isPowerOfTwo ( int n ) {
        if (n == 1) {
            return true;
        }
        boolean flag = true;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public void rotate ( int[] nums, int k ) {

        int startIndex = 0;
        int size = nums.length;

        for (int i = 0; i < k; i++) {

            int rotationCount = size;
            while (rotationCount != 0) {
                for (int q = 0, m = nums.length - 1; q < m; q++, m--) {
                    int temp = nums[q];
                    nums[q] = nums[m];
                    nums[m] = temp;
                }
            }


        }
    }

    public int sumOfUnique ( int[] nums ) {
        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int sum = 0;
        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() == 1) {
                sum += m.getKey();
            }
        }
        return sum;
    }

    public int countBalls ( int lowLimit, int highLimit ) {

        Map< Integer, Integer > map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {

            String s = String.valueOf(i);
            if (s.length() == 1) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            } else {
                String arr[] = s.split("");
                int sum = 0;
                for (String s1 : arr) {
                    sum += Integer.parseInt(s1);
                }

                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }


        }
        int res = 0;
        for (Map.Entry< Integer, Integer > mm : map.entrySet()) {
            if (mm.getValue() > res) {
                res = mm.getValue();
            }
        }
        return res;
    }

    public int findLucky ( int[] arr ) {

        Map< Integer, Integer > map = new HashMap<>();
        List< Integer > list = new ArrayList<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry< Integer, Integer > m : map.entrySet()) {

            if (m.getKey() == m.getValue()) {
                list.add(m.getKey());
            }

        }
        if (list.isEmpty()) {
            return -1;
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public int maxNumberOfBalloons ( String text ) {
        Map< String, Integer > map = new HashMap<>();
        String[] arr = text.split("");
        for (String s : arr) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        int count = 0;
        for (Map.Entry< String, Integer > m : map.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }

        if (!map.containsKey("b") || !map.containsKey("a") || !map.containsKey("l") || !map.containsKey("o") || !map.containsKey("n")) {
            return 0;
        }

        while (true) {
            if (map.get("b") >= 1 && map.get("a") >= 1 && map.get("l") >= 2 && map.get("o") >= 2 && map.get("n") >= 1) {
                map.put("b", map.get("b") - 1);
                map.put("a", map.get("a") - 1);
                map.put("l", map.get("l") - 2);
                map.put("o", map.get("o") - 2);
                map.put("n", map.get("n") - 1);

                count += 1;

            } else {
                break;
            }


        }

        // System.out.println(map.get("z") > 2);
        return count;
    }

    public int[] topKFrequent ( int[] nums, int k ) {
        Map< Integer, Integer > map = new HashMap<>();
        List< Integer > list = new ArrayList<>();

        if (nums.length == 1) {
            return new int[]{1};
        }

        for (int a : nums) {

            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }

        }

        Map< Integer, Integer > map1 = new TreeMap<>(map);

        for (Map.Entry< Integer, Integer > mmm : map1.entrySet()) {
            System.out.println(mmm.getKey() + " : " + mmm.getValue());
        }
        int ind = 0;
        if (map1.size() > k) {

            ind = map1.size() - k;
        }

        int count = 0;

        if (map1.size() == k) {
            int[] resArr = new int[map.size()];

            int count1 = 0;
            for (Map.Entry< Integer, Integer > mmm : map1.entrySet()) {
                resArr[count1] = mmm.getKey();
                count1 += 1;
            }
            return resArr;
        }

        for (Map.Entry< Integer, Integer > mmm : map1.entrySet()) {
            if (ind < map1.size()) {
                list.add(mmm.getKey());
                count += 1;
                ind += 1;
            }
        }
        int res[] = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

    }

    public int isPrefixOfWord ( String sentence, String searchWord ) {
        int size = searchWord.length();

        String[] str = sentence.split(" ");
        int length = str.length;
        for (int i = 0; i < length; i++) {
            if (str[i].length() >= size) {
                if (str[i].substring(0, size).equals(searchWord)) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public int findKthLargest ( int[] nums, int k ) {
        List< Integer > list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }

        Comparator< Integer > comparator = ( Integer o1, Integer o2 ) -> {
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        };

        Collections.sort(list, comparator);
        // System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(2));
        }
        return list.get(list.get(k));
    }

    public List< Integer > countSmaller ( int[] nums ) {

        int count = 0;
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int j = i +1;
            while(j < length){
                if(nums[i] > nums[j]){
                    count+=1;
                }
                j++;
            }
            list.add(count);
            count = 0;
        }

        return list;

    }
}
