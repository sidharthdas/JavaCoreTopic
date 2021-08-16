package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.leetcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author sidharthdas on 14/08/21.
 */


interface MountainArray {
    public int get ( int index );

    public int length ();
}

public class MainClass {


    public static void main ( String[] args ) {

        new MainClass().validPalindrome("abca");


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
        for(Map.Entry<String, Integer> m : map1.entrySet()){
            s1+=m.getKey();
        }

        for(Map.Entry<String, Integer> m : map2.entrySet()){
            s2+=m.getKey();
        }


        if(!s1.equals(s2)){
            return false;
        }

        System.out.println(s1);
        System.out.println(s2);


        for(Map.Entry<String, Integer> m : map1.entrySet()){
            if(!map2.containsKey(m.getKey())){
                return false;
            }
            if(m.getValue() < map2.get(m.getKey())){
                return false;
            }
        }

        return true;

    }

}
