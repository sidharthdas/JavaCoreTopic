package JUNE.practice1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 09/07/21.
 */
public class LeetCodeMainClass {

    public static void main ( String[] args ) {

        LeetCodeMainClass leetCodeMainClass = new LeetCodeMainClass();

        leetCodeMainClass.largestNumber(new int[]{3, 30, 34, 5, 9});

        int[] a1 = {1, 2, 2, 1};
        int[] a2 = {2, 2};
        leetCodeMainClass.intersection(a1, a2);

    }


    public String largestNumber ( int[] nums ) {
        StringBuilder sb = new StringBuilder();
        String[] c = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            c[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(c, ( a, b ) -> (b + a).compareTo(a + b));

        for (String s : c) {
            System.out.print(s);
        }
        return null;
    }


    public int[] intersection ( int[] nums1, int[] nums2 ) {

        List< Integer > list1 = new ArrayList<>();
        List< Integer > list2 = new ArrayList<>();
        List< Integer > list3 = new ArrayList<>();

        for (int i : nums1) {
            list1.add(i);
        }
        for (int i : nums2) {
            list2.add(i);
        }

        for (int i : nums1) {
            list3.add(i);
        }

        list1.addAll(list2);
        Set< Integer > set = new HashSet<>(list1);

        List< Integer > main = new ArrayList<>();

        System.out.println(list3);
        System.out.println(list2);

        for (int i : set) {
            if (list3.contains(i) && list2.contains(i)) {
                main.add(i);
            }
        }
        System.out.println(set);
        System.out.println(main);
        int size = main.size();
        int[] mainArr = new int[size];

        for (int i = 0; i < size; i++) {
            mainArr[i] = main.get(i);
        }
        return mainArr;
    }

    public int thirdMax ( int[] nums ) {

        int size = nums.length;

        if (size < 3) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        if (size == 1) {
            return nums[0];
        }

        List< Integer > list = new ArrayList<>();
        for (int i : nums) {
            if (!list.contains(i)) {
                list.add(i);
            }
        }

        Collections.sort(list);

        if (list.size() < 3) {
            return list.get(0);
        }

        return list.get(list.size() - 3);

    }

    public List< Integer > findDuplicates ( int[] nums ) {
        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List< Integer > list = new ArrayList<>();

        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() == 2) {
                list.add(m.getKey());
            }
        }

        return list;
    }

    public char nextGreatestLetter ( char[] letters, char target ) {
        int size = letters.length;
        for (int i = 0; i < size; i++) {
            if (String.valueOf(letters[i]).compareTo(String.valueOf(target)) > 1) {
                return letters[i];

            }
        }

        return '\u0000';
    }

    public int countMatches ( List< List< String > > items, String ruleKey, String ruleValue ) {
        int indexToBeSearched = -1;
        if (ruleKey.equals("type")) {
            indexToBeSearched = 0;
        } else if (ruleKey.equals("color")) {
            indexToBeSearched = 1;
        } else if (ruleKey.equals("namw")) {
            indexToBeSearched = 2;
        }

        int count = 0;

        for (List< String > l : items) {
            if (l.get(indexToBeSearched).equals(ruleValue)) {
                count += 1;
            }
        }

        return count;
    }

    public boolean checkIfPangram ( String sentence ) {
        String[] str = sentence.split("");

        Set< String > set = new HashSet<>();
        for (String s : str) {
            set.add(s);
        }

        return set.size() == 26 ? true : false;

    }


    public List< String > fizzBuzz ( int n ) {

        List< String > list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }

        }

        return list;

    }

    public List< String > stringMatching ( String[] words ) {

        List< String > list = new ArrayList<>();
        int size = words.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    if(words[i].contains(words[j])){
                        list.add(words[j]);
                    }
                }
            }
        }

        list = list.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());

        return list;


    }

    public String reverseOnlyLetters(String s) {


    }

}
