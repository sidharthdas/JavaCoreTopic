package JUNE.practice1;


import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 11/07/21.
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

public class LeetCode11thJuly {

    public static void main ( String[] args ) {

        int[] a = {37, 12, 28, 9, 100, 56, 80, 5, 12};

        //System.out.println(-2147483648 - 2147483647);

        LeetCode11thJuly leetCode11thJuly = new LeetCode11thJuly();


        int[] arr = {1};

        //System.out.println("flow".equals("flow"));

        System.out.println(leetCode11thJuly.myAtoi("+1"));


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
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        List< Integer > list = new ArrayList<>();
        for (Map.Entry< String, Integer > m : map.entrySet()) {
            list.add(m.getValue());
        }

        Collections.sort(list);
        int sizeofList = list.size();
        List< Integer > valuesAperK = new ArrayList<>();
        int s = k;
        for (int i = sizeofList - 1; i >= 0; i--) {

            if (s != 0) {
                valuesAperK.add(list.get(i));
                s -= 1;
            }

        }
        valuesAperK = valuesAperK.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        List< String > mainList = new ArrayList<>();

        for (int i : valuesAperK) {
            for (Map.Entry< String, Integer > m : map.entrySet()) {
                if (m.getValue() == i) {
                    mainList.add(m.getKey());
                }
            }
        }
        Collections.sort(mainList);
        return mainList;
    }

    public String frequencySort ( String s ) {

        String[] str = s.split("");

        Map< String, Integer > map = new HashMap<>();
        for (String ss : str) {
            if (map.containsKey(ss)) {
                map.put(ss, map.get(ss) + 1);
            } else {
                map.put(ss, 1);
            }
        }

        List< Integer > list = new ArrayList<>();
        for (Map.Entry< String, Integer > m : map.entrySet()) {
            list.add(m.getValue());
        }

        Collections.sort(list);
        int sizeofList = list.size();
        String res = "";
        for (int i = sizeofList - 1; i >= 0; i--) {
            for (Map.Entry< String, Integer > m : map.entrySet()) {
                if (m.getValue() == list.get(i)) {
                    for (int j = 0; j < m.getValue(); j++) {
                        res += m.getKey();

                    }
                }
            }
        }


        return res;

    }

    public boolean isPowerOfThree ( int n ) {
        int count = 0;
        while (n != 1) {
            if (n % 3 == 0) {
                n = n / 3;
                count += 1;
            } else {
                return false;
            }

        }
        return true;
    }


    public ListNode removeElements ( ListNode head, int val ) {

        int count = 0;
        int sameValCount = 0;
        ListNode n = head;
        while (n != null) {
            count += 1;
            n = n.next;
        }

        ListNode n1 = head;
        while (n1 != null) {
            if (n1.val == val) {
                sameValCount += 1;

            }
            n1 = n1.next;
        }

        if (count == 1) {
            if (head.val == val) {
                head = null;
                return head;
            } else {
                return head;
            }
        }

        if (count == sameValCount) {
            head = null;
            return head;
        }
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            ListNode node = head.next;
            head = node;
        }
        System.out.println(head.val);
        ListNode currNode = head;

        while (currNode != null) {
            System.out.println(currNode.val);
            if (currNode.next != null) {
                System.out.println(currNode.next.val);
                if (currNode.next.val == val) {
                    if (currNode.next.next != null) {
                        ListNode node = currNode.next.next;
                        currNode.next = node;
                    } else {
                        currNode.next = null;
                    }
                }

            }
            currNode = currNode.next;
        }

