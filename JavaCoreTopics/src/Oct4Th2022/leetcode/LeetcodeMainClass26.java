package Oct4Th2022.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        System.out.println(backspaceCompare("ab#c","ad#c"));
        //s = "ab#c", t = "ad#c"
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack stack = new Stack();
        Stack ttack = new Stack();
        String[] srr = s.split("");
        String[] trr = t.split("");
        int lenS = s.length();
        int lenT = t.length();

        for(int i = 0; i< lenS; i++){
            if(srr[i].equals("#")){
                stack.push(srr[i]);
            } else {
                stack.pop();
            }
        }

        for(int i = 0; i< lenT; i++){
            if(trr[i].equals("#")){
                ttack.push(trr[i]);
            } else {
                ttack.pop();
            }
        }

        StringBuffer sb = new StringBuffer("");
        StringBuffer tb = new StringBuffer("");

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        while(!ttack.isEmpty()){
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

            if(sandwichesQueue.isEmpty()){
                break;
            }
            if(count2(studentsQueue, sandwichesQueue.peek()) == 0){
                break;
            }
        }
        return studentsQueue.size();
    }

    private static int  count2 (Queue<Integer> q, int i){
        return (int)q.stream().filter(x ->x ==i).count();
    }

    private static int count(int[] arr, int i) {
        return (int) Arrays.stream(arr).boxed().filter(x -> x == i).count();
    }
}
