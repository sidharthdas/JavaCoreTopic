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
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");
        wordDictionary.search("a"); // return False
        wordDictionary.search("a."); // return True
        wordDictionary.search("ab"); // return True
        wordDictionary.search(".a"); // return True
        wordDictionary.search(".b"); // return True
        wordDictionary.search("ab."); // return True
        wordDictionary.search("."); // return True
        wordDictionary.search(".."); // return True

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
            }else{
                flag = false;
            }

            if(flag){
                return true;
            }
        }
        return false;
    }
}

