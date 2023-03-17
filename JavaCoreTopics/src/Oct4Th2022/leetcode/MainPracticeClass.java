package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  10/03/23
 */
public class MainPracticeClass {

    public static void main(String[] args) {
        //System.out.println(passThePillow(4, 5));
        //System.out.println(convertTime("02:30", "04:35"));
        //System.out.println(getRow(3));
        System.out.println(removeDigit("551", '5'));
    }

    public String maximumTime(String time) {
        String[] arr = new String[4];
        arr[0] = String.valueOf(time.charAt(0));
        arr[1] = String.valueOf(time.charAt(1));
        arr[2] = String.valueOf(time.charAt(3));
        arr[3] = String.valueOf(time.charAt(4));

        if (arr[0].equals("?")) {
            if (arr[1].equals("?")) {
                arr[0] = "2";
                arr[1] = "3";
            } else if (arr[1].equals("0") || arr[1].equals("1") || arr[1].equals("2") || arr[1].equals("3")) {
                arr[0] = "2";
            } else {
                arr[0] = "1";
            }
        }

        if (arr[1].equals("?")) {
            if (arr[0].equals("0") || arr[0].equals("1")) {
                arr[1] = "9";
            } else if (arr[0].equals("2")) {
                arr[1] = "3";
            }
        }

        if (arr[2].equals("?")) {
            arr[2] = "5";
        }

        if (arr[3].equals("?")) {
            arr[3] = "9";
        }

        return arr[0] + arr[1] + ":" + arr[2] + arr[3];

    }

    public static String removeDigit(String number, char digit) {

        int len = number.length();
        int currIndex = 0;

        String temp = number;

        List<Integer> l = new ArrayList<>();

        while (currIndex != len) {
            for (int i = currIndex; i < len; i++) {
                if (number.charAt(i) == digit) {
                    currIndex = i + 1;
                    l.add(Integer.parseInt(number.substring(0, i) + number.substring(i + 1)));
                    break;
                } else if (i == len - 1) {
                    currIndex = i + 1;
                    break;
                }
            }
        }

        return String.valueOf(l.stream().sorted(Comparator.reverseOrder()).findFirst().get());
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        Map<Integer, Integer> map = Map.ofEntries(
                //31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
                Map.entry(1, 31),
                Map.entry(2, 28),
                Map.entry(3, 31),
                Map.entry(4, 30),
                Map.entry(5, 31),
                Map.entry(6, 30),
                Map.entry(7, 31),
                Map.entry(8, 31),
                Map.entry(9, 30),
                Map.entry(10, 31),
                Map.entry(11, 30),
                Map.entry(12, 31)
        );
        String[] arriveAliceArr = arriveAlice.split("");
        int aliceMonthArrival = Integer.parseInt(arriveAliceArr[0]);
        int aliceDayArrival = Integer.parseInt(arriveAliceArr[1]);

        String[] leaveAliceArr = leaveAlice.split("");
        int aliceMonthLeave = Integer.parseInt(leaveAliceArr[0]);
        int aliceDayLeave = Integer.parseInt(leaveAliceArr[1]);

        String[] arriveBobArr = arriveBob.split("");
        int bobMonthArrival = Integer.parseInt(arriveBobArr[0]);
        int bobDayArrival = Integer.parseInt(arriveBobArr[1]);

        String[] leaveBobArr = leaveBob.split("");
        int bobMonthLeave = Integer.parseInt(leaveBobArr[0]);
        int bobDayLeave = Integer.parseInt(leaveBobArr[1]);

        return 0;

    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] i : nums1) {
            map.put(i[0], i[1]);
        }

        for (int[] i : nums2) {
            map.put(i[0], map.getOrDefault(i[0], 0) + i[1]);
        }

        map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey()).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
        ));

        int size = map.size();
        int[][] finalAns = new int[size][2];
        int curr = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            finalAns[curr][0] = m.getKey();
            finalAns[curr][1] = m.getValue();
            curr++;
        }

        return finalAns;
    }

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>();
        }
        if (rowIndex == 1) {
            return List.of(1);
        }
        if (rowIndex == 2) {
            return List.of(1, 1);
        }

        rowIndex += 1;
        List<List<Integer>> l = new ArrayList<>();
        l.add(List.of(1));
        l.add(List.of(1, 1));

        rowIndex = rowIndex - 2;
        int currIndex = 1;

        while (rowIndex != 0) {
            List<Integer> temp = l.get(currIndex);
            List<Integer> listToBeAdded = new ArrayList<>();
            listToBeAdded.add(1);
            int len = temp.size();

            for (int i = 0; i < len - 1; i++) {
                listToBeAdded.add(temp.get(i) + temp.get(i + 1));
            }

            listToBeAdded.add(1);
            l.add(listToBeAdded);
            currIndex++;
            rowIndex--;
        }

        int size = l.size();

        return l.get(size - 1);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        if (numRows == 1) {
            return List.of(List.of(1));
        }
        if (numRows == 2) {
            return List.of(List.of(1), List.of(1, 1));
        }

        List<List<Integer>> l = new ArrayList<>();
        l.add(List.of(1));
        l.add(List.of(1, 1));

        numRows = numRows - 2;
        int currIndex = 1;

        while (numRows != 0) {
            List<Integer> temp = l.get(currIndex);
            List<Integer> listToBeAdded = new ArrayList<>();
            listToBeAdded.add(1);
            int len = temp.size();

            for (int i = 0; i < len - 1; i++) {
                listToBeAdded.add(temp.get(i) + temp.get(i + 1));
            }

            listToBeAdded.add(1);
            l.add(listToBeAdded);
            numRows--;
        }

        return l;
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        String[] s1Arr = s1.split("");
        String[] s2Arr = s2.split("");

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        int len = s1Arr.length;

        for (int i = 0; i < len; i++) {

        }

        return true;

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
                } else if (board[postionOfRock[0]][i] == 'p') {
                    count++;
                    break;
                }
            }
        }

        for (int i = postionOfRock[1] - 1; i >= 0; i--) {
            if (board[postionOfRock[0]][i] == '.') {
                continue;
            } else {
                if (board[postionOfRock[0]][i] == 'B') {
                    break;
                } else if (board[postionOfRock[0]][i] == 'p') {
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
                } else if (board[i][postionOfRock[1]] == 'p') {
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
                } else if (board[i][postionOfRock[1]] == 'p') {
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
