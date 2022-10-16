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
        Random rand = new Random();
        rand.nextInt(2);
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
        while(s.length() != 0) {
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

    private String replaceChar(String mainWord, String tobeReplaced){
        String arr[] = tobeReplaced.split("");
        for(String s : arr){
            mainWord = mainWord.replaceFirst(s,"");
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
