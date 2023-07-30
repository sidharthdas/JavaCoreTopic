package Oct4Th2022.leetcode;

import java.util.Arrays;
import java.util.List;

public class Leetcode26MainClass {

    public static void main(String[] args) {
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        List<Integer> l = Arrays.stream(banned).boxed().toList();
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!l.contains(i)) {
                if (sum + i <= maxSum) {
                    sum += i;
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
