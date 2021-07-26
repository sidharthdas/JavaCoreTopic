package JUNE.practice23rdJuly.test;

import java.util.*;
import java.util.stream.Collectors;

/*/ /
   @author sidharthdas on 25/07/21.
  / /*/


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

public class Leetcode25July {


    public static void main ( String[] args ) {

    }

    public int sumOddLengthSubarrays ( int[] arr ) {

        int arrSize = arr.length;
        //start point
        List< List< Integer > > list = new ArrayList<>();
        for (int startPoint = 0; startPoint < arrSize; startPoint++) {
            //group sizes

            for (int grps = startPoint; grps <= arrSize; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                List< Integer > list1 = new ArrayList<>();
                for (int j = startPoint; j < grps; j++) {
                    System.out.print(arr[j] + " ");
                    list1.add(arr[j]);
                }
                list.add(list1);
                System.out.println();
            }
        }
        System.out.println(list);

        List< List< Integer > > mainList = list.stream().filter(x -> x.size() % 2 != 0).collect(Collectors.toList());
        int total = 0;
        for (List< Integer > l : mainList) {

            if (l.size() > 0) {
                for (int i : l) {
                    total += i;
                }
            }

        }
        return total;

    }

    public int uniqueMorseRepresentations ( String[] words ) {

        List< String > codeList = Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..");
        List< String > alphaList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        List< String > list = new ArrayList<>();

        for (String s : words) {
            String str[] = s.split("");
            String newS = "";
            for (String s1 : str) {
                int index = alphaList.indexOf(s1);
                newS += codeList.get(index);
            }
            list.add(newS);
        }

        int size = list.stream().collect(Collectors.toSet()).size();
        return size;


    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            root.val = getSuccessor(root);

            root.right = deleteNode(root.right, root.val);
        }
return root;
    }

    private int getSuccessor ( TreeNode root ) {
        int minValue = root.val;
        while(root.left != null){
            minValue = root.left.val;
            root = root.left;
        }

        return minValue;
    }

    public List< Integer > getAllElements ( TreeNode root1, TreeNode root2 ) {

        BST B = new BST();
        B.inOrder(root1);
        List< Integer > l1 = B.l;


        BST B1 = new BST();
        B1.inOrder(root2);
        List< Integer > l2 = B1.l;

        l1.addAll(l2);

        return l1;


    }

    public boolean squareIsWhite ( String coordinates ) {

        List< String > ifNumberIsEvenThenItsWhite = Arrays.asList("a", "c", "e", "g");
        List< String > ifNumberIsOddThenItsWhite = Arrays.asList("a", "c", "e", "g");

        String str[] = coordinates.split("");

        if (ifNumberIsEvenThenItsWhite.contains(str[0])) {
            return Integer.valueOf(str[1]) % 2 == 0 ? true : false;
        } else if (ifNumberIsOddThenItsWhite.contains(str[0])) {
            return Integer.valueOf(str[1]) % 2 == 0 ? false : true;
        }

        return false;
    }


}


class BST {

    List< Integer > l = new ArrayList<>();

    public void inOrder ( TreeNode node ) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        l.add(node.val);
        inOrder(node.right);

    }

    public ListNode addTwoNumbers ( ListNode l1, ListNode l2 ) {
        LinkL ll = new LinkL();

        ll.insert(l1);
        String s1 = ll.s;

        LinkL ll1 = new LinkL();

        ll1.insert(l2);
        String s2 = ll1.s;

        int sum = Integer.valueOf(s1) + Integer.valueOf(s2);

        String[] arr = String.valueOf(sum).split("");
        LinkL ll3 = new LinkL();
        ListNode head = new ListNode();

        for (String s : arr) {
            head = ll3.insertAtEnd(head, Integer.valueOf(s));
        }

        return head;
    }


}

class LinkL {

    String s = "";

    public void insert ( ListNode node ) {
        if (node == null) {
            return;
        }

        ListNode currNode = node;
        while (currNode != null) {
            s += String.valueOf(currNode.val);
        }
    }


    public ListNode insertAtEnd ( ListNode node, int data ) {
        ListNode newNode = new ListNode();
        if (node == null) {
            node = newNode;
            return node;
        }

        ListNode currNode = node;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;

        return node;

    }

    public String reformatDate ( String date ) {

        List< String > months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        String[] str = date.split(" ");

        String day = str[0].replaceAll("[a-zA-Z]", "");
        int day1 = Integer.valueOf(day);
        String day2 = "";
        if (day1 < 10) {
            day2 += "0" + String.valueOf(day1);
        } else {
            day2 = String.valueOf(day1);
        }
        String month = "";
        int i = months.indexOf(str[1]) + 1;
        if (i < 10) {
            month += "0" + String.valueOf(i);
        } else {
            month = String.valueOf(i);
        }

        String result = str[2] + "-" + month + "-" + day2;

        return result;

    }

    public String shortestCompletingWord ( String licensePlate, String[] words ) {

        licensePlate = licensePlate.replaceAll("[^a-zA-Z]", "");

        licensePlate = licensePlate.toLowerCase();

        char[] arr = licensePlate.toCharArray();
        int length = arr.length;

        Arrays.sort(arr);

        String toBeChecked = String.valueOf(arr);

        List< String > list = new ArrayList<>();

        for (String s : words) {
            list.add(s);
        }

        Comparator< String > comparator = ( String o1, String o2 ) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        };

        Collections.sort(list, comparator);

        for (String s : list) {
            int count = 0;
            for (char a : arr) {
                if (s.contains(a + "")) {
                    count += 1;
                }
            }

            if (count == length) {
                return s;
            }
        }
        return null;
    }

    public int singleNonDuplicate ( int[] nums ) {

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }


        for(Map.Entry<Integer, Integer> m : map.entrySet()){
           if(m.getValue() == 1){
               return m.getKey();

            }
        }
    return -1;
    }

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();

        for(int i = low; i<=high; i++){

            String value = String.valueOf(i);

        }

        return null;

    }

    public int[] getNoZeroIntegers(int n) {

        if(n == 2){
            return new int[]{1,1};
        }
        else{
            return new int[]{1, n-1};
        }

    }



    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int size = nums.length;

        return nums[size-1] * nums[size-2] * nums[size -3];

    }
}
