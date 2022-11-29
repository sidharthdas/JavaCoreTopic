package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  17/11/22
 */
public class Leetcode21MainClass {

    public static void main(String[] args) {
       /* ["Bank","deposit","transfer","transfer"]
[[[0]],[1,2],[1,1,1],[1,1,3]]*//*
        Bank bank = new Bank(new long[]{0});

        bank.deposit(1, 2);     // return true, it is valid to deposit $20 to account 5.
        // Account 5 has $10 + $20 = $30.
        bank.transfer(3, 4, 15); // return false, the current balance of account 3 is $10,
        // so it is invalid to transfer $15 from it.
        bank.withdraw(10, 50);   // return false, it is invalid because account 10 does not*/
        //["WordDictionary","addWord","addWord","search","search","search","search","search","search","search","search"]
        //[[],["a"],["ab"],["a"],["a."],["ab"],[".a"],[".b"],["ab."],["."],[".."]]
        /*WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");
        wordDictionary.search("a"); // return False
        wordDictionary.search("a."); // return True
        wordDictionary.search("ab"); // return True
        wordDictionary.search(".a"); // return True
        wordDictionary.search(".b"); // return True
        wordDictionary.search("ab."); // return True
        wordDictionary.search("."); // return True
        wordDictionary.search(".."); // return True*/

/*        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True*/

        //System.out.println(findMiddleIndex(new int[]{1, 1, 1, 1}));
        //System.out.println(checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
        //System.out.println(countsubarraysOddProduct(new int[]{5, 1, 2, 3, 4}));
        //System.out.println(applyOperations(new int[]{1,2,2,1,1,0}));
        //System.out.println(distinctAverages(new int[]{9, 5, 7, 8, 7, 9, 8, 2, 0, 7}));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));

    }
    public String modifyString(String s) {
        if(s.length() == 1 && s.equals("?")) return "a";
        int len = s.length();
        while(s.contains("?")){
            int index = s.indexOf('?');
            if(index == 0 && index < len){
                char a = 'a';
                for(char i = 'a'; i <= 'z'; i++){
                    String s1 = i+"";
                    if(!String.valueOf(s.charAt(index+1)).equals(s1)){
                        s = s.replaceFirst("\\?", s1);
                        break;
                    }
                }
            }else if(index > 0 && index < len - 1){
                char a = 'a';
                for(char i = 'a'; i <= 'z'; i++){
                    String s1 = i+"";
                    if(!String.valueOf(s.charAt(index+1)).equals(s1) && !String.valueOf(s.charAt(index-1)).equals(s1)){
                        s = s.replaceFirst("\\?", s1);
                        break;
                    }
                }
            }else{
                char a = 'a';
                for(char i = 'a'; i <= 'z'; i++){
                    String s1 = i+"";
                    if(!String.valueOf(s.charAt(index-1)).equals(s1)){
                        s = s.replaceFirst("\\?", s1);
                        break;
                    }
                }

            }
        }
        return s;
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        int event1StartHH = Integer.parseInt(event1[0].split(":")[0]);
        int event1StartMM = Integer.parseInt(event1[0].split(":")[1]);
        int event1EndHH = Integer.parseInt(event1[1].split(":")[0]);
        int event1EndMM = Integer.parseInt(event1[1].split(":")[1]);

        int event2StartHH = Integer.parseInt(event2[0].split(":")[0]);
        int event2StartMM = Integer.parseInt(event2[0].split(":")[1]);
        int event2EndHH = Integer.parseInt(event2[1].split(":")[0]);
        int event2EndMM = Integer.parseInt(event2[1].split(":")[1]);

        if(event2StartHH > event1EndHH){
            return false;
        }else{
            if(event2StartHH == event1EndHH){
                if(event2StartMM > event1EndMM ){
                    return false;
                }else{
                    return true;
                }
            }else{
                if(event2StartHH < event1StartHH && event2EndHH <event1StartHH){
                    return false;
                }else if(event2StartHH == event1StartHH || event2EndHH == event1StartHH){
                    if(event2StartMM < event1StartMM && event2EndMM < event1StartMM){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() <= str2.length()) {
            StringBuilder sb = new StringBuilder("");
            int len = str1.length();
            int index = 0;
            while(true){
                if(index < len && !sb.toString().contains(str1.substring(index, index + 1))){
                    sb.append(str1.substring(index, index + 1));
                    index++;
                }else{
                    break;
                }
            }
            int newLen = sb.length();
            while(true){
                if(sb.toString().equals(str2.substring(0, newLen))){
                    return sb.toString();
                }else{
                    newLen--;
                    if(newLen == 0){
                        break;
                    }
                }

            }

            return "";

        }else{
            StringBuilder sb = new StringBuilder("");
            int len = str2.length();
            int index = 0;
            while(true){
                if(index < len && !sb.toString().contains(str2.substring(index, index + 1))){
                    sb.append(str2.substring(index, index + 1));
                    index++;
                }else{
                    break;
                }
            }
            int newLen = sb.length();
            while(true){
                if(sb.toString().equals(str1.substring(0, newLen))){
                    return sb.toString();
                }else{

                    if(newLen == 0){
                        break;
                    }
                    newLen--;
                }

            }

            return "";
        }

    }

    public String reformatNumber(String number) {
        number = number.replaceAll(" ", "").replaceAll("-", "");
        if (number.length() == 2 || number.length() == 3) {
            return number;
        }
        if (number.length() == 4) {
            return number.substring(0, 2) + "-" + number.substring(2);
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            if (number.length() > 4) {
                sb.append(number.substring(0, 3)).append("-");
                number = number.substring(3);
            } else if (number.length() == 4) {
                sb.append(number.substring(0, 2)).append("-").append(number.substring(2));
                break;
            } else {
                sb.append(number);
                break;
            }

        }
        return sb.toString();
    }

    public int minDeletionSize(String[] strs) {
        int count = 0;
        int len = strs.length;
        int wordLen = strs[0].length();
        char prevChar = 0;
        for (int i = 0; i < wordLen; i++) {
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    prevChar = strs[j].charAt(i);
                } else {
                    if (prevChar > strs[j].charAt(i)) {
                        count++;
                        break;
                    } else {
                        prevChar = strs[j].charAt(i);
                    }
                }
            }
        }
        return count;
    }

    public String tictactoe(int[][] moves) {
        System.out.println();
        int len = moves.length;
        if (len == 5) {
            return "A";
        }
        //[[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
        int[][] tictac = new int[3][3];
        int count = 0;
        for (int[] t : tictac) {
            if (count % 2 != 0) {
                tictac[t[0]][t[1]] = 10;
                count++;
            } else {
                count++;
            }
        }

        if (tictac[0][0] == 10 && tictac[0][1] == 10 && tictac[0][2] == 10) {
            return "B";
        } else if (tictac[1][0] == 10 && tictac[1][1] == 10 && tictac[1][2] == 10) {
            return "B";
        } else if (tictac[2][0] == 10 && tictac[2][1] == 10 && tictac[2][2] == 10) {
            return "B";
        } else if (tictac[0][0] == 10 && tictac[1][0] == 10 && tictac[2][0] == 10) {
            return "B";
        } else if (tictac[0][1] == 10 && tictac[1][1] == 10 && tictac[2][1] == 10) {
            return "B";
        } else if (tictac[0][2] == 10 && tictac[1][2] == 10 && tictac[2][2] == 10) {
            return "B";
        } else if (tictac[0][0] == 10 && tictac[1][1] == 10 && tictac[2][2] == 10) {
            return "B";
        } else if (tictac[0][2] == 10 && tictac[1][1] == 10 && tictac[2][0] == 10) {
            return "B";
        } else {
            return "DRAW";
        }


    }

    public boolean kLengthApart(int[] nums, int k) {

        int len = nums.length;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                l.add(i);
            }
        }

