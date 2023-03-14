package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  10/03/23
 */
public class MainPracticeClass {

    public static void main(String[] args) {
        //System.out.println(passThePillow(4, 5));
        System.out.println(convertTime("02:30", "04:35"));
    }

    public int numRookCaptures(char[][] board) {
        int len = 8;
        int[] postionOfRock = null;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    postionOfRock = new int[]{i, j};
                    break;
                }
            }
        }

        int count = 0;

        for (int i = postionOfRock[1] + 1; i < 8; i++) {
            if (board[postionOfRock[0]][i] == '.') {
                continue;
            } else {
                if (board[postionOfRock[0]][i] == 'B') {
                    break;
                } else if(board[postionOfRock[0]][i] == 'p') {
                    count++;
                    break;
                }
            }
        }

        for (int i = postionOfRock[1] - 1; i >= 0 ; i--) {
            if (board[postionOfRock[0]][i] == '.') {
                continue;
            } else {
                if (board[postionOfRock[0]][i] == 'B') {
                    break;
                } else if(board[postionOfRock[0]][i] == 'p') {
                    count++;
                    break;
                }
            }
        }

        for (int i = postionOfRock[0] + 1; i < 8; i++) {
            if (board[i][postionOfRock[1]] == '.') {
                continue;
            } else {
                if (board[i][postionOfRock[1]] == 'B') {
                    break;
                } else if(board[i][postionOfRock[1]] == 'p') {
                    count++;
                    break;
                }
            }
        }

        for (int i = postionOfRock[0] - 1; i >= 0; i--) {
            if (board[i][postionOfRock[1]] == '.') {
                continue;
            } else {
                if (board[i][postionOfRock[1]] == 'B') {
                    break;
                } else if(board[i][postionOfRock[1]] == 'p') {
                    count++;
                    break;
                }
            }
        }


        return count;


    }

    public int vowelStrings(String[] words, int left, int right) {

        int count = 0;
        List<String> vowels = List.of("a", "e", "i", "o", "u");
        for (int i = left; i <= right; i++) {
            int len = words[i].length();
            if (vowels.contains(words[i].charAt(0) + "") && vowels.contains(words[i].charAt(len - 1) + "")) {
                count++;
            }
        }
        return count;
    }

    public static int convertTime(String current, String correct) {

        String[] currentTime = current.split(":");
        int currentTimeInMins = 0;
        currentTimeInMins = Integer.parseInt(currentTime[0]) * 60 + Integer.parseInt(currentTime[1]);
        String[] correctTime = correct.split(":");

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

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int x) {
        stack1.push(x);

    }

    public int pop() {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();

    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }
}
