package JavaCoreTopicsImplementation17thJul2021.practice.practice31stJuly2021.leetcodeDesign;

import java.util.*;

/**
 * @author sidharthdas on 12/08/21.
 */

class BrowserHistory {

    List< String > list = new ArrayList<>();
    String current = null;


    public BrowserHistory ( String homepage ) {
        list.add(homepage);
        current = homepage;

    }

    public void visit ( String url ) {
        list.add(url);
        current = url;

    }

    public String back ( int steps ) {
        int size = list.size();
        if (steps > size) {
            current = list.get(0);
            return list.get(0);
        } else {
            current = list.get(list.size() - 1 - steps);
            return list.get(list.size() - 1 - steps);
        }

    }

    public String forward ( int steps ) {
        int size = list.size();

        if (size < steps) {
            return null;
        }

        return null;
    }
}

public class LeetCodeDesign {

    public static void main ( String[] args ) {

        List< String > list = Arrays.asList("Sidharth", "Ram", "Shayam", "Raju");

        int step = 2;
       new LeetCodeDesign().moveZeroes(new int[]{0,0,1});

    }

    public int arrangeCoins ( int n ) {

        if (n == 1) {
            return 1;
        }
        Map< Integer, Integer > map = new HashMap<>();

        for (int i = 1; i < n; i++) {
            if (n - i > 0) {
                map.put(i, i);
                n = n - i;
            }
        }
        if (map.size() + 1 == n) {
            return (int) map.entrySet().stream().count() + 1;
        }
        return (int) map.entrySet().stream().count();

    }

    public int tribonacci ( int n ) {

        int zero = 0;
        int first = 1;
        int second = 1;

        if (n == 0) {
            return zero;
        }
        if (n == 1) {
            return first;
        }

        if (n == 2) {
            return second;
        }

        int count = 2;

        while (true) {
            int newNumber = zero + first + second;
            int temp1 = second;
            int temp2 = first;
            int temp3 = zero;
            second = newNumber;
            first = temp1;
            zero = temp2;

            count += 1;

            if (count == n) {
                return second;
            }
        }


    }

    public int findKthPositive ( int[] arr, int k ) {
        List< Integer > arrList = new ArrayList<>();
        List< Integer > missingNums = new ArrayList<>();

        for (int i : arr) {
            arrList.add(i);
        }

        int lastElement = arrList.get(arrList.size());
        for (int i = 1; i <= lastElement; i++) {
            if (!arrList.contains(i)) {
                missingNums.add(i);
                if (missingNums.size() - 1 == k) {
                    return missingNums.get(missingNums.size() - 1);
                }
            }
        }
        return -1;
    }

    public List< List< String > > groupAnagrams ( String[] strs ) {

        Map< String, List< String > > map = new LinkedHashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String s1 = String.valueOf(c);

            if (map.containsKey(s1)) {
                if (map.get(s1) == null) {
                    List< String > l = new ArrayList<>();
                    l.add(s);
                    map.put(s1, l);
                } else {
                    List< String > l = map.get(s1);
                    l.add(s);
                    map.put(s1, l);
                }
            } else {
                List< String > l = new ArrayList<>();
                l.add(s);
                map.put(s1, l);

            }
        }
        List< List< String > > finalList = new ArrayList<>();
        for (Map.Entry< String, List< String > > m : map.entrySet()) {
            finalList.add(m.getValue());
        }

        return finalList;
    }

    public boolean containsNearbyDuplicate ( int[] nums, int k ) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((nums[i] == nums[j]) && Math.abs(i - j) <= k) {
                    return true;

                }
            }
        }
        return false;
    }

    public int removeElement ( int[] nums, int val ) {

        List< Integer > l = new ArrayList<>();

        for (int i : nums) {
            if (i != val) {
                l.add(i);
            }
        }

        int len = l.size();
        int size = nums.length;

        int numOfDuplicates = size - len;
        System.out.println(numOfDuplicates);
        int count = 0;
        int index = 1;
        for (int i = 0; i < size; ) {
            if (count == numOfDuplicates) {
                break;
            }
            if (nums[i] == val) {
                for (int j = i; j < size; j++) {
                    if (j + 1 < size) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;

                    }
                }
                count += 1;

            } else {
                if (count == numOfDuplicates) {
                    break;
                }
                i++;
            }

        }
        return len;


    }

    public void moveZeroes ( int[] nums ) {
        List< Integer > l = new ArrayList<>();

        for (int i : nums) {
            if (i != 0) {
                l.add(i);
            }
        }

        int len = l.size();
        int size = nums.length;

        int numOfDuplicates = size - len;
        System.out.println(numOfDuplicates);

        int count = 0;
        for (int i = 0; i < size;) {
            if (count == numOfDuplicates) {
                break;
            }
            if (nums[i] == 0) {
                for (int j = i; j < size; j++) {
                    if (j + 1 < size) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;

                    }
                }
                count += 1;

            } else {
                if (count == numOfDuplicates) {
                    break;
                }
                i++;
            }

        }
    }
}