        int lenL = l.size();
        for (int i = 0; i < lenL - 1; i++) {
            if (!(l.get(i + 1) - l.get(i) >= k + 1)) {
                return false;
            }
        }
        return true;
    }

    public int averageValue(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().filter(x -> x % 2 == 0 && x % 6 == 0).collect(Collectors.toList());
        int len = l.size();
        if (len == 0) {
            return 0;
        }
        return l.stream().reduce(0, Integer::sum) / len;
    }

    public static int distinctAverages(int[] nums) {

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Double> set = new TreeSet<>();

        while (list.size() != 0) {
            list = list.stream().sorted().collect(Collectors.toList());
            int max = list.get(list.size() - 1);
            int min = list.get(0);
            list.remove(new Integer(max));
            list.remove(new Integer(min));

            double d = (double) (max + min) / 2;
            set.add(d);
        }

        return set.size();
    }

    public static int[] applyOperations(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
                i = i + 2;
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (i != 0) {
                list.add(i);
            }
        }

        int zeroCount = (int) Arrays.stream(nums).filter(x -> x == 0).count();
        while (zeroCount != 0) {
            list.add(0);
            zeroCount--;
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public static int countsubarraysOddProduct(int[] arr) {
        List<Integer> l = Arrays.stream(arr).boxed().filter(x -> x % 2 != 0).toList();
        int n = l.size();
        System.out.println(l);
        for (int i = 0; i < n; i++) {
            // Pick ending point
            for (int j = i; j < n; j++) {
                // Print subarray between current starting
                // and ending points
                for (int k = i; k <= j; k++)
                    System.out.print(l.get(k) + " ");
            }
            System.out.println();
        }
        return 0;
    }


    public static boolean checkXMatrix(int[][] grid) {
        int len = grid.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((i == j) || (i == len - 1 - j)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }

                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;

    }


    public static int findMiddleIndex(int[] nums) {
        int len = nums.length;

        if (len == 2) {
            if (nums[0] == 0) {
                return 1;
            } else if (nums[1] == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        int mid = (len - 1) / 2;

        while (true) {
            int left = 0;
            for (int i = 0; i < mid; i++) {
                left += nums[i];
            }

            int right = 0;
            for (int i = mid + 1; i < len; i++) {
                right += nums[i];
            }

            if (mid == 0 && right == 0) {
                return mid;
            }
            if (mid == len - 1 && left == 0) {
                return mid;
            }

            if (mid == 0 && right != left) {
                break;
            }
            if (mid == len - 1 && right != left) {
                break;
            }

            if (left > right) {
                mid = mid - 1;
            } else if (left < right) {
                mid = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public String rankTeams(String[] votes) {
        StringBuilder sb = new StringBuilder();
        int votesLen = votes.length;
        int partLen = votes[0].length();

        for (int i = 0; i < partLen; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (String vote : votes) {
                map.put(vote.charAt(i) + "", map.getOrDefault(vote.charAt(i) + "", 0) + 1);
            }
            int high = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .findFirst().get().getValue();

            Set<String> set = map.entrySet().stream().filter(x -> x.getValue() == high).
                    sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new)).keySet();

            for (String s : set) {
                if (!sb.toString().contains(s)) {
                    sb.append(s);
                    break;
                }
            }
        }
        return sb.toString();
    }


    public int countNicePairs1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int i = num - rev(num);

            if (map.containsKey(i)) {
                count += 1;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    //The condition can be rearranged to (nums[i] - rev(nums[i])) == (nums[j] - rev(nums[j])).
    //0 <= i < j < nums.length
    public int countNicePairs(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] - rev(nums[i])) == (nums[j] - rev(nums[j]))) {
                    count++;
                }
            }
        }
        return count;
    }

    private int rev(int n) {
        int reverse = 0;
        while (n != 0) {
            int remainder = n % 10;
            reverse = reverse * 10 + remainder;
            n = n / 10;
        }

        return reverse;
    }

    public String reorganizeString(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");

        for (String s1 : srr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        Set<String> set = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)).keySet();

        StringBuilder sb = new StringBuilder();
        while (map.size() > 0) {
            for (String se1 : set) {
                if (map.containsKey(se1)) {
                    sb.append(se1);
                    if (map.get(se1) == 1) {
                        map.remove(se1);
                    } else {
                        map.put(se1, map.get(se1) - 1);
                    }
                }
            }
        }

        if (checkString(sb.toString())) {
            return sb.toString();
        }
        return "";
    }

    private boolean checkString(String s) {
        int len = s.length();
        String[] srr = s.split("");
        for (int i = 0; i < len - 1; i++) {
            if (srr[i].equals(srr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public String bestHand(int[] ranks, char[] suits) {

        Map<Integer, Integer> ranksMap = new HashMap<>();
        Map<Character, Integer> suitsMap = new HashMap<>();

        for (int rank : ranks) {
            ranksMap.put(rank, ranksMap.getOrDefault(rank, 0) + 1);
        }

        for (char suit : suits) {
            suitsMap.put(suit, ranksMap.getOrDefault(suit, 0) + 1);
        }

        if (suitsMap.size() == 1) {
            return "Flush";
        } else {
            int val = ranksMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .findFirst().get().getValue();

            if (val >= 3) {
                return "Three of a Kind";
            } else if (val == 2) {
                return "Pair";
            } else {
                return "High Card";
            }
        }

    }

    public int mostFrequent(int[] nums, int key) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        return map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .findFirst().get().getKey();

    }

    public boolean makeEqual(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            String[] s1 = s.split("");
            for (String s2 : s1) {
                map.put(s2, map.getOrDefault(s2, 0) + 1);
            }
        }

        int len = words.length;

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() % len != 0) {
                return false;
            }
        }
        return true;
    }

    public ListNode mergeNodes(ListNode head) {
        LinkedList1 ll = new LinkedList1();
        int sum = 0;
        int zeroCount = 0;
        while (head.next != null) {
            if (zeroCount == 2) {
                ll = ll.insertAtEnd(ll, sum);
                zeroCount = 1;
                sum = 0 + head.val;
            } else if (head.val == 0) {
                zeroCount++;
            } else {
                sum += head.val;
            }

            head = head.next;
        }
        return ll.head;

    }

    public List<Boolean> camelMatch1(String[] queries, String pattern) {
        List<String> alpha = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        String[] arr = pattern.split("");
        int len = pattern.length();
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder(arr[0]);
        for (int i = 1; i < len; i++) {
            if (alpha.contains(arr[i])) {
                l.add(sb.toString());
                sb = new StringBuilder(arr[i]);
            } else {
                sb.append(arr[i]);
            }
        }
        l.add(sb.toString());
        List<Boolean> finalList = new ArrayList<>();

        for (String s : queries) {
            boolean flag = true;
            for (String s1 : l) {
                if (!s.contains(s1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                finalList.add(true);
            } else {
                finalList.add(false);
            }
        }

        return finalList;
    }

    public int specialArray(int[] nums) {
        int len = nums.length;

        for (int x = len; x >= 0; x--) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }
        System.out.println();
        return -1;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> l = new ArrayList<>();
        for (String query : queries) {
            query = query.replaceAll("[^a-z]", "");
            if (pattern.equals(query)) {
                l.add(true);
            } else {
                l.add(false);
            }
        }

        return l;
    }


    public int maxProduct(String[] words) {
        Arrays.sort(words, (x1, x2) -> x1.length() - x2.length());
        int len = words.length;

        return words[len - 1].length() * words[len - 2].length();

    }
}

