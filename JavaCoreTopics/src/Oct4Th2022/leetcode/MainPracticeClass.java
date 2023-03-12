package Oct4Th2022.leetcode;

import java.util.ArrayList;
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

    public int convertTime(String current, String correct) {

        String[] currentTime = current.split(":");
        int currentTimeInMins = 0;
        currentTimeInMins = Integer.parseInt(currentTime[0]) * 60 + Integer.parseInt(currentTime[1]);
        String[] correctTime = current.split(":");
        int correctTimeInMins = Integer.parseInt(correctTime[0]) * 60 + Integer.parseInt(correctTime[1]);

        int count = 0;

        while (currentTimeInMins != correctTimeInMins) {
            if (currentTimeInMins + 60 <= correctTimeInMins) {
                count++;
                currentTimeInMins += 60;
                if (currentTimeInMins == correctTimeInMins) {
                    return count;
                }
            } else if (currentTimeInMins + 15 <= correctTimeInMins) {
                count++;
                currentTimeInMins += 15;
                if (currentTimeInMins == correctTimeInMins) {
                    return count;
                }
            } else if (currentTimeInMins + 5 <= correctTimeInMins) {
                count++;
                currentTimeInMins += 5;
                if (currentTimeInMins == correctTimeInMins) {
                    return count;
                }
            } else if (currentTimeInMins + 1 <= correctTimeInMins) {
                count++;
                currentTimeInMins += 1;
                if (currentTimeInMins == correctTimeInMins) {
                    return count;
                }
            }
        }

        return count;
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        int len = nums.length;
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (Math.abs(i - j) <= k && nums[j] == key) {
                    l.add(i);
                }
            }
        }

        return l.stream().sorted().collect(Collectors.toSet()).stream().sorted().toList();
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
