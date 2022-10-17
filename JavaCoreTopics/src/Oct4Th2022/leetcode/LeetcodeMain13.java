package Oct4Th2022.leetcode;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  14/10/22
 */


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LeetcodeMain13 {

    public static void main(String[] args) {
        //findMin(new int[]{1,2,3,45});
        /*Random rand = new Random();
        rand.nextInt(2);
        wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));*/
        System.out.println(numberOfSteps(14));
    }

    public int findNthDigit(int n) {
        StringBuilder s = new StringBuilder("");

        for(int i = 1; i <=n; i++){
            s.append(i);
        }

        return Integer.valueOf(s.charAt(n-1));
    }
    /*public int guessNumber(int n) {
        int first = 1;
        int last = n;

        while(first <= last){
            int mid = first  + (last - first) / 2;
            if(guess(mid) == 1){
                first = mid + 1;
            }else if(guess(mid) == -1){
                last = mid - 1;
            }
            else{
                return mid;
            }
        }
        return 1;
    }*/

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1 && strs[0].equals("")) {
            return "";
        }

        String s = strs[0];
        int len = strs.length;
        String pref = "";
        int count = 1;
        while (true) {
            if (s.length() > count) {
                break;
            }
            for (String s1 : strs) {
                if (!s1.substring(0, count).equals(s.substring(0, count))) {
                    return pref;
                }
            }

            pref = s.substring(0, count);
            count++;
        }
        return pref;
    }

    public static int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 2 == 0) {
            return numberOfSteps(num / 2) + 1;
        } else {
            return numberOfSteps(num - 1) + 1;
        }
    }


    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder("");

        while (head != null) {
            sb.append(head.val);
        }

       /* String s1 = sb.toString();
        String s2 = sb.t*/

        return sb.toString().equals(sb.reverse().toString());
    }

    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;

        while (first < last) {
            int mid = (first + (last - first)) / 2;

            if (isBadVersion(mid)) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }

        return first;

    }

    private boolean isBadVersion(int mid) {
        return true;
    }


    public boolean isSubsequence(String s, String t) {

        String[] srr = s.split("");
        int prevIndex = -1;
        int flag = 0;

        for (String s1 : srr) {
            if (flag == 0) {
                prevIndex = t.indexOf(s1);
                flag = 1;
            } else {
                int currIndex = t.lastIndexOf(s1);
                if (prevIndex < currIndex) {
                    prevIndex = currIndex;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    /*public int guessNumber(int n) {
        n = n/2;
        while (true) {
            int i = guess(n);
            if(i == -1){
                n = n -1;
            }else if(i == 1){
                n = n+1;
            }else{
                break;
            }
        }
        return n;

    }
*/
    public static String removeDuplicateLetters(String s) {
        String srr[] = s.split("");

        for (String s1 : srr) {
            if (s.indexOf(s1) != s.lastIndexOf(s1)) {
                s = s.replaceFirst(s1, "");
            }
        }
        return s;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean flag = true;
        for (String s1 : wordDict) {
            if (!s.contains(s1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public int triangleNumber(int[] nums) {
        int len = nums.length;
        int count = 0;

        for (int i = 0; i < len; i++) {

            // Fix the second element as A[j]
            for (int j = 0; j < len; j++) {

                // Now look for the third number
                for (int k = 0; k < len; k++) {

                    if (i != j && j != k && i != k) {
                        if (nums[i] + nums[j] > nums[k]) {
                            count++;
                        }
                    }

                }

            }
        }
        return count;
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (head != null) {
            pq.add(head.val);
            head = head.next;
        }
        ListNode head1 = new ListNode();
        head1.val = pq.poll();
        head1.next = null;

        while (!pq.isEmpty()) {
            head1 = insertAtEnd(head1, pq.poll());
        }
        return head1;
    }

    public ListNode insertAtEnd(ListNode l, int data) {
        ListNode node = new ListNode();
        node.val = data;

        if (l == null) {
            l = node;
        } else {
            ListNode currNode = l;

            while (currNode.next != null) {
                currNode = currNode.next;
            }

            currNode.next = node;
        }

        return l;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> l = Arrays.stream(nums2).boxed().toList();
        int[] finalNum = new int[nums1.length];
        int counter = 0;
        int len = nums2.length;
        for (int num : nums1) {
            boolean flag = true;
            int indexOfI = l.indexOf(num);
            for (int i = indexOfI + 1; i < len; i++) {
                if (l.get(i) > num) {
                    flag = false;
                    finalNum[counter] = l.get(i);
                    counter++;
                    break;
                }
            }

            if (flag) {
                finalNum[counter] = -1;
                counter++;
            }

            flag = true;

        }

        return finalNum;

    }

    public String originalDigits(String s) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        String mainString = "";
        while (s.length() != 0) {
            for (Map.Entry<String, String> m : map.entrySet()) {
                boolean flag = true;
                String s1[] = m.getKey().split("");
                for (String s3 : s1) {
                    if (!s.contains(s3)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    s = replaceChar(s, m.getKey());
                    mainString += m.getValue();
                }

                flag = true;


            }
        }
        return mainString;
    }

    private String replaceChar(String mainWord, String tobeReplaced) {
        String arr[] = tobeReplaced.split("");
        for (String s : arr) {
            mainWord = mainWord.replaceFirst(s, "");
        }

        return mainWord;
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        String[] srr = s.split("");
        List<Integer> l = new ArrayList<>();
        boolean flag = true;
        for (String s1 : srr) {
            if (s.indexOf(s1) != s.lastIndexOf(s1)) {
                l.add(s.lastIndexOf(s1) - s.indexOf(s1));
                flag = false;
            }
        }

        if (flag) {
            return -1;
        }

        Collections.sort(l, Collections.reverseOrder());

        return l.get(0) - 1;

    }

    public static int isprime(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return 0;
        }

        return 1;
    }

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int i = nums.length;

        return nums[i - 1] - nums[i - 2];

    }

    public List<Integer> primeFactors(int n) {

        for (int i = 2; i <= n; i++) {
            if (isprime(i) == 1) {
                int x = n;
                while (x % i == 0) {
                    System.out.print(i + " ");
                    x /= i;
                }
            }
        }
        return null;
    }

    class FindElements {

        TreeNode root;

        public FindElements(TreeNode root) {
            this.root = root;
        }

        public boolean find(int target) {
            if (root == null) {
                return false;
            }
            boolean flag = false;
            while (root != null) {
                if (target < root.val) {
                    root = root.left;
                } else if (target > root.val) {
                    root = root.right;
                } else {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
    }

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();

        map.entrySet().forEach(x -> {
            if (x.getValue() > len / 3) {
                l.add(x.getKey());
            }
        });
        return l;
    }

    public boolean search1(int[] nums, int target) {
        List<Integer> l = Arrays.stream(nums).boxed().toList();
        return l.contains(target);

    }

    public int search(int[] nums, int target) {
        List<Integer> l = Arrays.stream(nums).boxed().toList();
        if (!l.contains(target)) return -1;
        return l.indexOf(target);

    }

    public static int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];

    }

    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode n = head;
        ListNode node = head;

        while (node != null) {
            count++;
            node = node.next;
        }

        int middleIndex = count / 2;
        while (middleIndex-- > 1) {
            head = head.next;
        }
        head.next = head.next.next;
        return n;
    }

}
