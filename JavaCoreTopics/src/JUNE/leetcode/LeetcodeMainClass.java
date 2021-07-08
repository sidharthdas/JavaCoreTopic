package JUNE.leetcode;

import java.math.BigInteger;
import java.util.*;

/**
 * @author sidharthdas on 08/07/21.
 */
public class LeetcodeMainClass {

    public static void main ( String[] args ) {

    /*    //[2,3,4]

        int[] num = {-1, 0};

        LeetcodeMainClass leetcodeMainClass = new LeetcodeMainClass();

        int[] res = leetcodeMainClass.twoSum(num, -1);

        if (res != null) {
            for (int i : res) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(res);
        }


        leetcodeMainClass.isPalindrome("A man, a plan, a canal: Panama");
        leetcodeMainClass.longestPalindrome("abccccdd");*/
        LeetcodeMainClass leetcodeMainClass = new LeetcodeMainClass();
        int[] bb = {8, 1, 2, 2, 3};
        // leetcodeMainClass.smallerNumbersThanCurrent(bb);

        String address = "1.1.1.1";

        System.out.println(leetcodeMainClass.dayOfYear("2019-02-10"));

    }


    public int[] twoSum ( int[] numbers, int target ) {
        int[] sum = new int[2];
        List< Integer > list1 = new ArrayList<>();
        List< Integer > list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (numbers[i] <= target) {
                int newVa = target - numbers[i];

                if (list.contains(newVa)) {
                    if (i != list.indexOf(newVa)) {
                        sum[0] = i + 1;
                        sum[1] = list.indexOf(newVa) + 1;

                        return sum;
                    } else {
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j) == newVa) {
                                list1.add(j + 1);
                            }
                        }
                    }
                    if (list1.size() == 2) {
                        int[] num1 = {list1.get(0), list1.get(1)};
                        return num1;
                    }
                }
            }
        }
        return null;

    }

    public boolean isPalindrome ( String s ) {

        String str = s.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
        String reverseString = "";
        System.out.println();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseString += str.charAt(i);
            System.out.println(reverseString);
        }

        //String[] strArr = str.split("");

        System.out.println(str);
        System.out.println(reverseString);


        return reverseString.equals(str) ? true : false;
    }


    public int longestPalindrome ( String s ) {
        String st1 = s.charAt(0) + "";
        String st2[] = s.split("");

        boolean flag = true;
        for (String sttt : st2) {
            if (!sttt.equals(st1)) {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            return st2.length;
        }

        Map< String, Integer > map = new HashMap<>();
        String[] sArr = s.split("");

        for (String i : sArr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int count = 0;
        int total = 0;

        for (Map.Entry< String, Integer > m1 : map.entrySet()) {
            if (m1.getValue() == 1) {
                if (count == 0) {
                    count += 1;
                    total += 1;
                }
            }
        }

        for (Map.Entry< String, Integer > m : map.entrySet()) {
            if (m.getValue() > 1 && m.getValue() % 2 != 0) {
                if (count == 0) {
                    total += m.getValue();
                } else {
                    total += (m.getValue() - 1);
                }
            } else if (m.getValue() > 1 && m.getValue() % 2 == 0) {
                total += m.getValue();
            }
        }
        return total;
    }


    public int searchInsert ( int[] nums, int target ) {
        int prevIndex = -1;
        int realIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                realIndex = i;
                break;
            } else if (nums[i] < target) {
                prevIndex = i;
            }

        }

        return realIndex != -1 ? realIndex : prevIndex + 1;
    }

    public int[] smallerNumbersThanCurrent ( int[] nums ) {

        int[] result = new int[nums.length];
        int count = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count += 1;
                }
            }
            result[index] = count;
            index += 1;
            count = 0;
        }

        for (int i : result) {
            System.out.println(i);
        }

        return result;

    }

    public String defangIPaddr ( String address ) {

        //address = address.replaceAll(".", "[.]");
        address = address.replace(".", "[.]");
        return address;

    }

    public boolean arrayStringsAreEqual ( String[] word1, String[] word2 ) {
        String s1 = "";
        String s2 = "";


        for (String s : word1) {
            s1 += s;
        }

        for (String s : word2) {
            s2 += s;
        }

        return s1.equals(s1);
    }

    public int lengthOfLastWord ( String s ) {
        String[] str = s.split(" ");
        if (str.length == 0) {
            return 0;
        }
        int size = str.length;

        return str[size - 1].length();
    }


    public String addStrings ( String num1, String num2 ) {

        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);

        return String.valueOf(b1.add(b2));
    }

    public int secondHighest ( String s ) {

        String str = s.replaceAll("[^0-9]", "");

        System.out.println(str);


        String[] st = str.split("");
        Set< String > set = new HashSet<>();
        for (String s23 : st) {
            set.add(s23);
        }

        if (set.size() == 1) {
            return -1;
        }

        String[] stArr = new String[set.size()];
        int count = 0;
        for (String s45 : set) {
            stArr[count] = s45;
            count++;

        }
        int largest = 0;
        int secondLargest = 0;
        /*if (st[0].length() != 0) {
            largest = Integer.valueOf(st[0]);
            secondLargest = Integer.valueOf(st[0]);
        }*/
        for (int i = 0; i < stArr.length; i++) {
            if (stArr[i].length() != 0) {

                if (i == 0) {
                    largest = Integer.valueOf(stArr[i]);
                    secondLargest = Integer.valueOf(stArr[i + 1]);

                }
                if (Integer.valueOf(stArr[i]) > largest) {
                    secondLargest = largest;
                    largest = Integer.valueOf(stArr[i]);
                } else if (Integer.valueOf(stArr[i]) < largest && Integer.valueOf(stArr[i]) > secondLargest) {
                    secondLargest = Integer.valueOf(stArr[i]);
                }
            }
        }

        return secondLargest == largest ? -1 : secondLargest;
    }


    public boolean isAnagram ( String s, String t ) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return String.valueOf(c1).equals(String.valueOf(c2));

    }


    public int dayOfYear ( String date ) {
        int i = 0;

        int totalDays = 0;

        Map< Integer, Integer > map = new HashMap<>();
        map.put(1, 31);
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);



        String[] dateArr = date.split("-");

        boolean checkLeap = checkLeapYear(Integer.parseInt(dateArr[0]));
        int month = Integer.parseInt(dateArr[1]) -1;

        if(month == 0){
            return Integer.parseInt(dateArr[2]);
        }

        totalDays = 0;

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getKey() <= month){
                totalDays += m.getValue();
            }
        }

        if(checkLeap && Integer.parseInt(dateArr[1] ) > 2){
            totalDays += 1;
        }

        return (totalDays +Integer.parseInt(dateArr[2]));


    }


    private boolean checkLeapYear ( int year ) {
        boolean flag = false;
        if (year % 400 == 0) {
            flag = true;
        } else if (year % 100 == 0) {
            flag = false;
        } else if (year % 4 == 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;

    }



    public String reverseWords(String s) {
        String[] str = s.split(" ");
        String[] strArr = new String[str.length];

        for(int i = 0; i < str.length; i++){
            String rev = reverseAString(str[i]);
            strArr[i] = rev;
        }
        String res = "";
        for(int i = 0; i < strArr.length; i++){
            if(i == 0){
                res +=strArr[i];
            }else{
                res = res + " " + strArr[i];
            }
        }


        return res;
    }

    private String reverseAString ( String s ) {

        String s1 = "";
        String[] str = s.split("");

        for(int i = str.length-1; i>=0; i--) {
            s1 += str[i];
        }

        return s1;
    }

}
