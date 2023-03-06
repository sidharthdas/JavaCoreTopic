package Oct4Th2022.leetcode;

import java.math.BigInteger;
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
        //System.out.println(minStoneSum(new int[]{5, 4, 9}, 2));

        //Convert list to Map and filter whose value is one
        /*List<String> items = Arrays.asList("apple ", "apple", "banana", "banana", "papaya");
        Map<String, Long> result = items.stream().
                collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(result);*/
        //System.out.println(strongPasswordCheckerII(""));
        //ushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        //System.out.println(validateStackSequences(new int[]{2,1,0}, new int[]{1,2,0}));
        //System.out.println(clumsy(10));
        //System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        //System.out.println(trailingZeroes(30));
        //System.out.println(validateStackSequences1(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
        //System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        //System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(leftRigthDifference(new int[]{10, 4, 8, 3}));

    }

    public ListNode removeNodes(ListNode head) {

        List<Integer> l = new ArrayList<>();

        while (head != null) {
            l.add(head.val);
            head = head.next;
        }

        int len = l.size();
        int max = Integer.MIN_VALUE;

        List<Integer> l1 = new ArrayList<>();

        for (int i = len - 1; i >= 0; i--) {
            if (max < l.get(i)) {
                max = l.get(i);
                l1.add(0, max);
            } else {
                l.remove(l.get(i));
            }
        }

        ListNode node = new ListNode();
        node.val = l1.get(0);
        ListNode currNode = node;

        int newLen = l1.size();

        for (int i = 1; i < newLen; i++) {
            ListNode n = new ListNode();
            n.val = l1.get(i);
            currNode.next = n;
            currNode = n;
        }
        return node;
    }

    public static int[] leftRigthDifference(int[] nums) {
        int len = nums.length;
        int leftSum = 0;
        int rightSum = 0;

        int[] finalArr = new int[len];
//|0 - 15|
        for (int i = 0; i < len; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            for (int j = i + 1; j < len; j++) {
                rightSum += nums[j];
            }

            finalArr[i] = Math.abs(rightSum - leftSum);
        }
        return finalArr;
    }

    public static boolean validateStackSequences11(int[] pushed, int[] popped) {

        int pushLen = pushed.length;
        int popLen = popped.length;
        Stack<Integer> stackPop = new Stack<>();
        for (int i = 0; i < popLen; i++) {
            stackPop.push(popped[i]);
        }

        int currPoppedIndex = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushLen; i++) {
            stack.push(pushed[i]);
            if (stack.peek() == stackPop.peek()) {
                stack.pop();
                stackPop.pop();
            }
        }
        while (!stack.isEmpty()) {

            if (stack.pop() != stackPop.pop()) {
                return false;
            }

        }
        return stack.isEmpty() && stackPop.isEmpty();

    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(nums[k]);
                }
                l.add(list);
            }
        }
        return l.stream().filter(x -> x.size() == len).toList();
    }

    public boolean isIsomorphic1(String s, String t) {
        Map<String, String> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }
        String[] rr1 = s.split("");
        String[] rr2 = t.split("");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(rr1[i])) {
                if (!map.get(rr1[i]).equals(rr2[i])) {
                    return false;
                }
            } else {
                if (map.values().contains(rr2[i])) {
                    return false;
                } else {
                    map.put(rr1[i], rr2[i]);
                }
            }
        }

        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map1 = convertToMap(s);
        Map<String, Integer> map2 = convertToMap(t);
        List<String> l1 = getL(s);
        List<String> l2 = getL(t);

        String s1 = r(l1);
        String s2 = r(l2);

        return s1.equals(s2) && compareSequence(map1, map2);

    }

    public static boolean compareSequence(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        List<Integer> l1 = map1.values().stream().toList();
        List<Integer> l2 = map2.values().stream().toList();
        int len = l1.size();
        for (int i = 0; i < len; i++) {
            if (l1.get(i) != l2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private static Map<String, Integer> convertToMap(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String srr[] = s.split("");
        for (String s1 : srr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        return map;
    }

    private static String r(List<String> l) {
        String s3 = "";
        for (String s : l) {
            String[] srr = s.split("-");
            s3 += srr[1];
        }
        return s3;
    }

    private static List<String> getL(String s1) {
        String[] srr = s1.split("");
        String c = srr[0];
        int count = 1;
        int len = s1.length();
        List<String> l = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (c.equals(srr[i])) {
                count += 1;
            } else {
                l.add(c + "-" + count);
                c = srr[i];
                count = 1;
            }
        }
        l.add(c + "-" + count);
        return l;
    }

    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < len; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += nums[j];

            }

            for (int k = i + 1; k < len; k++) {
                sumRight += nums[k];
            }

            if (sumLeft == sumRight) {
                return i;
            }
        }

        return -1;
    }


    public static boolean validateStackSequences1(int[] pushed, int[] popped) {

        int pushLen = pushed.length;
        int popLen = popped.length;
        Stack<Integer> stackPop = new Stack<>();
        for (int i = popLen - 1; i >= 0; i--) {
            stackPop.push(popped[i]);
        }

        int currPoppedIndex = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = pushLen - 1; i >= 0; i--) {
            stack.push(pushed[i]);
            if (stack.peek() == stackPop.peek()) {
                stack.pop();
                stackPop.pop();
            }
        }

        while (!stack.isEmpty()) {

            if (stack.pop() != stackPop.pop()) {
                return false;
            }

        }

        return stack.isEmpty() && stackPop.isEmpty();

    }

