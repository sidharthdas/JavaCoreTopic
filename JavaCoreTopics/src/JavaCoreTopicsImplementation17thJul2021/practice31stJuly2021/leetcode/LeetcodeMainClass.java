package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.leetcode;

import java.math.BigInteger;
import java.util.*;
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

        int[] temp = {55,38,53,81,61,93,97,32,43,78};
        LeetcodeMainClass l = new LeetcodeMainClass();
        int[] ans = l.dailyTemperatures(temp);


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

    public int fib(int n) {
        int count = 2;
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }

        int first = 0;
        int second = 1;

        int index = 2;

        while(n != index){
            int n1 = first + second;
            first = second;
            second = n1;
        }

        return second;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        int index = 0;
        int count = 0;
        int size = temperatures.length;
        for(int i = 0; i < size; i++){
            System.out.println("current value : "+temperatures[i]);
            for(int j = i+1; j < size; j++){

                if(temperatures[i]< temperatures[j]){
                    count+=1;
                    System.out.println(count);
                    answers[index] = count;
                    index+=1;
                    count = 0;
                    break;
                }else if((temperatures[i] >= temperatures[j]) && j != size-1){
                    count+=1;
                    System.out.println(count);


                }else if((temperatures[i] >= temperatures[j]) && j == size-1){
                    count = 0;
                    answers[index] = count;
                    index+=1;
                    break;
                }
            }

        }
        return answers;
    }
}
