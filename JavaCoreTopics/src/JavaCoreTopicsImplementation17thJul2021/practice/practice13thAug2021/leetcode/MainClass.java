package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.leetcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author sidharthdas on 14/08/21.
 */

class RandomizedSet {

    Set< Integer > list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet () {
        list = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert ( int val ) {
        return list.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove ( int val ) {
       return  list.remove(Integer.valueOf(val));
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom () {
        int size = list.size();
        int randomNum = ThreadLocalRandom.current().nextInt(0, size-1);
        return list.stream().collect(Collectors.toList()).get(randomNum);


    }
}

class TimeMap {

    /**
     * Initialize your data structure here.
     */
    Map< Integer, Map< String, String > > map;

    public TimeMap () {

        map = new LinkedHashMap<>();

    }

    public void set ( String key, String value, int timestamp ) {
        if (map.containsKey(timestamp)) {
            map.get(timestamp).put(key, value);
        } else {
            Map< String, String > m = new HashMap<>();
            m.put(key, value);
            map.put(timestamp, m);
        }

    }

    public String get ( String key, int timestamp ) {

        if (map.containsKey(timestamp)) {
            return map.get(timestamp).get(key);
        } else {
            return null;
        }

    }
}

class MapSum {

    /**
     * Initialize your data structure here.
     */
    Map< String, Integer > map;

    public MapSum () {
        map = new HashMap<>();
    }

    public void insert ( String key, int val ) {
        map.put(key, val);
    }

    public int sum ( String prefix ) {
        int sum = 0;
        int len = prefix.length();
        for (Map.Entry< String, Integer > m : map.entrySet()) {
            if (m.getKey().length() >= len) {
                if ((m.getKey().substring(0, len)).equals(prefix)) {
                    sum += m.getValue();
                }
            }
        }

        return sum;

    }
}


class MedianFinder {

    /**
     * initialize your data structure here.
     */
    List< Integer > list;

    public MedianFinder () {
        list = new ArrayList<>();
    }

    public void addNum ( int num ) {
        list.add(num);
    }

    public double findMedian () {

        if (list.size() == 1) {
            return Double.valueOf(list.get(0));
        } else if (list.size() == 2) {
            return (Double.valueOf(list.get(0)) + Double.valueOf(list.get(1))) / Double.valueOf(2);
        } else if (list.size() == 3) {
            return Double.valueOf(list.get(1));
        }
        if (list.size() % 2 != 0) {
            return Double.valueOf(list.get((list.size() / 2)));
        } else {
            int i = list.get(list.size() / 2);
            int j = list.get((list.size() / 2) - 1);
            double value = (Double.valueOf(i) + Double.valueOf(j)) / Double.valueOf(2);
            return value;
        }
    }
}

class ProductOfNumbers {

    List< Integer > list;

    public ProductOfNumbers () {
        list = new ArrayList<>();
    }

    public void add ( int num ) {
        list.add(num);

    }

    public int getProduct ( int k ) {
        int finalVal = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (k != 0) {
                finalVal *= list.get(i);
                if (finalVal == 0) {
                    return 0;
                }
                k--;
            } else {
                break;
            }
        }
        return finalVal;
    }
}

class WordDictionary {

    /**
     * Initialize your data structure here.
     */
    List< String > list;

    public WordDictionary () {
        list = new ArrayList<>();
    }

    public void addWord ( String word ) {
        list.add(word);

    }

    public boolean search ( String word ) {

        if (word.contains(".")) {

        }

        return list.contains(word);

    }
}


interface MountainArray {
    public int get ( int index );

    public int length ();
}

public class MainClass {


    public static void main ( String[] args ) {
        //["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        //[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        System.out.println(randomNum);
    }


    public int countGoodTriplets ( int[] arr, int a, int b, int c ) {
        int size = arr.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int[] twoSum ( int[] numbers, int target ) {

        int size = numbers.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    System.out.println(numbers[i]);
                    System.out.println(numbers[j]);
                    System.out.println("-----------------");
                    if (numbers[i] + numbers[j] == target) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
        }

        return null;
    }

    public int distanceBetweenBusStops ( int[] distance, int start, int destination ) {

        int dist = 0;

        dist = (dist + 1) % distance.length;

        int clockWise = 0;
        int antiClockWise = 0;

        while (true) {

        }


    }

    public List< String > commonChars ( String[] words ) {

        String s = words[0];
        String[] arr = s.split("");

        int len = arr.length;

        List< String > result = new ArrayList<>();
        int count = 0;
        int size = words.length;
        while (len != 0) {
            for (int i = 0; i < size; i++) {
                //  if(words[i].indexOf())

            }
        }

        return null;
    }

    public void spiral ( int[][] a ) {
        List< List< Integer > > list = new ArrayList<>();

        for (int[] arr : a) {
            List< Integer > l = new ArrayList<>();
            for (int i : arr) {
                l.add(i);
            }
            list.add(l);
        }


        int size = list.size();
        String s = "";
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {

            } else {
                Collections.reverse(list.get(i));

            }
        }

    }

    public List< List< Integer > > fourSum ( int[] nums, int target ) {

        List< List< Integer > > RESULT = new ArrayList<>();
        int size = nums.length;
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                for (int c = 0; c < size; c++) {
                    for (int d = 0; d < size; d++) {
                        if (a != b && b != c && c != d && d != a) {
                            if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                                List< Integer > l1 = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                                RESULT.add(l1);

                            }
                        }
                    }
                }
            }
        }
        return RESULT;
    }

    public int peakIndexInMountainArray ( int[] arr ) {
        List< Integer > l = new ArrayList<>();
        for (int i : arr) {
            l.add(i);
        }

        Collections.sort(l);

        int size = l.size();

        int greatest = l.get(size - 1);

        for (int i = 0; i < size; i++) {
            if (arr[i] == greatest) {
                return i;
            }
        }

        return -1;
    }

    public int findInMountainArray ( int target, MountainArray mountainArr ) {

        int size = mountainArr.length();

        int midVal = mountainArr.get(size / 2);
        if (target < midVal) {
            for (int i = 0; i < size / 2; i++) {
                if (mountainArr.get(i) == target) {
                    return i;
                }
            }
        } else {


            for (int i = size / 2; i < size; i++) {
                if (mountainArr.get(i) == target) {
                    return i;
                }
            }
        }
        return -1;

    }

    public String removeDuplicates ( String s ) {
        String[] arr = s.split("");
        List< String > l = new CopyOnWriteArrayList<>();

        for (String srr : arr) {
            l.add(srr);
        }

        int size = l.size();
        for (int i = 0; i < l.size(); i++) {
            if (i + 1 < size) {
                if (l.get(i) == l.get(i + 1)) {
                    l.remove(l.get(i));
                    l.remove(l.remove(i));
                }
            }
        }
        String res = "";

        for (String s1 : l) {
            res += s1;
        }

        return res;
    }

    public int daysBetweenDates ( String date1, String date2 ) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate DATE1 = LocalDate.parse(date1, formatter);
        LocalDate DATE2 = LocalDate.parse(date2, formatter);

        long daysBetween = DAYS.between(DATE2, DATE1);

        return (int) daysBetween;


    }

    public boolean validPalindrome ( String s ) {
        String[] srr = s.split("");

        int size = srr.length;
        Map< String, Integer > map = new HashMap<>();

        for (String s1 : srr) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }

        map = map.entrySet().stream().filter(x -> x.getValue() == 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (size % 2 == 0) {
            if (map.size() == 2 || map.size() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (map.size() == 1 || map.size() == 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean isLongPressedName ( String name, String typed ) {
        Map< String, Integer > map1 = new LinkedHashMap<>();
        Map< String, Integer > map2 = new LinkedHashMap<>();
        String nameArr[] = name.split("");
        String typedArr[] = typed.split("");

        String s1 = "";
        String s2 = "";


        for (String s : nameArr) {
            if (map1.containsKey(s)) {
                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }


        }

        for (String s : typedArr) {
            if (map2.containsKey(s)) {
                map2.put(s, map2.get(s) + 1);
            } else {
                map2.put(s, 1);
            }
        }
        for (Map.Entry< String, Integer > m : map1.entrySet()) {
            s1 += m.getKey();
        }

        for (Map.Entry< String, Integer > m : map2.entrySet()) {
            s2 += m.getKey();
        }


        if (!s1.equals(s2)) {
            return false;
        }

        System.out.println(s1);
        System.out.println(s2);


        for (Map.Entry< String, Integer > m : map1.entrySet()) {
            if (!map2.containsKey(m.getKey())) {
                return false;
            }
            if (m.getValue() < map2.get(m.getKey())) {
                return false;
            }
        }

        return true;

    }


    public String reorderSpaces ( String text ) {
        String[] textArr = text.split("");
        int count = 0;
        for (String s : textArr) {
            if (s.equals(" ")) {
                count++;
            }
        }

        String noSpaceStr = text.replaceAll("\\s", " ");
        String sArr[] = noSpaceStr.split(" ");
        int len = sArr.length;

        String result = "";

        int each = count % len - 1;
        if (each == 0) {
            for (String s : sArr) {
                result += s + "   ";
            }
        }

        return result;
    }


    public int numberOfSubstrings ( String s ) {
        char[] str = s.toCharArray();
        int n = str.length;

        String[] srr = s.split("");
        Set< String > set = new TreeSet<>();

        for (String s3 : srr) {
            set.add(s3);
        }

        String absolut = "";
        for (String s4 : set) {
            absolut += s4;
        }
        List< String > l = new ArrayList<>();
        for (int len = 1; len <= n; len++) {
            // Pick ending point
            String s1 = "";
            for (int i = 0; i <= n - len; i++) {
                //  Print characters from current
                // starting point to current ending
                // point.
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    System.out.print(str[k]);
                    s1 += str[k];
                }
                char[] c = s1.toCharArray();
                Arrays.sort(c);

                l.add(String.valueOf(c));
            }
        }
        String[] spli = absolut.split("");
        l = l.stream().filter(x -> x.length() >= spli.length).collect(Collectors.toList());
        int count = 0;
        for (String s5 : l) {
            for (int i = 0; i < spli.length; i++) {
                if (!s5.contains(spli[i])) {
                    break;
                }
                if (s5.contains(spli[i]) && i == spli.length - 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public char nextGreatestLetter ( char[] letters, char target ) {
        Set< Character > set = new TreeSet<>();
        for (char c : letters) {
            set.add(c);
        }
        for (char c : set) {
            System.out.println(c);
            if ((target + "").compareTo(String.valueOf(c)) < 0) {
                return c;
            }
        }

        List< Character > l = new ArrayList<>();
        for (char c : set) {
            l.add(c);
        }

        return l.get(0);
    }

    public int dominantIndex ( int[] nums ) {
        List< Integer > l = new ArrayList<>();

        for (int i : nums) {
            l.add(i);
        }

        Collections.sort(l);
        int size = l.size();
        int num = 0;

        System.out.println(l);
        for (int i = size - 1; i >= 0; i--) {

            if (l.get(i) % 2 == 0) {

                int temp = l.get(i) / 2;
                System.out.println(temp);
                System.out.println(l.contains(temp));
                if (l.contains(temp)) {
                    num = 3;
                }
            }
        }

        System.out.println(l.indexOf(num));
        int lq = nums.length;
        for (int i = 0; i < lq; i++) {
            if (nums[i] == num) {
                return i;
            }

        }

        return -1;
    }


}
