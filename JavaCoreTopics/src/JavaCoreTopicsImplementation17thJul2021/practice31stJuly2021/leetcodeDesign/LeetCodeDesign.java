package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.leetcodeDesign;

import override.A;

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
        System.out.println(new LeetCodeDesign().tribonacci(4));

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
}
