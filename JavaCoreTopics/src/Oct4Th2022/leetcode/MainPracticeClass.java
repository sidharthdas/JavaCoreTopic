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
        //System.out.println(removeDigit("551", '5'));
        //System.out.println(removeDuplicates(new int[]{ 1,2,2,2}));
        //System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        //System.out.println(Math.log(8) / Math.log(2));
        //WordFilter wf = new WordFilter(new String[]{"apple"});
        //System.out.println(wf.f("a", "e"));
        //System.out.println(getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"}));
        //System.out.println(countPairs(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468}));
        System.out.println(findMinDifference(Arrays.asList("05:31", "22:08", "00:35")));
    }

    public int findLHS(int[] nums) {
        List<Integer> countList = new ArrayList<>();
        int len = nums.length;
        int count = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }

            if (max - min == 1) {
                temp.add(nums[i]);

            } else {

            }
        }

        return 0;

    }

    public static int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] mins = new int[len];
        int currIndex = 0;
        for (String time : timePoints) {
            String[] timeArr = time.split(":");
            int totalMin = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            mins[currIndex] = totalMin;
            currIndex++;
        }
        Arrays.sort(mins);

        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    minTime = Math.min(minTime, Math.abs(mins[i] + 1440 - mins[j]));
                    minTime = Math.min(minTime, Math.abs(mins[j] - mins[i]));
                }
            }
        }
        return minTime;
    }

    public int minSteps(String s, String t) {

        Map<String, Integer> mapS = new HashMap<>();
        Map<String, Integer> mapT = new HashMap<>();
        String[] srr = s.split("");
        String[] trr = t.split("");
        Set<String> set = new HashSet<>();
        int freq = 0;
        for (String s1 : srr) {
            mapS.put(s1, mapS.getOrDefault(s1, 0) + 1);
            set.add(s1);
        }

        for (String t1 : trr) {
            mapT.put(t1, mapT.getOrDefault(t1, 0) + 1);
            set.add(t1);
        }

        for (String set1 : set) {
            if (mapT.getOrDefault(set1, 0) < mapS.getOrDefault(set1, 0)) {
                freq += Math.abs(mapT.getOrDefault(set1, 0) - mapS.getOrDefault(set1, 0));
            }
        }

        return freq;
    }

    public boolean makesquare(int[] matchsticks) {
        if (Arrays.stream(matchsticks).boxed().reduce(Integer::sum).get() % 4 == 0) {
            return true;
        }
        return false;

    }

    public static String[] getFolderNames(String[] names) {

        int len = names.length;
        String[] finalStringArr = new String[len];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s = "";
            int num = 0;
            if (names[i].contains("(")) {
                int index = names[i].indexOf('(');
                s = names[i].substring(0, index);
                num = Integer.parseInt(names[i].substring(index + 1, names[i].length() - 1));
                map.put(s, num);
                finalStringArr[i] = names[i];

            } else {
                s = names[i];
                if (!map.containsKey(s)) {
                    map.put(s, 0);
                    finalStringArr[i] = s;
                } else {
                    map.put(s, map.get(s) + 1);
                    finalStringArr[i] = s + "(" + map.get(s) + ")";
                }
            }
        }
        return finalStringArr;
    }

    public boolean find132pattern(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] < nums[i + 2] && nums[i + 2] < nums[i + 1]) {
                return true;
            }
        }

        return false;
    }


    //x * log2(2) = log2(4)

    public static int countPairs(int[] deliciousness) {
        int len = deliciousness.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i != j) {
                    Double d = Math.log(deliciousness[i] + deliciousness[j]) / Math.log(2);
                    if (String.valueOf(d).split("\\.").length == 2 && String.valueOf(d).split("\\.")[1].equals("0")) {
                        count++;
                    }

                }
            }
        }
        return count;
    }


    public static int findPairs(int[] nums, int k) {

        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == k && (!set.contains(nums[i]) && !set.contains(nums[j]))) {
                    count++;
                    set.add(nums[i]);
                    set.add(nums[j]);
                }
            }
        }

        return count;

    }

    public String removeDigit1(String number, char digit) {

        int len = number.length();
        int currIndex = 0;

        String temp = number;

        List<String> l = new ArrayList<>();

        while (currIndex != len) {
            for (int i = currIndex; i < len; i++) {
                if (number.charAt(i) == digit) {
                    currIndex = i + 1;
                    l.add(number.substring(0, i) + number.substring(i + 1));
                    break;
                } else if (i == len - 1) {
                    currIndex = i + 1;
                    break;
                }
            }
        }

        return String.valueOf(l.stream().sorted(Comparator.reverseOrder()).findFirst().get());
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int count = 0;
        String currWord = beginWord;
        while (!currWord.equals(endWord) || wordList.size() != 0) {
            boolean flag = false;
            for (String s : wordList) {
                if (compare(currWord, s)) {
                    currWord = s;
                    count++;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                wordList.remove(currWord);
            }
        }

        return count;
    }

    public boolean compare(String s1, String s2) {

        int count = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int len = c1.length;

        for (int i = 0; i < len; i++) {
            if (c1[i] != c2[i]) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    public void setZeroes(int[][] matrix) {
        List<List<Integer>> indexes = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    indexes.add(List.of(i, j));
                }
            }
        }
        for (List<Integer> l : indexes) {
            for (int i = 0; i < row; i++) {
                matrix[i][l.get(1)] = 0;
            }

            for (int i = 0; i < col; i++) {
                matrix[l.get(0)][i] = 0;
            }

        }
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000)
        );

        int count = 0;
        String[] srr = s.split("");
        int len = srr.length;

        for (int i = len - 1; i >= 0; i--) {
            count += map.get(srr[i]);
        }
        return count;
    }

    public int partitionString(String s) {

        Set<String> set = new HashSet<>();

        String[] srr = s.split("");
        int count = 0;

        for (String s1 : srr) {
            if (!set.add(s1)) {
                count++;
                set = new HashSet<>();
                set.add(s1);
            }
        }

        return count + 1;
    }

    public static int removeDuplicates(int[] nums) {
        if (Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() == 1) {
            return 2;
        }
        int count = 0;
        int len = nums.length;
        int tempLen = len;
        int currNum = nums[0];
        int currCount = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == currNum) {
                currCount++;
            } else {

                currNum = nums[i];
                currCount = 1;
            }
            if (currCount > 2) {
                currCount--;
                count++;
                tempLen--;
                shift(nums, i, len);

                i--;
            }

            if (tempLen == i) {
                break;
            }
        }

        return tempLen;
    }

    public static void shift(int[] nums, int index, int len) {

        for (int i = index; i < len - 1; i++) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
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

class WordFilter {


    Set<String> dict;
    int len;

    public WordFilter(String[] words) {
        dict = new TreeSet<>();
        dict.addAll(Arrays.stream(words).collect(Collectors.toSet()));
        len = words.length;
    }

    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();

        for (String s : source) {
            if (!s.contains("/*") || !s.contains("*/") || !s.contains("//")) {
                list.add(s);
            } else {
                if (s.contains("//")) {
                    int in = s.indexOf("//");
                    if (in != 0) {
                        s = s.substring(0, in);
                        list.add(s);
                    }
                }

            }
        }

        return null;
    }

    public int f(String pref, String suff) {
        int prefLen = pref.length();
        int suffLen = suff.length();
        Map<String, Integer> map = new HashMap<>();
        int currIndex = 0;
        for (String s : dict) {
            if (s.length() >= prefLen && s.length() >= suffLen) {
                int sLen = s.length();

                if (s.substring(0, prefLen).equals(pref) &&
                        s.substring(sLen - suffLen).equals(suff)) {
                    map.put(s, currIndex);
                    currIndex++;
                }
            }
        }
        if (map.size() > 0) {
            return map.entrySet().stream().sorted(Map.Entry.comparingByKey((e1, e2) -> e2.length() - e1.length())).findFirst().get().getValue();
        }

        return -1;
    }
}
