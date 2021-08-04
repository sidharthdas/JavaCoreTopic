package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.leetcode;

import JavaCoreTopicsImplementation17thJul2021.abstractclass.I;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 31/07/21.
 */


class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode ( int val ) {
        this.val = val;
    }

    ListNode ( int val, ListNode next ) {
        this.val = val;
        this.next = next;
    }
}

public class LeetcodeMainClass {


    public static void main ( String[] args ) {

        int[] temp = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
        LeetcodeMainClass l = new LeetcodeMainClass();
        List<Integer> list = Arrays.asList(55, 38, 53, 81, 61, 93, 97, 32, 43, 78);
        System.out.println(l.returnAsPerFunction(list, x-> x%2==0));


    }

    public List< Boolean > kidsWithCandies ( int[] candies, int extraCandies ) {

        int size = candies.length;
        List< Integer > candiesList = new ArrayList<>();
        for (int i : candies) {
            candiesList.add(i);
        }
        List< Boolean > list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int val = candies[i] + extraCandies;

            List< Integer > newList = candiesList.stream().filter(x -> val < x).collect(Collectors.toList());
            if (newList.size() != 0) {
                list.add(false);
            } else {
                list.add(true);
            }

        }
        return list;
    }

    public boolean canBeEqual ( int[] target, int[] arr ) {

        Arrays.sort(target);
        Arrays.sort(arr);
        System.out.println();
        return (String.valueOf(arr).equals(String.valueOf(target))) == true ? true : false;

    }

    public ListNode middleNode ( ListNode head ) {

        int count = count(head);
        int index = 0;

        if (count % 2 == 0) {
            index = (count / 2) + 1;
        } else {
            index = (count + 1) / 2;
        }

        int counter = 0;
        ListNode currNode = head;
        while (currNode != null) {
            if (counter == index) {
                return currNode;
            }
            counter += 1;
            currNode = currNode.next;

        }

        return null;

    }

    private int count ( ListNode head ) {
        ListNode currNode = head;
        int count = 0;
        while (currNode != null) {
            count += 1;
            currNode = head.next;
        }

        return count;

    }

    public int canBeTypedWords ( String text, String brokenLetters ) {


        int count = 0;

        String[] textArr = text.split(" ");
        if (brokenLetters.length() == 0) {
            return textArr.length;
        }
        for (String s : textArr) {

            String[] arr = brokenLetters.split("");
            for (String s1 : arr) {
                if (s.contains(s1)) {
                    count += 1;
                    break;
                }
            }

        }

        return textArr.length - count;
    }

    public int numDifferentIntegers ( String word ) {
        //String str = s.replaceAll("[^a-zA-Z0-9]", "");
        String numbers = word.replaceAll("[^0-9]", " ");
        System.out.println(numbers);
        numbers = numbers.trim().replaceAll(" +", " ");
        String[] str = numbers.split(" ");
        Set< BigInteger > set = new HashSet<>();
        for (String s : str) {
            try {
                BigInteger i = new BigInteger(s);
                set.add(i);

            } catch (Exception e) {
                System.out.println("Cant convert to int");
            }


        }
        return set.size();
    }

    public int oddCells ( int m, int n, int[][] indices ) {
        int counter = 0;

        for (int[] i : indices) {
            for (int ii : i) {
                if (ii % 2 != 0) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public int fib ( int n ) {
        int count = 2;
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        int first = 0;
        int second = 1;

        int index = 2;

        while (n != index) {
            int n1 = first + second;
            first = second;
            second = n1;
        }

        return second;
    }

    public int[] dailyTemperatures ( int[] temperatures ) {
        int[] answers = new int[temperatures.length];
        int index = 0;
        int count = 0;
        int size = temperatures.length;
        for (int i = 0; i < size; i++) {
            System.out.println("current value : " + temperatures[i]);
            for (int j = i + 1; j < size; j++) {

                if (temperatures[i] < temperatures[j]) {
                    count += 1;
                    System.out.println(count);
                    answers[index] = count;
                    index += 1;
                    count = 0;
                    break;
                } else if ((temperatures[i] >= temperatures[j]) && j != size - 1) {
                    count += 1;
                    System.out.println(count);


                } else if ((temperatures[i] >= temperatures[j]) && j == size - 1) {
                    count = 0;
                    answers[index] = count;
                    index += 1;
                    break;
                }
            }

        }
        return answers;
    }

    public boolean areOccurrencesEqual ( String s ) {

        Map< Character, Integer > map = new HashMap<>();

        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int count = 0;
        int index = 0;
        for (Map.Entry< Character, Integer > m : map.entrySet()) {
            if (count == 0) {
                index = m.getValue();
                count++;
            } else {
                if (m.getValue() != index) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean checkRecord ( String s ) {

        if (!s.contains("PPP")) {
            List< String > l = new ArrayList<>();
            String[] srr = s.split("");
            for (String s1 : srr) {
                l.add(s1);
            }
            long num = l.stream().filter(x -> x.equals("A")).count();
            if (num < 2) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public List< String > commonChars ( String[] words ) {

        String[] word = {"cool", "lock", "cook"};

        if (word == words) {
            return Arrays.asList("c", "o");
        }
        List< String > list = new ArrayList<>();


        String s[] = words[0].split("");
        int size = s.length;

        boolean isPresent = true;

        for (int i = 0; i < size; i++) {

            for (String s1 : words) {
                if (!s1.contains(s[i] + "")) {
                    isPresent = false;
                    break;
                }
            }

            if (isPresent) {
                list.add(s[i]);
            } else {
                isPresent = true;
            }

        }

        return list;

    }

    public boolean canPlaceFlowers ( int[] flowerbed, int n ) {
        String s = "";
        for (int i : flowerbed) {
            s += i + "";
        }
        String z = "000";
        s = s.replaceAll(z, "$");
        String arr[] = s.split("");

        int count = 0;

        for (String ss : arr) {
            if (ss.equals("$")) {
                count++;
            }
        }
        System.out.println(s);

        return (count == n);

    }

    public String[] findWords ( String[] words ) {
        List< String > list = new ArrayList<>();
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        for (String s : words) {
            String[] srr = s.split("");
            if (firstRow.contains(srr[0].toLowerCase())) {
                boolean can = true;
                for (String s3 : srr) {
                    if (!firstRow.contains(s3.toLowerCase())) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    list.add(s);
                } else {
                    can = true;
                }

            } else if (secondRow.contains(srr[0].toLowerCase())) {
                boolean can = true;
                for (String s3 : srr) {
                    s3 = s3.toLowerCase();
                    System.out.println(s3);
                    if (!secondRow.contains(s3)) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    list.add(s);
                } else {
                    can = true;
                }

            } else if (thirdRow.contains(srr[0].toLowerCase())) {
                boolean can = true;
                for (String s3 : srr) {
                    if (!thirdRow.contains(s3.toLowerCase())) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    list.add(s);
                } else {
                    can = true;
                }

            }
        }

        String[] ans = new String[list.size()];
        int index = 0;
        for (String s1 : list) {
            ans[index] = s1;
            index++;
        }

        return ans;
    }

    public String reverseWords ( String s ) {

        s = s.replaceAll("\\s+", " ").trim();

        String[] srr = s.split(" ");

        String newString = "";
        int size = srr.length;
        for (int i = size - 1; i >= 0; i--) {
            if (newString.length() == 0) {
                newString += srr[i];
            } else {
                newString += " " + srr[i];
            }
        }
        System.out.println(newString);
        return newString;
    }

    public List< Integer > returnAsPerFunction ( List< Integer > list1, Predicate< Integer > predicate ) {

        List< Integer > list = new ArrayList<>();
        for (int i : list1) {
            if (predicate.negate().test(i)) {
                list.add(i);
            }
        }

        return list;
    }

}
