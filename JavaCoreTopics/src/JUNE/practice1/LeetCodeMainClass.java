package JUNE.practice1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 09/07/21.
 */
public class LeetCodeMainClass {

    public static void main ( String[] args ) {

       /* LeetCodeMainClass leetCodeMainClass = new LeetCodeMainClass();

        leetCodeMainClass.largestNumber(new int[]{3, 30, 34, 5, 9});

        int[] a1 = {1, 2, 2, 1};
        int[] a2 = {2, 2};
        leetCodeMainClass.intersection(a1, a2);*/

        String s = "abcde";
        String goal = "cdeab";

        System.out.println("book".substring(0, "book".length() / 2));
        System.out.println("book".substring("book".length() / 2, "book".length()));

        LeetCodeMainClass leetCodeMainClass = new LeetCodeMainClass();
        //leetCodeMainClass.rotateString(s, goal);
        //System.out.println(leetCodeMainClass.shiftingLetters("abc", new int[]{3,5,9}));


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
                    if (words[i].contains(words[j])) {
                        list.add(words[j]);
                    }
                }
            }
        }

        list = list.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());

        return list;


    }

    public String reverseOnlyLetters ( String s ) {
        String[] newS1 = s.split("-");
        System.out.println(newS1);
        String newS2 = "";
        for (String s3 : newS1) {
            newS2 += s3;
        }
        String[] newSrr = newS2.split("");
        int size = newSrr.length;
        String sRev = "";
        for (int i = size - 1; i >= 0; i--) {
            sRev += newSrr[i];
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                String newSS = sRev.substring(0, i) + "-";
                sRev = newSS + sRev.substring(1);
                System.out.println(sRev);
            }
        }
        System.out.println(sRev);
        return sRev;
    }

    public boolean rotateString ( String s, String goal ) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return false;
        }

        int size = s.length() / 2;
        int start = 0;
        int end = s.length() - 1;
        boolean flag = false;
        String res = s;
        for (int i = 0; i < end; i++) {
            char c = res.charAt(0);
            res += c;
            res = res.substring(1, res.length());
            System.out.println(res);
            if (res.equals(goal)) {
                flag = true;
                break;
            }
        }

        return flag;
    }


    public String replaceDigits ( String s ) {
        List< String > alpha = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        String res = "";
        String[] sre = s.split("");

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                res += s.charAt(i) + "";
                System.out.println(res);
            } else {

                int pos = alpha.indexOf(s.charAt(i - 1) + "");
                System.out.println(pos);
                int z = (int) s.charAt(i);
                System.out.println(Integer.parseInt(sre[i]) + pos);
                System.out.println(z);
                System.out.println(pos + z);
                res += alpha.get(Integer.parseInt(sre[i]) + pos);
                System.out.println(res);
            }
        }

        return res;
    }

    public String shiftingLetters ( String s, int[] shifts ) {

        String res = s;

        List< String > alpha = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        String[] str = s.split("");

        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = 0; j <= i; j++) {
                String[] resStr = res.split("");
                System.out.println(alpha.indexOf(resStr[j]));
                int k = alpha.indexOf(resStr[j]) + shifts[i];
                resStr[j] = alpha.get(k);
                StringBuffer sb = new StringBuffer();
                for (int p = 0; p < resStr.length; p++) {
                    sb.append(resStr[p]);
                }

                res = sb.toString();
            }
        }
        System.out.println(res);
        return res;

    }


    public boolean halvesAreAlike ( String s ) {


        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2, s.length());
        int count1 = count(s1);
        int count2 = count(s2);


        return (count1 == count2);

    }

    private int count ( String s ) {
        List< String > vowels = Arrays.asList("a", "e", "i", "o", "u");
        String[] str = s.split("");
        int count = 0;
        for (String s1 : str) {
            if (vowels.contains(s1)) {
                count++;
            }
        }
        return count;
    }

    public char slowestKey ( int[] releaseTimes, String keysPressed ) {

        String[] str = keysPressed.split("");
        Map< String, List<Integer> > map = new HashMap<>();
        int size = str.length;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(releaseTimes[i]);
                map.put(str[i], list1);

            } else {
                if(map.containsKey(str[i])){
                    List<Integer> list1 = map.get(str[i]);
                    list1.add(releaseTimes[i] - releaseTimes[i - 1]);
                    map.put(str[i], list1);
                }else{
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(releaseTimes[i] - releaseTimes[i - 1]);
                    map.put(str[i], list1);

                }

            }

        }

        Map<String, Integer> map1 = new HashMap<>();
        for(Map.Entry<String, List<Integer>> m : map.entrySet()){
            Collections.sort(m.getValue());
            map1.put(m.getKey(), m.getValue().get(m.getValue().size()-1));

        }

        final Map< String, Integer > sortedByCount = map1.entrySet()
                .stream()
                .sorted((Map.Entry.< String, Integer >comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

        int largestValue = 0;


        List<String> list  = new ArrayList<>();
        int count = 0;
        for(Map.Entry<String, Integer> m : sortedByCount.entrySet()){
            if(count == 0){
                largestValue = m.getValue();
                count +=1;
                list.add(m.getKey());
            }else{
                if(m.getValue() == largestValue){
                    list.add(m.getKey());
                }
            }
        }
          Comparator<String> comparator = (String o1, String o2)->{
            if(o1.compareTo(o2) >0){
                return -1;
            }else if(o1.compareTo(o2) < 0){
                return 1;
            }else{
                return 0;
            }
          };

        Collections.sort(list, comparator);

        return list.get(0).charAt(0);
        }

    public int countNegatives(int[][] grid) {
        int count = 0;

        for(int[] i : grid){
            for(int j : i){
                if(j <0){
                    count++;
                }
            }
        }
return count;
    }
    }