class Bank {

    Map<Integer, Long> map;

    public Bank(long[] balance) {
        map = new HashMap<>();
        int len = balance.length;
        for (int i = 0; i < len; i++) {
            map.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {

        if (map.containsKey(account1) && map.containsKey(account2)) {
            if (account2 == account1) return true;
            long bal1 = map.get(account1);
            long bal2 = map.get(account2);
            if (bal1 >= money) {
                map.put(account1, bal1 - money);
                map.put(account2, bal2 + money);
                return true;
            }
        }

        return false;

    }

    public boolean deposit(int account, long money) {
        if (map.containsKey(account)) {
            map.put(account, map.get(account) + money);
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (map.containsKey(account)) {
            long mon = map.get(account);
            if (money <= mon) {
                map.put(account, mon - money);
                return true;
            }
        }

        return false;
    }
}


class LinkedList1 {

    ListNode head = null;

    public LinkedList1 insertAtEnd(LinkedList1 l, int data) {
        ListNode node = new ListNode();
        node.val = data;

        if (l.head == null) {
            l.head = node;
        } else {
            ListNode currNode = l.head;

            while (currNode.next != null) {
                currNode = currNode.next;
            }

            currNode.next = node;
        }

        return l;
    }


}

class WordDictionary {
    Map<String, Boolean> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        map.put(word, true);
    }

    public boolean search(String word) {

        String[] w = word.split("");
        int len = w.length;
        List<String> list = map.keySet().stream().filter(x -> x.length() == len).toList();
        for (String w1 : list) {
            boolean flag = true;
            if (w1.length() == w.length) {


                String[] w1Arr = w1.split("");
                for (int i = 0; i < len; i++) {
                    if (!w[i].equals(".")) {
                        if (!w[i].equals(w1Arr[i])) {
                            flag = false;
                            break;
                        }
                    }
                }
            } else {
                flag = false;
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }
}

class Trie {

    Map<String, Boolean> map;

    public Trie() {
        map = new HashMap<>();
    }

    public void insert(String word) {
        map.put(word, true);
    }

    public boolean search(String word) {
        return map.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        int len = prefix.length();
        List<String> l = map.keySet().stream().filter(x -> x.length() >= len).toList();

        for (String s : l) {
            if (prefix.equals(s.substring(0, len))) {
                return true;
            }
        }

        return false;
    }
}

