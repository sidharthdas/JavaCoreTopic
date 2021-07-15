package JUNE.practice1;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 14/07/21.
 */

class Employee {
    public int id;
    public int importance;
    public List< Integer > subordinates;
};

public class LeetCode14thJuly {

    public static void main ( String[] args ) {
        LeetCode14thJuly leetCode14thJuly = new LeetCode14thJuly();
        int[] arr = {3, 2, 4};

        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        String allowed = "ab";

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        System.out.println(leetCode14thJuly.relativeSortArray(arr1, arr2));

    }

    public int maximumProduct ( int[] nums ) {

        List< Integer > list = new ArrayList<>();

        for (int i : nums) {
            list.add(i);
        }

        int product = list.stream().reduce(0, ( a, b ) -> a * b);

        return product;

    }

    public String frequencySort ( String s ) {
        String[] str = s.split("");

        Map< String, Integer > map = new HashMap<>();
        for (String ss : str) {
            if (map.containsKey(ss)) {
                map.put(ss, map.get(ss) + 1);
            } else {
                map.put(ss, 1);
            }
        }

        List< Integer > list = new ArrayList<>();
        for (Map.Entry< String, Integer > m : map.entrySet()) {
            list.add(m.getValue());
        }

        Collections.sort(list);
        int sizeofList = list.size();
        String res = "";
        for (int i = sizeofList - 1; i >= 0; i--) {
            for (Map.Entry< String, Integer > m : map.entrySet()) {
                if (m.getValue() == list.get(i)) {
                    for (int j = 0; j < m.getValue(); j++) {
                        res += m.getKey();

                    }
                }
            }
        }


        return res;
    }

    public int numJewelsInStones ( String jewels, String stones ) {
        String str[] = jewels.split("");
        String str1[] = stones.split("");
        int count = 0;

        Map< String, Integer > map = new HashMap<>();

        for (String s : str) {
            if (stones.contains(s)) {
                for (String s1 : str1) {
                    if (s.equals(s1)) {
                        count += 1;
                    }
                }
            }

            map.put(s, count);
            count = 0;
        }
        int totalSum = 0;
        for (Map.Entry< String, Integer > m : map.entrySet()) {

            totalSum += m.getValue();
        }

        return totalSum;
    }

