package JUNE.practice1;

import org.w3c.dom.ls.LSInput;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 16/07/21.
 */


class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1 () {
    }

    ListNode1 ( int val ) {
        this.val = val;
    }

    ListNode1 ( int val, ListNode1 next ) {
        this.val = val;
        this.next = next;
    }
}


class LL {

    List< Integer > list = new ArrayList<>();

    public void addIntegerToList ( ListNode1 l ) {

        if (l == null) {
            return;

        }
        ListNode1 n = l;

        while (n != null) {
            list.add(n.val);
        }
    }
}


class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1 () {
    }

    TreeNode1 ( int val ) {
        this.val = val;
    }

    TreeNode1 ( int val, TreeNode1 left, TreeNode1 right ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BST2 {

    List< Integer > list = new ArrayList<>();

    public TreeNode1 insert ( TreeNode1 node, int data ) {
        if (node == null) {
            return createNEWNode(data);
        }
        if (data < node.val) {
            node.left = insert(node.left, data);
        } else if (data > node.val) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    private TreeNode1 createNEWNode ( int data ) {
        TreeNode1 node = new TreeNode1();
        node.val = data;
        return node;
    }

    public void inOrder ( TreeNode1 node ) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}

public class LeetCode16thJuly {

    public static void main ( String[] args ) {

        String word1 = "abcd", word2 = "pq";


        LeetCode16thJuly leetCode16thJuly = new LeetCode16thJuly();
        System.out.println(Math.pow(3,3));
       // System.out.println(leetCode16thJuly.maxIceCream(new int[]{1, 2,3,4,1}, 7));


    }

    public int[] sortArrayByParityII ( int[] nums ) {

        int numSize = nums.length;

        int[] res = new int[numSize];

        int evenIndex = 0;
        int oddIndex = 1;

        for (int i = 0; i < numSize; i++) {
            if (nums[i] % 2 == 0) {
                res[evenIndex] = nums[i];
                evenIndex += 2;
            } else if (nums[i] % 2 != 0) {
                res[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }
        return res;
    }

    public String mergeAlternately ( String word1, String word2 ) {


        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 > len2) {
            String res = "";
            String s1 = word1.substring(0, word2.length());
            String s2 = word1.substring(word2.length(), word1.length());

            String s1tr[] = s1.split("");

            for (int i = 0; i < len2; i++) {
                res += s1.charAt(i) + "" + word2.charAt(i) + "";
            }

            res += s2;

            return res;

        } else if (len1 < len2) {

            String res = "";
            String s1 = word2.substring(0, word1.length());
            String s2 = word2.substring(word1.length(), word2.length());

            String s1tr[] = s1.split("");

            for (int i = 0; i < len1; i++) {
                res += word1.charAt(i) + "" + s1.charAt(i) + "";
            }

            res += s2;

            return res;

        } else {

            String res = "";
            System.out.println(word1);
            System.out.println(word2);
            for (int i = 0; i < len2; i++) {
                res += word1.charAt(i) + "" + word2.charAt(i) + "";
            }

            return res;

        }
    }

    public String reverseStr ( String s, int k ) {

        String s1 = s.substring(0, k);

        String s2 = s.substring(k, s.length());

        String s3 = "";
        for (int i = k - 1; i >= 0; i--) {
            s3 += s1.charAt(i) + "";
        }
        return s3 + s2 + "";
    }

    public boolean checkIfExist ( int[] arr ) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i != j) {
                    if (arr[i] == 2 * arr[j]) {

                        return true;
                    }
                }
            }


        }
        return false;
    }

    public String reverseVowels ( String s ) {
        List< String > vowels = Arrays.asList("a", "e", "i", "o", "u");

        List< String > vowelsInString = new ArrayList<>();

        String[] st = s.split("");
        int size = st.length;
        int index = 0;
        int ress = 0;

        for (int i = 0; i < size; i++) {
            if (vowels.contains(st[i])) {
                vowelsInString.add(st[i]);
                st[i] = index + "";
                index += 1;
            }
        }
        List< String > revVowelsInString = new ArrayList<>();
        int vSize = vowelsInString.size();

        for (int i = vSize - 1; i >= 0; i--) {
            revVowelsInString.add(vowelsInString.get(i));
        }

        for (int i = 0; i < size; i++) {
            if (st[i].equals(String.valueOf(ress))) {
                st[i] = revVowelsInString.get(ress);
                ress += 1;
            }
        }
        String finalRes = "";
        for (String s1 : st) {
            finalRes += s1;
        }
        return finalRes;
    }


    public boolean findTarget ( TreeNode1 root, int k ) {

        BST2 b = new BST2();

        b.inOrder(root);

        int size = b.list.size();

        for (int i = 0; i < size; i++) {
            int j = k = b.list.get(i);

            if (b.list.contains(j)) {
                return true;
            }
        }

        return false;
    }


    public ListNode1 sortList ( ListNode1 head ) {
        LL l = new LL();
        l.addIntegerToList(head);

        Collections.sort(l.list);

        ListNode1 lll = null;
        for (int i : l.list) {
            if (lll == null) {
                lll = new ListNode1();
                lll.val = i;
                lll.next = null;
            } else {
                ListNode1 newNode = new ListNode1(i);
                ListNode1 currNode = lll;

                while (currNode.next != null) {
                    currNode = currNode.next;
                }
                currNode.next = newNode;
            }
        }

        head = lll;

        return head;

    }

    public List< String > printVertically ( String s ) {

        int heightest = 0;

//["TBONTB","OEROOE","   T"]
        String[] str = s.split(" ");

        for (String st : str) {
            if (st.length() > heightest) {
                heightest = st.length();
            }
        }

        List< String > list = new ArrayList<>();
        String res = "";
        int index = 0;

        for (int i = 0; i < heightest; i++) {
            for (String s2 : str) {
                if (s2.length() > index) {
                    res += s2.charAt(index) + "";

                } else {
                    res += "  ";
                }
            }
            res.replaceAll("\\s+$", "");
            list.add(res);
            res = "";
            index++;
        }

        return list;

    }

    public int countPrimes ( int n ) {

        int count = 0;

        for (int i = 2; i <= n; i++) {
            int counttt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    counttt++;
                    if (counttt > 2) {
                        break;
                    }
                }
            }
            if (counttt == 2) {
                count += 1;
            }
        }
        return count;
    }


    public List< Integer > findDisappearedNumbers ( int[] nums ) {
        List< Integer > result = new ArrayList<>();
        List< Integer > res = new ArrayList<>();
        List< Integer > mainList = new ArrayList<>();
        for (int i : nums) {
            mainList.add(i);
        }
        Collections.sort(mainList);
        int lastValue = mainList.get(mainList.size() - 1);

        for (int i = 1; i <= lastValue; i++) {
            res.add(i);
        }

        for (int i : nums) {
            System.out.println(i);
            if (res.contains(i)) {
                System.out.println(i);
                System.out.println(res.remove(i));
            }
        }

        return res;

    }

    public int[] replaceElements ( int[] arr ) {

        int size = arr.length;
        int[] res = new int[size];
        List< Integer > list = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            for (int j = i + 1; j < size; j++) {
                list.add(arr[j]);
            }

            Collections.sort(list);
            if (i != (size - 1)) {
                res[i] = list.get(list.size() - 1);
                list = new ArrayList<>();
            }

        }
        res[size - 1] = -1;
        return res;
    }


    public int[] plusOne ( int[] digits ) {

        String s = "";
        for (int i : digits) {
            s = s + String.valueOf(i);
        }


        BigInteger b = new BigInteger(s);
        b = b.add(new BigInteger(String.valueOf(1)));

        String s2 = String.valueOf(b);
        String str[] = s2.split("");
        int len = str.length;

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = Integer.parseInt(str[i]);
        }
        return res;
    }

    public List< Integer > addToArrayForm ( int[] num, int k ) {
        String s = "";
        for (int i : num) {
            s = s + String.valueOf(i);
        }

        BigInteger b = new BigInteger(s);
        b = b.add(new BigInteger(String.valueOf(k)));

        String s2 = String.valueOf(b);
        String str[] = s2.split("");
        List< Integer > finalList = new ArrayList<>();

        for (String a : str) {
            finalList.add(Integer.parseInt(a));
        }

        return finalList;
    }


    public void test () {

        List< Integer > list = new ArrayList<>();

        for (int i : list) {

        }
    }

    public int maxProduct ( int[] nums ) {
        List< Integer > list = new ArrayList<>();
        int size = nums.length;

        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        if (size >= 2) {
            return ((list.get(size - 1) - 1) - (list.get(size - 2) - 1));
        } else {
            return -1;
        }
    }

    public List< Integer > selfDividingNumbers ( int left, int right ) {
        List< Integer > list = new ArrayList<>();

        for (int i = left; i <= right; i++) {


            String s = String.valueOf(i);
            if (s.length() == 1) {
                list.add(i);
            } else {
                String[] st = s.split("");

                boolean flag = true;
                for (String s1 : st) {

                    if (Integer.valueOf(s1) == 0) {
                        flag = false;
                        break;
                    }

                    if (i % Integer.valueOf(s1) != 0) {
                        flag = false;
                        break;
                    }

                }

                if (flag) {
                    list.add(i);
                }
            }

        }
        return list;
    }

    public int heightChecker ( int[] heights ) {
        int count = 0;

        List< Integer > list = new ArrayList<>();
        for (int i : heights) {
            list.add(i);

        }
        int size = heights.length;
        Collections.sort(list);

        for (int i = 0; i < size; i++) {
            if (heights[i] != list.get(i)) {
                count += 1;
            }
        }
        return count;
    }


    public boolean isSumEqual ( String firstWord, String secondWord, String targetWord ) {

        Map< String, Integer > map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        map.put("e", 4);
        map.put("f", 5);
        map.put("g", 6);
        map.put("h", 7);
        map.put("i", 8);
        map.put("j", 9);

        map.put("k", 10);
        map.put("l", 11);
        map.put("m", 12);
        map.put("n", 13);
        map.put("o", 14);
        map.put("p", 15);
        map.put("q", 16);
        map.put("r", 17);
        map.put("s", 18);
        map.put("t", 19);

        map.put("u", 20);
        map.put("v", 21);
        map.put("w", 22);
        map.put("x", 23);
        map.put("y", 24);
        map.put("z", 25);

        String firstWordS = "";
        String firstWordtr[] = firstWord.split("");
        for (String s : firstWordtr) {
            firstWordS += map.get(s);
        }

        String secondWordS = "";
        String secondWordtr[] = secondWord.split("");
        for (String s : secondWordtr) {
            secondWordS += map.get(s);
        }

        String targetWordS = "";
        String targetWordtr[] = targetWord.split("");
        for (String s : targetWordtr) {
            targetWordS += map.get(s);
        }

        BigInteger b1 = new BigInteger(firstWordS);
        BigInteger b2 = new BigInteger(secondWordS);
        BigInteger b3 = new BigInteger(targetWordS);

        if (b1.add(b2).equals(b3)) {
            return true;
        }


        return false;

    }

    public List< String > commonChars ( String[] words ) {

        Map< String, Integer > map = new HashMap<>();

        return null;

    }


    public int[] frequencySort ( int[] nums ) {

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        final Map< Integer, Integer > sortedByCount = map.entrySet()
                .stream()
                .sorted((Map.Entry.< Integer, Integer >comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));


        int[] res = new int[nums.length];
        int index = 0;

        for (Map.Entry< Integer, Integer > m : sortedByCount.entrySet()) {

            for (int i = 0; i < m.getValue(); i++) {
                res[index] = m.getValue();
                index++;

            }

        }

        return res;

    }

    public int[] singleNumber ( int[] nums ) {

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int res[] = new int[2];
        int i = 0;

        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() == 1) {
                res[i] = m.getKey();
                i++;
            }
        }
        return res;
    }


    public boolean isMonotonic ( int[] nums ) {
        int size = nums.length;

        if (nums[0] > nums[1]) {

            for (int i = 0; i < size; i++) {
                if ((i + 1) < size) {
                    if (nums[i] < nums[i + 1]) {
                        return false;
                    }
                }

            }
        } else {

            for (int i = 0; i < size; i++) {
                if ((i + 1) < size) {
                    if (nums[i] > nums[i + 1]) {
                        return false;
                    }
                }

            }
        }

        return true;
    }


    public double trimMean ( int[] arr ) {
        List< Integer > nums = new ArrayList<>();

        for (int i : arr) {
            nums.add(i);
        }
        Collections.sort(nums);

        nums.remove(nums.get(0));
        nums.remove(nums.get(nums.size() - 1));

        double d = Double.valueOf(String.valueOf(nums.stream().reduce(0, Integer::sum))) / Double.valueOf(String.valueOf(nums.size()));
        return d;
    }

    public String[] findOcurrences ( String text, String first, String second ) {

        List< String > result = new ArrayList<>();

        String str[] = text.split(" ");
        List< String > list = new ArrayList<>();
        for (String s : str) {
            list.add(s);

        }
        int size = str.length;
        for (int i = 0; i < size; i++) {
            if (i + 1 < size) {
                if (str[i].equals(first) && str[i + 1].equals(second)) {
                    if (i + 2 < size) {
                        result.add(str[i + 2]);
                    }

                }
            }
        }

        int size1 = result.size();
        String[] res = new String[size1];
        int i = 0;
        for (String s : result) {
            res[i] = s;
            i++;
        }
        return res;
    }


    public int maxIceCream ( int[] costs, int coins ) {

        List< Integer > list = new ArrayList<>();
        int count = 0;

        for (int i : costs) {
            list.add(i);
        }

        Collections.sort(list);

        for(int i : list){
            if(coins -i >= 0){
                count++;
                coins = coins-i;
            }else{
                break;
            }
        }
        return count;
    }

    public int kthFactor(int n, int k) {

        List<Integer> list = new ArrayList<>();


        for(int i = 1; i <=n; i++){

            if(n % i == 0){
                list.add(i);
            }
        }
        return list.get(k+1);
    }

}



