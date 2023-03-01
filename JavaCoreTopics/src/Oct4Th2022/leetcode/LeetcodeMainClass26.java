package Oct4Th2022.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  24/02/23
 */
public class LeetcodeMainClass26 {

    public static void main(String[] args) {
    /*students =
[1,1,0,0]
sandwiches =
[0,1,0,1]*/
        //System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
        //System.out.println(backspaceCompare("ab#c", "ad#c"));
        //System.out.println(maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        //s = "ab#c", t = "ad#c"

        /*Predicate<Integer> p =(a) -> a % 2 ==0;
        List<Integer> l = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println(listAsPerReq(p, l));*/

        //removeDuplicates("pbbcggttciiippooaais", 2);
        //System.out.println(minDeletion(new int[]{1,1,2,2,3,3}));
        System.out.println(minStoneSum(new int[]{5, 4, 9}, 2));

        //Convert list to Map and filter whose value is one
        /*List<String> items = Arrays.asList("apple ", "apple", "banana", "banana", "papaya");
        Map<String, Long> result = items.stream().
                collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(result);*/
        System.out.println(strongPasswordCheckerII(""));
    }

    public int maximumScore(int a, int b, int c) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 - a1);

        pq.add(a);
        pq.add(b);
        pq.add(c);

        while (true) {
            count++;
            int a1 = pq.poll() - 1;
            int a2 = pq.poll() - 1;
            int a3 = pq.poll();

            pq.add(a1);
            pq.add(a2);
            pq.add(a3);

            if (a1 == 0 && a2 == 0 ||
                    a2 == 0 && a3 == 0 ||
                    a1 == 0 && a3 == 0) {
                break;
            }
        }

        return count;
    }

    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        if(password.contains("\"")){
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        Set<String> s = Set.of("!", "@", "#", "<", "$", "%", "^", "&", "*", "(", ")", "-", "+");
        boolean flag = false;

        for (String s1 : s) {
            if (password.contains(s1)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return flag;
        }

        flag = false;

        for (char a = 'a'; a <= 'z'; a++) {
            if (password.contains(String.valueOf(a))) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return flag;
        }

        flag = false;

        for (char a = 'A'; a <= 'Z'; a++) {
            if (password.contains(String.valueOf(a))) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return flag;
        }

        String[] passwordArr = password.split("");
        int len = passwordArr.length;

        String prev = passwordArr[0];

        for (int i = 1; i < len; i++) {

            if (passwordArr[i].equals(prev)) {
                return false;
            }

            prev = passwordArr[i];
        }

        return true;
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> l = new ArrayList<>();
        int prev = nums[0];
        int len = nums.length;
        int curr = nums[0];
        for (int i = 1; i < len; i++) {
            if (curr + 1 == nums[i]) {
                curr = nums[i];
            } else {
                if (curr == prev) {
                    l.add(String.valueOf(curr));
                } else {
                    l.add(String.valueOf(prev) + "->" + String.valueOf(curr));
                }

                prev = nums[i];
                curr = nums[i];
            }
        }

        if (curr == prev) {
            l.add(String.valueOf(curr));
        } else {
            l.add(String.valueOf(prev) + "->" + String.valueOf(curr));
        }
        return l;
    }

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : piles) {
            pq.add(i);
        }
        while (k != 0) {
            pq.add((pq.poll() + 1) / 2);
            k--;
        }

        return pq.stream().reduce(Integer::sum).get();
    }

    public static int minDeletion(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int count = 0;
        for (int i : nums) {
            if (!s.isEmpty() && s.peek() == i) {
                count++;
            } else {
                s.push(i);
            }
        }

        if (s.size() % 2 == 0) {
            return count;
        }

        return count - 1;
    }

    public static String removeDuplicates(String s, int k) {
        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");
        Stack<String> stack = new Stack<>();
        for (String s1 : srr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
            if (map.get(s1) == k) {
                int temp = k - 1;
                while (temp != 0) {
                    stack.pop();
                    temp--;
                }
            } else {
                stack.push(s1);
            }
        }
        String fs = "";
        while (!stack.isEmpty()) {
            fs = stack.pop() + fs;
        }
        return fs;
    }

    public static List<Integer> listAsPerReq(Predicate<Integer> p, List<Integer> l) {
        List<Integer> l1 = new ArrayList<>();

        l.forEach(x -> {
            if (p.test(x)) {
                l1.add(x);
            }
        });

        return l1;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int slen = s.length;
        int count = 0;
        int len = g.length;
        for (int i = slen - 1; i >= 0; i--) {

            for (int j = len - 1; j >= 0; j--) {

                if (g[j] != -1 && s[i] >= g[j]) {
                    count++;
                    g[j] = -1;
                    break;
                }
            }
        }
        return count;
    }

    public String removeStars(String s) {
        String[] srr = s.split("");
        Stack<String> stack = new Stack<>();
        for (String s1 : srr) {
            if (s1.equals("*")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s1);
            }
        }

        String fS = "";
        while (!stack.isEmpty()) {
            fS = stack.pop() + fS;
        }

        return fS;
    }

    public static int maxCoins(int[] piles) {
        int count = 0;
        List<Integer> list = Arrays.stream(piles).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        while (list.size() != 0) {
            list.remove(0);
            count += list.remove(0);
            list.remove(list.size() - 1);
        }
        return count;
    }

    public int minAddToMakeValid(String s) {

        Stack stack = new Stack();
        String[] srr = s.split("");
        int count = 0;
        for (String s1 : srr) {
            if (s1.equals("(")) {
                stack.push(s1);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty() ? count : stack.size() + count;
    }

    public static boolean backspaceCompare1(String s, String t) {
        Stack stack = new Stack();
        Stack ttack = new Stack();
        String[] srr = s.split("");
        String[] trr = t.split("");
        int lenS = s.length();
        int lenT = t.length();

        for (int i = 0; i < lenS; i++) {
            if (!srr[i].equals("#")) {
                stack.push(srr[i]);
            } else {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }

        for (int i = 0; i < lenT; i++) {
            if (!trr[i].equals("#")) {
                ttack.push(trr[i]);
            } else {
                if (!ttack.isEmpty())
                    ttack.pop();
            }
        }

        StringBuffer sb = new StringBuffer("");
        StringBuffer tb = new StringBuffer("");

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        while (!ttack.isEmpty()) {
            tb.append(ttack.pop());
        }

        return sb.toString().equals(tb.toString());
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack stack = new Stack();
        Stack ttack = new Stack();
        String[] srr = s.split("");
        String[] trr = t.split("");
        int lenS = s.length();
        int lenT = t.length();

        for (int i = 0; i < lenS; i++) {
            if (!srr[i].equals("#")) {
                stack.push(srr[i]);
            } else {
                stack.pop();
            }
        }

        for (int i = 0; i < lenT; i++) {
            if (!trr[i].equals("#")) {
                ttack.push(trr[i]);
            } else {
                ttack.pop();
            }
        }

        StringBuffer sb = new StringBuffer("");
        StringBuffer tb = new StringBuffer("");

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        while (!ttack.isEmpty()) {
            tb.append(ttack.pop());
        }

        return sb.toString().equals(tb.toString());
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        for (int i : students) {
            studentsQueue.add(i);
        }
        Queue<Integer> sandwichesQueue = new LinkedList<>();
        for (int i : sandwiches) {
            sandwichesQueue.add(i);
        }
        while ((!((count(students, 1) != 0 && count(sandwiches, 1) == 0) ||
                (count(students, 0) != 0 && count(sandwiches, 0) == 0)))
                || !sandwichesQueue.isEmpty()) {
            if (studentsQueue.peek() == sandwichesQueue.peek()) {
                studentsQueue.poll();
                sandwichesQueue.poll();
            } else {
                studentsQueue.add(studentsQueue.poll());
            }

            if (sandwichesQueue.isEmpty()) {
                break;
            }
            if (count2(studentsQueue, sandwichesQueue.peek()) == 0) {
                break;
            }
        }
        return studentsQueue.size();
    }

    private static int count2(Queue<Integer> q, int i) {
        return (int) q.stream().filter(x -> x == i).count();
    }

    private static int count(int[] arr, int i) {
        return (int) Arrays.stream(arr).boxed().filter(x -> x == i).count();
    }
}
