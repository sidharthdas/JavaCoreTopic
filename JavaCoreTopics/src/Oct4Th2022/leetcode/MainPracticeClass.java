package Oct4Th2022.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  10/03/23
 */
public class MainPracticeClass {

    public static void main(String[] args) {
        System.out.println(passThePillow(4, 5));
    }

    public static int passThePillow(int n, int time) {
        int start = 1;
        int direction = 0; //left -> right, direction = 1 right -> left

        while (time != 0) {
            if (direction == 0) {
                if (start == n) {
                    direction = 1;
                    start--;
                    time--;
                } else {
                    start++;
                    time--;
                }
            } else {
                if (start == 1) {
                    direction = 0;
                    start++;
                    time--;
                } else {
                    start--;
                    time--;
                }
            }
        }
        return start;
    }

    public int deleteAndEarn(int[] nums) {

        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int earn = 0;
        while (l.size() != 0) {
            int max = l.stream().max((x, y) -> y - x).get();
            earn += max;
            l.remove(new Integer(max));
            l.removeIf(x -> x == max - 1 || x == max + 1);
        }

        return earn;
    }
}