/*    public static  int trailingZeroes(int n) {
        BigInteger mul = new BigInteger(String.valueOf(2));
        int count = 0;
        for(int i = 3; i <= n; i++){
            mul = mul.multiply(new BigInteger(String.valueOf(i)));
        }

        while(mul.equals(0)){
            long remainder = mul % 10;
            if(remainder == 0){
                count++;
            }else{
                break;
            }
            mul = mul/10;
        }

        return count;
    }*/

    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                for (int k1 = i; k <= j; k++) {
                    sum += nums[k1];
                    System.out.print(nums[k1] + " ");
                }
                System.out.println();
            }
        }
        return count;
    }

    public static int clumsy(int n) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(n));
        int count = 1;
        for (int i = n - 1; i >= 1; i--) {
            if (count == 1) {
                list.add("*");
                list.add(String.valueOf(i));
                count++;

            } else if (count == 2) {
                list.add("/");
                list.add(String.valueOf(i));
                count++;

            } else if (count == 3) {
                list.add("+");
                list.add(String.valueOf(i));
                count++;

            } else if (count == 4) {
                list.add("-");
                list.add(String.valueOf(i));
                count = 1;

            }

        }
        System.out.println(list);

        while (true) {
            //divide
            int len = list.size();
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (list.get(i).equals("/")) {
                    String t = String.valueOf(Integer.parseInt(list.get(i - 1)) / Integer.parseInt(list.get(i + 1)));
                    temp.remove(temp.size() - 1);
                    temp.add(t);
                    i++;
                } else {
                    temp.add(list.get(i));
                }

            }

            if (temp.size() == 1) {
                return Integer.parseInt(temp.get(0));
            }


            //multiply
            len = temp.size();
            List<String> temp1 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (temp.get(i).equals("*")) {
                    String t = String.valueOf(Integer.parseInt(temp.get(i - 1)) / Integer.parseInt(temp.get(i + 1)));
                    temp1.remove(temp1.size() - 1);
                    temp1.add(t);

                    i++;
                } else {
                    temp1.add(temp.get(i));
                }

            }

            if (temp1.size() == 1) {
                return Integer.parseInt(temp1.get(0));
            }

            //add
            len = temp1.size();
            List<String> temp2 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (temp1.get(i).equals("+")) {
                    String t = String.valueOf(Integer.parseInt(temp1.get(i - 1)) / Integer.parseInt(temp1.get(i + 1)));
                    temp2.add(t);
                    temp2.remove(temp2.size() - 1);
                    i++;
                } else {
                    temp2.add(temp1.get(i));
                }

            }

            if (temp2.size() == 1) {
                return Integer.parseInt(temp2.get(0));
            }

            //sub
            len = temp2.size();
            List<String> temp3 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (temp2.get(i).equals("-")) {
                    String t = String.valueOf(Integer.parseInt(temp2.get(i - 1)) / Integer.parseInt(temp2.get(i + 1)));
                    temp3.add(t);
                    temp3.remove(temp2.size() - 1);
                    i++;
                } else {
                    temp3.add(temp3.get(i));
                }

            }

            if (temp3.size() == 1) {
                return Integer.parseInt(temp3.get(0));
            }

            list = temp3;
        }
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        int pushLen = pushed.length;
        int popLen = popped.length;

        int currPoppedIndex = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushLen; i++) {
            stack.push(pushed[i]);
            if (stack.peek() == popped[currPoppedIndex]) {
                stack.pop();
                currPoppedIndex++;
            }
        }

        for (int i = currPoppedIndex; i < popLen; i++) {
            if (stack.pop() != popped[i]) {
                return false;
            }

        }

        return stack.isEmpty();

    }

    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        String srr[] = s.split("");
        int count = 0;
        for (String s1 : srr) {
            if (s1.equals("(")) {
                stack.push(s1);
            } else {
                stack.pop();
                count++;
            }
        }

        return count;
    }


    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String operations = "+-*/";
        for (String token : tokens) {
            if (operations.contains(token)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = 0;
                if (token.equals("*")) {
                    c = b * a;
                } else if (token.equals("+")) {
                    c = b + a;
                } else if (token.equals("-")) {
                    c = b - a;
                } else if (token.equals("/")) {
                    c = b / a;

                }

                stack.push(String.valueOf(c));

            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int val = curr.val;
            curr.val = curr.next.val;
            curr.next.val = val;

            curr = curr.next.next;
        }

        return head;

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

            if (a1 == 0 && a2 == 0 || a2 == 0 && a3 == 0 || a1 == 0 && a3 == 0) {
                break;
            }
        }

        return count;
    }

    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (password.contains("\"")) {
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
        flag = false;
        for (int a = 0; a <= 9; a++) {
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

    public String removeDuplicates(String s, int k) {

        String str[] = s.split("");
        Stack<String> stack = new Stack<>();

        int currIndex = 0;
        while (check(stack, k)) {
            String s1 = "";
            while (!stack.isEmpty()) {
                s1 = stack.pop() + s1;
            }
            String[] arr = s1.split("");
            int len = arr.length;
            int count = 0;

            for (int i = 0; i < len; i++) {
                if (stack.isEmpty()) {
                    stack.push(arr[i]);
                    count++;
                } else if (stack.peek().equals(arr[i])) {
                    if (count == k - 1) {
                        while (count != 0) {
                            stack.pop();
                            count--;
                        }
                    } else {
                        stack.push(arr[i]);
                        count++;
                    }
                } else {
                    count = 1;
                    stack.push(arr[i]);
                }
            }

        }

        String s1 = "";
        while (!stack.isEmpty()) {
            s1 = stack.pop() + s1;
        }

        return s1;

    }

    public boolean check(Stack<String> stack, int k) {
        if (stack.isEmpty()) return true;

        int count = 0;
        String peek = stack.peek();

        while (!stack.isEmpty()) {
            if (stack.peek().equals(peek)) {
                stack.pop();
                count++;
                if (count == k) {
                    return true;
                }
            } else {
                peek = stack.peek();
                stack.pop();
                count = 1;
            }
        }
        return false;
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
                if (!stack.isEmpty()) stack.pop();
            }
        }

        for (int i = 0; i < lenT; i++) {
            if (!trr[i].equals("#")) {
                ttack.push(trr[i]);
            } else {
                if (!ttack.isEmpty()) ttack.pop();
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
        while ((!((count(students, 1) != 0 && count(sandwiches, 1) == 0) || (count(students, 0) != 0 && count(sandwiches, 0) == 0))) || !sandwichesQueue.isEmpty()) {
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


class StockSpanner {

    List<Integer> l;
    int currIndex;

    public StockSpanner() {
        l = new ArrayList<>();
        currIndex = 0;
    }

    public int next(int price) {
        if (currIndex == 0) {
            l.add(currIndex, price);
            currIndex++;
            return 1;
        } else {

            l.add(currIndex, price);
            int count = 0;
            for (int i = currIndex; i >= 0; i--) {
                if (l.get(i) <= price) {
                    count++;
                } else {
                    break;
                }
            }
            currIndex++;
            return count;

        }

    }
}
