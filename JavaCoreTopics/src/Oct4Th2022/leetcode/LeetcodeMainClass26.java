package Oct4Th2022.leetcode;

import java.util.*;
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

        removeDuplicates("pbbcggttciiippooaais", 2);
    }

    public int minDeletion(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int count = 0;
        for (int i : nums) {
            if (!s.isEmpty() && s.peek() == i) {
                s.pop();
                count++;
            } else {
                s.push(i);
            }
        }

        if (s.size() % 2 == 0) {
            return count;
        }

        return count + 1;
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
