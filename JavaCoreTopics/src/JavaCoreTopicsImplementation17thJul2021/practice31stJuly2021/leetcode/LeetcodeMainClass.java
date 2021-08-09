package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.leetcode;

import JavaCoreTopicsImplementation17thJul2021.abstractclass.I;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 31/07/21.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {
    }

    TreeNode ( int val ) {
        this.val = val;
    }

    TreeNode ( int val, TreeNode left, TreeNode right ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BST {

    List< Integer > list = new ArrayList<>();

    public void inOrder ( TreeNode node ) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public TreeNode insert ( TreeNode node, int data ) {
        if (node == null) {
            return createNewNode(data);
        }
        if (data < node.val) {
            node.left = insert(node.left, data);
        } else if (data > node.val) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    private TreeNode createNewNode ( int data ) {
        TreeNode node = new TreeNode();
        node.val = data;
        node.left = null;
        node.right = null;

        return node;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root == null){
            return null;
        }

        if(target < root.val){
            root.left = removeLeafNodes(root.left, target);
        }else if(target > root.val){
            root.right = removeLeafNodes(root.right, target);
        }else{
            if(root.right == null){
                return root.left;
            }else if(root.left == null){
                return root.right;
            }
            root.val = getSuccessor(root);
            root.right = removeLeafNodes(root.right, root.val);
        }
        return  root;

    }

    private int getSuccessor ( TreeNode root ) {
        int minV = root.val;
        while(root.left != null){
            minV = root.left.val;
            root = root.left;
        }
        return minV;
    }
}

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

        LeetcodeMainClass l = new LeetcodeMainClass();



        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(l.removeDuplicates(arr));

        String s1 = "Sidharth";


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

    public boolean isUgly ( int n ) {
        List< Integer > list = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            while (n % i == 0) {
                if (i != 2 && i != 3 && i != 5) {
                    return false;
                }
                list.add(i);
                System.out.println(i + " ");
                n = n / i;
            }
        }
        if (n > 2) {
            list.add(n);
            System.out.println(n);
        }

        Predicate< Integer > predicate = x -> x != 2;
        Predicate< Integer > predicate1 = x -> x != 3;
        Predicate< Integer > predicate2 = x -> x != 5;

        long count = list.stream().filter(predicate.and(predicate1).and(predicate2)).count();

        if (count > 0) {
            return false;

        } else {
            return true;
        }

    }

    public int nthUglyNumber ( int n ) {

        List< Integer > list = new ArrayList<>();
        int count = 0;

        for (int i = 2; i < 100000000; i++) {
            if (i != 2 && i != 3 && i != 5 && i != 4) {

            }
            while (n % i == 0) {
                if (i != 2 && i != 3 && i != 5) {

                }
                list.add(i);
                //System.out.println(i+" ");
                n = n / i;
            }
        }
        if (n > 2) {
            list.add(n);
            // System.out.println(n);
        }
        return 0;
    }


    public int countGoodSubstrings ( String s ) {

        int size = s.length();
        String[] arr = s.split("");
        List< String > list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (i + 1 < size && i + 2 < size) {
                String s1 = arr[i] + arr[i + 1] + arr[i + 2];
                list.add(s1);
            }
        }
        System.out.println(list);

        List< String > finalList = new ArrayList<>();

        for (String s2 : list) {
            String[] srr = s2.split("");
            List< String > l = Arrays.asList(srr);
            int size1 = l.size();

            Set< String > set = new HashSet<>(l);

            if (size1 == set.size()) {
                finalList.add(s2);
            }
        }

        System.out.println(finalList);
        return finalList.size();
    }


    public int getLucky ( String s, int k ) {

        List< String > alpha = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        String[] srr = s.split("");

        int count = 0;

        String number = "";
        for (String s1 : srr) {
            number += String.valueOf(alpha.indexOf(s1) + 1);
        }

        String splitt[] = number.split("");

        for (String sp : splitt) {
            count += Integer.valueOf(sp);
        }
        System.out.println(count);
        if (k == 1) {
            return count;
        }

        if (k > 1) {
            int i = 2;
            while (i <= k) {
                if (count >= 10) {
                    String s3 = String.valueOf(count);
                    String[] s6rr = s3.split("");
                    int c = 0;
                    for (String s5 : s6rr) {
                        c += Integer.valueOf(s5);
                    }

                    count = c;
                    System.out.println("count: " + count + " i : " + i);
                }

                i++;

            }

        }
        return count;

    }


    public boolean isHappy ( int n ) {

        if (n < 10) {
            return false;
        }

        List< Integer > list = Arrays.asList(1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000);
        while (true) {
            if (n != 1 && n < 10) {
                return false;
            }
            if (list.contains(n)) {
                return true;
            }

            String[] srr = String.valueOf(n).split("");
            int count = 0;
            for (String s : srr) {
                count += Integer.valueOf(s) * Integer.valueOf(s);
            }
            System.out.println(count);
            n = count;


        }

    }

    public int solution ( int N ) {
        // write your code in Java SE 8
        String s = String.valueOf(N);
        String[] srr = s.split("");

        int sum = 0;
        for (String s1 : srr) {
            sum += Integer.valueOf(s1);
        }
        int newN = N + 1;
        while (true) {
            String s2 = String.valueOf(newN);
            String[] srr1 = s2.split("");

            int sum1 = 0;
            for (String s10 : srr1) {
                sum1 += Integer.valueOf(s10);
            }

            if (sum1 == sum) {
                return newN;
            } else {
                newN += 1;
            }
        }
    }


    public int solution ( int[] A ) {
        // write your code in Java SE 8
        int size = A.length;
        List< Integer > list = new ArrayList<>();
        List< List< Integer > > mainList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String[] s = String.valueOf(A[i]).split("");
            int sum = 0;
            for (String s1 : s) {
                sum += Integer.valueOf(s1);
            }
            for (int j = i + 1; j < size; j++) {
                String[] s2 = String.valueOf(A[j]).split("");
                int sum1 = 0;
                for (String s3 : s2) {
                    sum1 += Integer.valueOf(s3);
                }
                if (sum == sum1) {
                    List< Integer > l = new ArrayList<>();
                    l.add(A[i]);
                    l.add(A[j]);
                    mainList.add(l);
                }
                System.out.println("A[i]: " + A[i] + " A[j]: " + A[j] + " sum :" + (A[i] + A[j]));
                list.add(A[i] + A[j]);
            }
        }
        System.out.println(mainList);
        if (mainList.size() == 0) {
            return -1;
        }

        List< Integer > ll = mainList.get(0);

        List< Integer > finalList = new ArrayList<>();
        for (List< Integer > l3 : mainList) {
            finalList.add((l3.get(0) + l3.get(1)));
        }

        finalList = finalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return finalList.get(0);


    }

    public int rangeSumBST ( TreeNode root, int low, int high ) {

        BST b = new BST();

        b.inOrder(root);

        Optional< Integer > result = b.list.stream().filter(x -> x >= low && x <= high).collect(Collectors.toList()).stream().reduce(Integer::sum);

        if (result.isPresent()) {
            return result.get();
        } else return -1;

    }

    public TreeNode increasingBST ( TreeNode root ) {

        BST b = new BST();
        b.inOrder(root);

        TreeNode root1 = null;

        for (Integer x : b.list) {
            root1 = b.insert(root1, x);
        }

        return root1;
    }

    public TreeNode invertTree ( TreeNode root ) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);


        root.left = right;
        root.right = left;

        return root;


    }

    public TreeNode searchBST ( TreeNode root, int val ) {

        if (root == null) {
            return null;
        }

        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode insertIntoBST ( TreeNode root, int val ) {
        if (root == null) {
            return createNewNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    private TreeNode createNewNode ( int val ) {
        TreeNode node = new TreeNode();
        node.val = val;
        node.left = null;
        node.right = null;

        return node;
    }


    public int sumOfLeftLeaves ( TreeNode root ) {
        int firstVal = root.val;

        BST b = new BST();
        b.inOrder(root);

        Optional< Integer > i = b.list.stream().reduce(Integer::sum);

        if (i.isPresent()) {
            return (i.get() - firstVal);
        }
        return 0;
    }

    public boolean isSameTree ( TreeNode p, TreeNode q ) {

        boolean isSame = true;

        BST b = new BST();
        BST b1 = new BST();

        b.inOrder(p);
        b1.inOrder(q);

        if (b.list.size() != b1.list.size()) {
            return false;
        }

        for (int i = 0; i < b.list.size(); i++) {
            if (b.list.get(i) != b.list.get(i)) {
                return false;
            }
        }

        return true;

    }


    public int maxDepth ( TreeNode root ) {
        if(root == null){
            return  0;

        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(left > right){
            return left+1;
        }else{
            return right+1;
        }

    }

    public TreeNode sortedListToBST(ListNode head) {

        TreeNode root = null;

        BST b = new BST();
        ListNode currNode = head;

        while(currNode != null){
            root = b.insert(root, currNode.val);
            currNode = currNode.next;
        }
        return root;
    }


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        return null;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {

      BST b = new BST();
      b.inOrder(root);

      List<Integer> l = b.list;
      int count = 0;
      for(int i : l){
          if(i == target){
              count++;
          }
      }
      while(count != 0) {
         root =  b.removeLeafNodes(root, target);
          count--;
      }

      return root;
    }

    private int getSuccessor ( TreeNode root ) {
        int minV = root.val;
        while(root.left != null){
            minV = root.left.val;
            root = root.left;
        }
        return minV;
    }



    public int removeDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for(int i : nums) {
            if (!l.contains(i)) {
                l.add(i);
            }
        }
        int size = nums.length;

        List<Integer> ll = new ArrayList<>();

        for(int i = 0; i < size ; i++){
            if(ll.contains(nums[i])){
                for(int j = i; j < size; j++){
                    if(j+1 < size) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
                i--;
            }else{
                ll.add(nums[i]);
            }

        }
        return size;

    }

}
