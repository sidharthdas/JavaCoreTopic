package Oct4Th2022.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
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
            if(count(students, sandwichesQueue.peek()) == 0){
                break;
            }
        }
        return studentsQueue.size();
    }

    private static int count(int[] arr, int i) {
        return (int) Arrays.stream(arr).boxed().filter(x -> x == i).count();
    }
}
