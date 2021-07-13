package JUNE.practice1;

import java.util.*;

/**
 * @author sidharthdas on 12/07/21.
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

public class LeetCode13thJuly {

    public static void main ( String[] args ) {
        LeetCode13thJuly leetCode13thJuly = new LeetCode13thJuly();
        int[] nums = {0, 0, 1};
        // leetCode13thJuly.moveZeroes(nums);

        //LeetCode13thJuly.printDivisors(28);


        //System.out.println(leetCode13thJuly.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        System.out.println("This1".substring("This1".length() - 1, "This1".length()));
    }

    public int kthSmallest ( TreeNode root, int k ) {

        BST1 b = new BST1();
        b.inOrder(root);
        Collections.sort(b.list);
        return b.list.get(k);


    }

    public void moveZeroes ( int[] nums ) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int z = i;
                for (int j = i + 1; j < length; j++) {

                    int num = nums[z];
                    nums[z] = nums[j];
                    nums[j] = num;
                    z++;
                }
            }
        }


    }

    public boolean canConstruct ( String ransomNote, String magazine ) {
        String[] ransomNoteArr = ransomNote.split("");
        String[] magazineArr = magazine.split("");

        Map< String, Integer > ransomNoteMap = new HashMap<>();

        for (String s : ransomNoteArr) {
            if (ransomNoteMap.containsKey(s)) {
                ransomNoteMap.put(s, ransomNoteMap.get(s) + 1);
            } else {
                ransomNoteMap.put(s, 1);
            }
        }
        Map< String, Integer > magazineMap = new HashMap<>();

        for (String s : magazineArr) {
            if (magazineMap.containsKey(s)) {
                magazineMap.put(s, magazineMap.get(s) + 1);
            } else {
                magazineMap.put(s, 1);
            }
        }

        boolean flag = true;

        for (Map.Entry< String, Integer > m : ransomNoteMap.entrySet()) {
            if (magazineMap.containsKey(m.getKey())) {
                if (magazineMap.get(m.getKey()) >= m.getValue()) {

                } else {
                    flag = false;
                    break;
                }

            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public int firstUniqChar ( String s ) {

        char[] crr = s.toCharArray();
        Map< Character, Integer > map = new LinkedHashMap<>();
        for (char i : crr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry< Character, Integer > m : map.entrySet()) {
            if (m.getValue() == 1) {
                int index = s.indexOf(m.getKey());
                return index;
            }
        }
        return -1;
    }

    public boolean checkPerfectNumber ( int num ) {
        List< Integer > list = new ArrayList<>();

        for (int i = 1; i * i < num; i++) {
            if (num % i == 0)
                list.add(i);
        }
        for (int i = (int) Math.sqrt(num);
             i >= 1; i--) {
            if (num % i == 0)
                list.add(num / i);
        }

        list.remove(num);
        int sum = list.stream().filter(x -> x != num).reduce(0, Integer::sum);

        return sum == num ? true : false;
    }

    public static void printDivisors ( int n ) {
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0)
                System.out.print(i + " ");
        }
        for (int i = (int) Math.sqrt(n);
             i >= 1; i--) {
            if (n % i == 0)
                System.out.print(n / i + " ");
        }
    }

    public boolean judgeSquareSum ( int c ) {
        if (c == 1) {
            return true;
        }
        int n = c / 2;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int res = (i * i) + (j * j);
                if (res == c) {
                    return true;
                }

            }
        }

        return false;
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

        ListNode head = null;

        ListNode curNode = null;

        for (int i : nums) {

            ListNode n = new ListNode();
            n.val = i;

            if (head == null) {
                head = n;
                curNode = n;
            } else {
                ListNode cNode = head;
                while (cNode.next != null) {
                    cNode = cNode.next;
                }
                cNode.next = n;

            }
        }
        l1 = head;
        return l1;
    }

    public ListNode removeNthFromEnd ( ListNode head, int n ) {
        int totalSize = 0;
        int index = 0;
        ListNode currNode = head;
        while (currNode != null) {
            totalSize += 1;
            currNode = currNode.next;
        }
        ListNode cNode = head;
        while (cNode != null) {
            index += 1;

            int s = totalSize - index;
            if (s == n) {
                ListNode n1 = cNode.next.next;
                cNode.next = n1;
                break;
            }
            cNode = cNode.next;
        }

        return head;

    }

    public boolean validMountainArray ( int[] arr ) {
        List< Integer > acc = new ArrayList<>();
        List< Integer > desc = new ArrayList<>();
        int arrLength = arr.length;
        if (arrLength == 2) {
            if (arr[0] >= arr[1]) {
                return false;
            } else {
                return true;
            }
        }
        int descStartingIndex = 0;
        int num = 0;
        for (int i = 0; i < arrLength; i++) {
            if (i == 0) {
                acc.add(arr[i]);
            } else {
                if (acc.get(i - 1) < arr[i]) {
                    acc.add(arr[i]);
                } else if (acc.get(i - 1) == arr[i]) {
                    return false;

                } else {
                    descStartingIndex = i;
                    num = arr[i];
                    break;
                }
            }
        }
        int k = 1;
        for (int i = descStartingIndex; i < arrLength; i++) {
            if (i == descStartingIndex) {
                desc.add(arr[i]);

            } else {
                if (desc.get(k - 1) > arr[i]) {
                    desc.add(arr[i]);
                    k++;
                } else if (desc.get(k - 1) == arr[i]) {
                    return false;

                } else {
                    return false;
                }
            }
        }


        int totalSize = acc.size() + desc.size();

        if (totalSize == arrLength) {
            if (acc.size() == 0 || desc.size() == 0) {
                return false;
            }
        }
        return totalSize == arrLength ? true : false;
    }

    public int longestCommonSubsequence ( String text1, String text2 ) {
        if (text1.equals(text2)) {
            return text1.length();
        }
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();

        //Arrays.sort(text1Arr);
        //Arrays.sort(text2Arr);

        int length1 = text1Arr.length;
        int length2 = text2Arr.length;

        String s1 = String.valueOf(text1Arr);
        String s2 = String.valueOf(text2Arr);

        if (length1 > length2) {
            int size = 0;
            for (int i = 0; i < length2; i++) {
                if (s1.contains(s2.charAt(i) + "")) {
                    size += 1;
                } else {
                    if (size != 0) {
                        break;
                    }
                }
            }
            return size;


        } else if (length1 <= length2) {
            int size = 0;
            for (int i = 0; i < length1; i++) {
                if (s2.contains(s1.charAt(i) + "")) {
                    size += 1;
                } else {
                    if (size != 0) {
                        break;
                    }

                }
            }
            return size;


        }

        return 0;


    }


    public TreeNode removeLeafNodes ( TreeNode root, int target ) {

        if (root == null) {
            return null;
        }

        if (target < root.val) {
            root.left = removeLeafNodes(root.left, target);
        } else if (target > root.val) {
            root.right = removeLeafNodes(root.right, target);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }
            root.val = getSuccessor(root);
            root.right = removeLeafNodes(root.right, root.val);
        }
        return root;

    }

    private int getSuccessor ( TreeNode root ) {
        int minV = root.val;
        while (root.left != null) {
            minV = root.left.val;
            root = root.left;
        }
        return minV;
    }

    public int findPeakElement ( int[] nums ) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                continue;
            } else {
                if (i + 1 < length) {
                    if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public String sortSentence ( String s ) {

        String[] str = s.split(" ");

        int length = str.length;

        Map< Integer, String > map = new TreeMap<>();

        for (int i = 0; i < length; i++) {
            int len = str[i].length();
            map.put(Integer.parseInt(str[i].substring(len - 1, len)), str[i].substring(0, len - 1));
        }

        String finalString = "";

        for (int i = 1; i <= length; i++) {
            if (i == 1) {
                finalString += map.get(i);
            } else {
                finalString += " " + map.get(i);
            }
        }
        String res = "";
        for (Map.Entry< Integer, String > m : map.entrySet()) {
            if (res.equals("")) {
                res += m.getValue();
            } else {
                res += " " + m.getValue();
            }

        }

        return res;
    }

    public int[] sortArrayByParity ( int[] nums ) {
        int len = nums.length;
        int[] res = new int[len];

        int starting = 0;
        int end = len - 1;

        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                res[starting] = nums[i];
                starting += 1;
            } else {
                res[end] = nums[i];
                end -= 1;
            }
        }
        return res;

    }

    public double average ( int[] salary ) {

        int len = salary.length;

        Arrays.sort(salary);

        int sum = 0;

        for (int i = 1; i < len - 1; i++) {
            sum += salary[i];
        }

        double d = Double.valueOf(String.valueOf(sum)) / Double.valueOf(String.valueOf((len-2)));
        return d;

    }
}

class BST1 {
    List< Integer > list = new ArrayList<>();

    public void inOrder ( TreeNode head ) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        list.add(head.val);
        inOrder(head.right);

    }
}