    public int majorityElement ( int[] nums ) {

        int major = nums.length / 2;

        Map< Integer, Integer > map = new HashMap<>();

        for (int num : nums) {

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() > major) {
                return m.getKey();
            }
        }
        return -1;
    }

    public int getImportance ( List< Employee > employees, int id ) {

        int sum = 0;

        Employee emp1 = null;

        for (Employee emp : employees) {
            if (emp.id == id) {
                emp1 = emp;
                break;
            }
        }

        sum += emp1.importance;

        List< Integer > ids = new ArrayList<>();
        ids.addAll(emp1.subordinates);

        for (int i : ids) {
            for (Employee e : employees) {
                if (i == e.id) {
                    if (e.subordinates.size() != 0) {
                        ids.addAll(e.subordinates);
                    }
                }
            }
        }

        for (int i : ids) {
            for (Employee e : employees) {
                if (e.id == i) {
                    sum += e.importance;
                    break;
                }
            }
        }


        return sum;
    }


    public int[] findErrorNums ( int[] nums ) {
        int numLen = nums.length;

        Map< Integer, Integer > m = new HashMap<>();

        for (int i : nums) {

            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
        }

        int size = m.keySet().size();
        int totalSum = (numLen * (numLen + 1)) / 2;

        int numMissed = m.keySet().stream().reduce(0, Integer::sum);

        int[] res = new int[2];

        for (Map.Entry< Integer, Integer > map : m.entrySet()) {
            if (map.getValue() == 2) {
                res[0] = map.getKey();
                break;
            }

        }

        res[1] = totalSum - numMissed;
        return res;

    }

    public int repeatedNTimes ( int[] nums ) {

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {

            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }

        }


        for (Map.Entry< Integer, Integer > M : map.entrySet()) {
            if (M.getValue() > 1) {
                return M.getKey();
            }
        }
        return 0;
    }

    public boolean uniqueOccurrences ( int[] arr ) {

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : arr) {

            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }

        }
        List< Integer > list = new ArrayList<>();
        for (Map.Entry< Integer, Integer > M : map.entrySet()) {
            list.add(M.getValue());
        }

        Set< Integer > set = new HashSet<>(list);

        return set.size() == list.size();
    }

    public String[] findWords ( String[] words ) {

        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        for (String s : words) {
            int count = 0;

            String[] str = s.split("");

            Set< String > set = new HashSet<>();
            for (String s1 : str) {
                set.add(s1);
            }


        }

        return null;
    }

    public String mostCommonWord ( String paragraph, String[] banned ) {

        paragraph = paragraph.replaceAll(".", "");

        paragraph = paragraph.toLowerCase();

        List< String > list = new ArrayList<>();
        for (String s : banned) {
            list.add(s);
        }

        String[] strPara = paragraph.split(" ");
        Map< String, Integer > map = new HashMap<>();
        for (String s1 : strPara) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }

        map.remove(" ");
        map.remove("");

        final Map< String, Integer > sortedByCount = map.entrySet()
                .stream()
                .sorted((Map.Entry.< String, Integer >comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

        for (Map.Entry< String, Integer > m : sortedByCount.entrySet()) {

            if (!list.contains(m.getKey())) {
                return m.getKey();
            }
        }
        return null;
    }

    public String frequencySort1 ( String s ) {
        String[] str = s.split("");

        Map< String, Integer > map = new HashMap<>();
        for (String ss : str) {
            if (map.containsKey(ss)) {
                map.put(ss, map.get(ss) + 1);
            } else {
                map.put(ss, 1);
            }
        }

        final Map< String, Integer > sortedByCount = map.entrySet()
                .stream()
                .sorted((Map.Entry.< String, Integer >comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

        String res = "";

        for (Map.Entry< String, Integer > m : sortedByCount.entrySet()) {
            for (int i = 0; i < m.getValue(); i++) {
                res += m.getKey();
            }
        }

        return res;
    }

    public int busyStudent ( int[] startTime, int[] endTime, int queryTime ) {

        int count = 0;

        int length = startTime.length;

        for (int i = 0; i < length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count += 1;
            }
        }

        return count;
    }


    public int[] twoSum ( int[] nums, int target ) {
        int[] ind = new int[2];
        int index = 0;
        int len = nums.length;
        int firstValue = nums[0];
        for (int i = 0; i <= len; i++) {
            if (i < len && i != index) {
                if (firstValue + nums[i] == target) {
                    ind[0] = index;
                    ind[1] = i;
                    return ind;
                } else if (i == len - 1) {
                    index += 1;
                    firstValue = nums[index];
                    i = 0;
                    System.out.println(i);

                }
            }

        }
        return null;
    }


    public String[] findRestaurant ( String[] list1, String[] list2 ) {

        List< String > l1 = new ArrayList<>();
        for (String s : list1) {
            l1.add(s);
        }


        List< String > l2 = new ArrayList<>();
        for (String s : list2) {
            l2.add(s);
        }

        List< String > res = new ArrayList<>();

        for (String s : l1) {
            if (l2.contains(s)) {
                res.add(s);
            }
        }

        int size = res.size();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }

        return result;
    }


    public String[] uncommonFromSentences ( String s1, String s2 ) {

        Map< String, Integer > map1 = new HashMap<>();
        Map< String, Integer > map2 = new HashMap<>();

        String[] s1tr = s1.split(" ");
        String[] s2tr = s2.split(" ");


        for (String s : s1tr) {
            if (map1.containsKey(s)) {

                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }

        }

        for (String s : s2tr) {
            if (map2.containsKey(s)) {

                map2.put(s, map2.get(s) + 1);
            } else {
                map2.put(s, 1);
            }

        }
        List< String > res = new ArrayList<>();

        for (Map.Entry< String, Integer > m : map1.entrySet()) {
            if (m.getValue() == 1) {
                if (!map2.containsKey(m.getKey())) {
                    res.add(m.getKey());
                }
            }
        }

        for (Map.Entry< String, Integer > m : map2.entrySet()) {
            if (m.getValue() == 1) {
                if (!map1.containsKey(m.getKey())) {
                    res.add(m.getKey());
                }
            }
        }


        int size = res.size();

        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    public String largestOddNumber ( String num ) {

        while (num.length() != 0) {

            if (Integer.parseInt(String.valueOf(num.charAt(num.length() - 1))) % 2 != 0) {
                return num;
            } else {
                num = num.substring(0, num.length() - 1);
            }
        }
        return num;
    }

    public int countConsistentStrings ( String allowed, String[] words ) {
        List< String > list = new ArrayList<>();
        for (String s : words) {
            String str[] = allowed.split("");
            for (String s1 : str) {
                s = s.replaceAll(s1, "");
            }
            list.add(s);
        }

        int count = 0;

        for (String s : list) {
            if (s.equals("")) {
                count += 1;
            }
        }


        return count;

    }

    public int[] relativeSortArray ( int[] arr1, int[] arr2 ) {

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List< Integer > l = new ArrayList<>();
        List< Integer > not = new ArrayList<>();
        for (int i : arr2) {
            if (map.containsKey(i)) {
                int j = map.get(i);
                for (int k = 0; k < j; k++) {
                    l.add(i);
                }
            }
        }
        List< Integer > arr2List = new ArrayList<>();
        for (int i : arr2) {
            arr2List.add(i);
        }
        System.out.println(map.keySet());
        System.out.println(map.keySet().contains(7));
        for (int i : arr1) {
            System.out.println(i);
            if (!arr2List.contains(i)) {
                not.add(i);
            }
        }
        Collections.sort(not);

        l.addAll(not);
        int finalSize = l.size();
        int[] res = new int[finalSize];

        for (int i = 0; i < finalSize; i++) {
            res[i] = l.get(i);
        }
        return res;
    }

    public int findNumbers ( int[] nums ) {

        int count = 0;

        for (int i : nums) {
            if (String.valueOf(i).length() % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public int diagonalSum(int[][] mat) {

        int size = mat.length;
        int count = 0;
        for(int i = 0; i < size; i++){

        }

    }
}