        return head;
    }

    public boolean isPalindrome ( ListNode head ) {
        if (head == null) {
            return false;
        }

        String s = "";

        while (head != null) {
            s += head.val;
            head = head.next;
        }
        String res = "";
        String str[] = s.split("");
        int size = s.length();
        for (int i = size - 1; i >= 0; i--) {
            res += str[i];
        }

        return res.equals(s) ? true : false;
    }

    public ListNode mergeTwoLists ( ListNode l1, ListNode l2 ) {
        List< Integer > nums = new ArrayList<>();
        while (l1 != null) {
            nums.add(l1.val);
        }
        while (l2 != null) {
            nums.add(l2.val);
        }

        Collections.sort(nums);
        ListNode node;
        for (int i : nums) {

        }

        return null;
    }

    private ListNode insert ( ListNode node, int val ) {
        return null;
    }

    public String longestCommonPrefix ( String[] strs ) {
        List< String > list = new ArrayList<>();

        Comparator< String > comparator = ( String o1, String o2 ) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        };

        for (String s : strs) {
            list.add(s);
        }

        Collections.sort(list, comparator);

        String longestCommonSubString = list.get(0);
        System.out.println(longestCommonSubString);
        int longestCommonSubStringSize = longestCommonSubString.length();
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            System.out.println(list.get(i));
            System.out.println(list.get(i).equals(longestCommonSubString) == false);
            if (list.get(i).equals(longestCommonSubString) == false) {
                while (!list.get(i).substring(0, longestCommonSubStringSize).equals(longestCommonSubString)) {
                    longestCommonSubStringSize = longestCommonSubStringSize - 1;
                    System.out.println(longestCommonSubStringSize);
                    longestCommonSubString = longestCommonSubString.substring(0, longestCommonSubStringSize);
                    System.out.println(longestCommonSubString);
                }
            }
        }

        return longestCommonSubString;
    }


    public ListNode removeNthFromEnd ( ListNode head, int n ) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            prev = current;
            current = next;
        }

        head = prev;

        int pos = 0;
        ListNode currNode = head;
        while (currNode != null) {
            pos += 1;

            if (pos == n) {

            }


        }
        return null;
    }

    public int[] searchRange ( int[] nums, int target ) {
        int[] res = new int[2];

        List< Integer > list = new ArrayList<>();
        Map< Integer, Integer > map = new HashMap<>();
        for (int i : nums) {
            list.add(i);
        }

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        if (map.containsKey(target)) {
            if (map.get(target) == 1) {
                int i = list.indexOf(target);
                res = new int[]{i, i};
                return res;
            } else {

                int i = list.indexOf(target);
                res = new int[]{i, i + map.get(target) - 1};
                return res;
            }

        } else {
            res = new int[]{-1, -1};
            return res;
        }

    }

    public int fib ( int n ) {

        List< Integer > list = new ArrayList<>();
        list.add(0);
        list.add(1);

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int count = n;
        int prevvalue = 1;
        int prevPrevvalue = 0;

        while (list.size() != n) {
            int newVal = prevvalue + prevPrevvalue;
            list.add(newVal);
            prevPrevvalue = prevvalue;
            prevvalue = newVal;
        }

        return list.get(list.size() - 1);

    }

    public int fib4 ( int n ) {

        List< Integer > list = new ArrayList<>();
        list.add(0);
        list.add(1);

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int count = n;
        int prevvalue = 1;
        int prevPrevvalue = 0;
        int sum = 1;


        while (list.size() != n) {
            int newVal = prevvalue + prevPrevvalue;
            sum = sum + newVal;
            list.add(newVal);
            prevPrevvalue = prevvalue;
            prevvalue = sum;
        }

        return sum;

    }

    public int search ( int[] nums, int target ) {
        Node root = null;
        int size = nums.length;
        BST B = new BST();
        for (int i = 0; i < size; i++) {
            root = B.insert(root, nums[i]);
        }

        return B.checkNode(root, target);
    }

    class Node {

        int data;
        Node left;
        Node right;
    }

    class BST {
        public Node insert ( Node node, int data ) {
            if (node == null) {
                return createNewNode(data);
            }
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else if (data > node.data) {
                node.right = insert(node.right, data);
            }

            return node;
        }

        private Node createNewNode ( int data ) {
            Node node = new Node();
            node.data = data;
            node.left = null;
            node.right = null;

            return node;
        }

        public int checkNode ( Node node, int data ) {
            if (node == null) {
                return -1;
            }

            boolean flag = false;
            int index = 0;
            while (node != null) {
                if (data < node.data) {
                    node = node.left;
                    index += 1;
                } else if (data > node.data) {
                    node = node = node.right;
                    index += 1;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag == true) {
                return index;
            } else {
                return -1;
            }
        }
    }

    public int myAtoi ( String s ) {

        s = s.replaceAll("\\s", "");

        List< Integer > list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(s.charAt(0));
        System.out.println(list.contains(s.charAt(0)));
        int count = 0;
        try {
            int i = Integer.parseInt(String.valueOf(s.charAt(0)));
            count += 1;
        } catch (Exception e) {
        }
        if (count == 0) {
            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                int z = 0;
                try {
                    int i = Integer.parseInt(String.valueOf(s.charAt(1)));
                    z += 1;
                } catch (Exception e) {
                }

                if(z == 0){
                    return 0;
                }else{
                    s = s.replaceAll("[^0-9-]", "");
                    BigInteger b = new BigInteger(s);
                    if(b.compareTo(new BigInteger(String.valueOf(0))) < 0){
                        if(b.compareTo(new BigInteger(String.valueOf(-2147483648))) < 0){
                            return -2147483648;
                        }
                    }
                    return Integer.parseInt(s);
                }
            } else {
                return 0;
            }

        }
        s = s.replaceAll("[^0-9-]", "");
        if(s.contains(".")){
            return (int)Math.round(Float.parseFloat(s));
        }
        BigInteger b = new BigInteger(s);
        if(b.compareTo(new BigInteger(String.valueOf(0))) < 0){
            if(b.compareTo(new BigInteger(String.valueOf(-2147483648))) < 0){
                return -2147483648;
            }
        }
        return Integer.parseInt(s);
    }
}






