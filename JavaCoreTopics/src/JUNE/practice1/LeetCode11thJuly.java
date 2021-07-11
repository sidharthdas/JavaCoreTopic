package JUNE.practice1;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 11/07/21.
 */
public class LeetCode11thJuly {

    public static void main ( String[] args ) {

        int[] a = {37, 12, 28, 9, 100, 56, 80, 5, 12};

        //System.out.println(-2147483648 - 2147483647);

        LeetCode11thJuly leetCode11thJuly = new LeetCode11thJuly();
        System.out.println(leetCode11thJuly.arrayRankTransform(a));

    }

    public List< List< Integer > > threeSum ( int[] nums ) {
        List< List< Integer > > list = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {

                    if ((i != j && i != k && j != k) && (nums[i] + nums[j] + nums[k] == 0)) {
                        List< Integer > li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);

                        list.add(li);
                    }

                }
            }
        }

        Set< List< Integer > > set = new HashSet<>(list);

        return set.stream().collect(Collectors.toList());

    }

    public boolean containsDuplicate ( int[] nums ) {


        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        boolean flag = false;
        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() >= 2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean containsNearbyAlmostDuplicate ( int[] nums, int k, int t ) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i != j) {
                    BigInteger abs = new BigInteger(String.valueOf(nums[i])).subtract(new BigInteger(String.valueOf(nums[j])));
                    //BigInteger bk
                    if (abs.compareTo(new BigInteger(String.valueOf(0))) < 0) {
                        abs = abs.multiply(new BigInteger(String.valueOf(-1)));
                    }
                    if (new BigInteger(String.valueOf(t)).compareTo(abs) >= 0) {

                        int ind = i - j;

                        if (ind < 0) {
                            ind = ind * (-1);

                            if (k >= ind) {
                                return true;
                            }
                        }
                    }
                }

            }
        }

        return false;

    }

    public int missingNumber ( int[] nums ) {
        int n = nums.length - 1;

        int sumShouldBe = (n * (n + 1)) / 2;

        int totalSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= n - 1; i++) {
            totalSum += nums[i];
        }

        return sumShouldBe - totalSum;
    }


    public char findTheDifference ( String s, String t ) {

        String[] srr = s.split("");
        String[] trr = t.split("");

        Map< String, Integer > map1 = new HashMap<>();
        for (String i : srr) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }
        Map< String, Integer > map2 = new HashMap<>();
        for (String i : trr) {
            if (map2.containsKey(i)) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }

        for (Map.Entry< String, Integer > m : map2.entrySet()) {
            if (!map1.containsKey(m.getKey())) {
                return m.getKey().charAt(0);
            } else {
                System.out.println(m.getValue());
                System.out.println(map1.get(m.getKey()));
                if (m.getValue() != map1.get(m.getKey())) {
                    return m.getKey().charAt(0);
                }
            }
        }

        return '\u0000';
    }

    public int[] intersect ( int[] nums1, int[] nums2 ) {

        List< Integer > list = new ArrayList<>();

        Map< Integer, Integer > map1 = new HashMap<>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }
        Map< Integer, Integer > map2 = new HashMap<>();
        for (int i : nums2) {
            if (map2.containsKey(i)) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }

        for (Map.Entry< Integer, Integer > m : map1.entrySet()) {
            if (map2.containsKey(m.getKey())) {
                if (m.getValue() >= map2.get(m.getKey()) || m.getValue() <= map2.get(m.getKey())) {
                    int smallestValue = m.getValue() >= map2.get(m.getKey()) ? map2.get(m.getKey()) : m.getValue();
                    for (int i = 0; i < smallestValue - 1; i++) {
                        list.add(m.getKey());
                    }
                    list.add(m.getKey());
                }
            }


        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] arrayRankTransform ( int[] arr ) {
        if (arr.length == 0) {
            return new int[]{0};
        }
        int size = arr.length;
        int[] res = new int[size];


        List< Integer > list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        Collections.sort(list);

        List< Integer > indexes = new ArrayList<>();

        int count = 1;
        int inde = 0;
        int prevValue = list.get(0);
        for (int i : list) {

            if (inde == 0) {
                indexes.add(count);
                inde = 1;
            } else {
                if (i == prevValue) {
                    indexes.add(count);
                } else {
                    count += 1;
                    indexes.add(count);
                }
            }
            prevValue = i;
        }
        int start = 0;
        for (int i : arr) {
            int index = list.indexOf(i);
            int x = indexes.get(index);
            res[start] = x;
            start += 1;

        }


        return res;
    }

    public boolean hasGroupsSizeX ( int[] deck ) {

        if (deck.length == 1) {
            return true;
        }
        Map< Integer, Integer > map = new HashMap<>();
        for (int i : deck) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);

            } else {
                map.put(i, 1);
            }

        }
        int value = map.get(deck[0]);
        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() != value) {
                return false;
            }
        }
        return true;
    }

    public List< String > topKFrequent ( String[] words, int k ) {
        int size = words.length;
        Map< String, Integer > map = new HashMap<>();
        for (String s : words) {
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else{
                map.put(s, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Integer> m : map.entrySet()){
            list.add(m.getValue());
        }

        Collections.sort(list);
        int sizeofList = list.size();
        List<Integer> valuesAperK = new ArrayList<>();
        int s = k;
        for(int i = sizeofList -1; i >=0; i--){

            if(s != 0){
                valuesAperK.add(list.get(i));
                s -=1;
            }

        }
        valuesAperK = valuesAperK.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        List<String> mainList = new ArrayList<>();

        for(int i : valuesAperK){
            for(Map.Entry<String, Integer> m : map.entrySet()){
                if(m.getValue() == i){
                    mainList.add(m.getKey());
                }
            }
        }
        Collections.sort(mainList);
        return mainList;
    }

    public String frequencySort(String s) {

    }
}
