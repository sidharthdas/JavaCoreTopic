package Oct4Th2022.leetcode;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        //System.out.println(findMinDifference(Arrays.asList("05:31", "22:08", "00:35")));
        //System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        //System.out.println(countVowelSubstrings("cuaieuouac"));
        //System.out.println(findSubarrays(new int[]{1, 2, 3, 4, 5}));

        //System.out.println(maxScore("010"));
        //distinctDifferenceArray(new int[]{1, 2, 3, 4, 5});
        //System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        //System.out.println(smallestEquivalentString("leetcode", "programs", "sourcecode"));
        //rotate(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
        System.out.println(shortestPalindrome("aacecaaa"));

    }

    public static String shortestPalindrome(String s) {
        int startIndex = 0;
        int lastIndex = s.length() - 1;

        while (startIndex < lastIndex) {
            if (s.charAt(startIndex) != s.charAt(lastIndex)) {
                s = s.substring(0, startIndex) + s.charAt(lastIndex) + s.substring(startIndex);
                lastIndex++;
            }
            startIndex++;
            lastIndex--;
        }

        return s;
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int size = nums.length;
        List<Integer> finalResult = new ArrayList<>();

        for (int i : nums) {
            int t = l.indexOf(i);
            finalResult.add(t);
        }

        return finalResult;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] newMat = new int[n][n];
        int tempX = 0;
        int tempY = 0;

        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                newMat[i][j] = matrix[tempX][tempY];
                tempY++;
            }
            tempX++;
            tempY = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newMat[i][j];
            }
        }
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {

        List<TreeSet<String>> list = new ArrayList<>();
        int len = s1.length();

        for (int i = 0; i < len; i++) {
            int finalI = i;
            Optional<TreeSet<String>> set = list
                    .stream()
                    .filter(x -> x.contains(String.valueOf(s1.charAt(finalI))) || x.contains(String.valueOf(s2.charAt(finalI))))
                    .findFirst();
            if (set.isPresent()) {
                set.get().add(String.valueOf(s1.charAt(finalI)));
                set.get().add(String.valueOf(s2.charAt(finalI)));
            } else {
                TreeSet<String> set1 = new TreeSet<>();
                set1.add(String.valueOf(s1.charAt(finalI)));
                set1.add(String.valueOf(s2.charAt(finalI)));
                list.add(set1);
            }
        }

        String finalResult = "";

        String[] srr = baseStr.split("");

        for (String s : srr) {
            Optional<TreeSet<String>> tree = list.stream().filter(x -> x.contains(s)).findFirst();
            if (tree.isPresent()) {
                finalResult += list.stream().filter(x -> x.contains(s)).findFirst().get().stream().findFirst().get();
            } else {
                finalResult += s;
            }
        }

        return finalResult;
    }

    public static String removeOuterParentheses(String s) {

        int len = s.length();
        int currentIndex = 0;
        String finalString = "";
        while (true) {
            s = s.substring(currentIndex);
            int startIndex = s.indexOf("((");
            int endIndex = s.indexOf("))");

            if (startIndex == -1) {
                if (s.length() < 2) {
                    finalString += s;
                }
                break;
            }

            finalString += s.substring(startIndex + 1, endIndex + 1);
            currentIndex = endIndex + 2 >= len ? len - 1 : endIndex + 2;


        }

        return finalString;
    }

    //Distinct
    public static int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        Set<Integer> set = null;
        int[] result = new int[len];

        int prefix = 0;
        int suffic = 0;

        for (int i = 0; i < len; i++) {
            set = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                if (set.add(nums[j])) {
                    prefix++;
                }
            }
            set = new HashSet<>();
            for (int j = i + 1; j < len; j++) {
                if (set.add(nums[j])) {
                    suffic++;
                }
            }

            result[i] = prefix - suffic;
            prefix = 0;
            suffic = 0;
        }

        return result;
    }


    public int maxDivScore(int[] nums, int[] divisors) {

        Map<Integer, Long> map = new HashMap<>();
        long max = Integer.MIN_VALUE;

        for (int divisor : divisors) {
            long count = Arrays.stream(nums).boxed().filter(x -> x % divisor == 0).count();
            map.put(divisor, count);
            if (count > max) {
                max = count;
            }
        }


        long finalMax = max;
        return map.entrySet().stream().filter(x -> x.getValue() == finalMax).map(x -> x.getKey()).sorted(Comparator.reverseOrder()).findFirst().get();


    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        int kingX = king[0];
        int kingY = king[1];

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        for (int[] queen : queens) {
            if (queen[0] == kingX) {


            } else if (queen[1] == kingY) {

            } else {

            }
        }

        return null;

    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int rs = i - k;
                int re = i + k;
                int cs = j - k;
                int ce = j + k;

                if (rs < 0) {
                    rs = 0;
                }

                if (re >= row) {
                    re = row - 1;
                }

                if (cs < 0) {
                    cs = 0;
                }

                if (ce >= col) {
                    ce = col - 1;
                }

                result[i][j] = sum(mat, rs, re, cs, ce);
            }
        }

        return result;
    }

    private int sum(int[][] arr, int rs, int re, int cs, int ce) {
        int temp = 0;

        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                temp += arr[i][j];
            }
        }

        return temp;
    }

    public int[] findColumnWidth(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[] len = new int[col];
        int temp = 0;

        for (int j = 0; j < col; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < row; i++) {
                if (String.valueOf(grid[i][j]).length() > max) {
                    max = String.valueOf(grid[i][j]).length();
                }
            }
            len[temp] = max;
            temp++;
        }
        return len;
    }

    public List<List<Integer>> findMatrix(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int size = map.size();
        int zero = 0;

        List<List<Integer>> list = new ArrayList<>();
        while (map.entrySet().stream().filter(x -> x.getValue() == 0).count() != size) {
            List<Integer> l = new ArrayList<>();

            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if (m.getValue() > 0) {
                    l.add(m.getKey());
                    map.put(m.getKey(), m.getValue() - 1);
                } else {
                    zero++;
                }
            }
            list.add(l);
        }
        return list;
    }

    public int diagonalPrime(int[][] nums) {
        List<Integer> l = new ArrayList<>();
        int r = nums.length;
        int c = nums[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((i == j) || nums[i][r - i - 1] == nums[i][j]) {
                    l.add(nums[i][j]);
                }
            }
        }

        l = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i : l) {
            if (isPrime(i)) {
                return i;
            }
        }

        return 0;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0) return false;
        }
        return true;
    }


    public int maximizeSum(int[] nums, int k) {
        int a = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).findFirst().get();
        int sum = a;

        for (int i = 0; i < k - 1; i++) {
            sum = sum + a + 1;
            a = a + 1;
        }
        return sum;
    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int time = arrivalTime + delayedTime;
        if (time == 24) {
            return 0;
        } else if (time > 24) {
            return time - 24;
        }
        return time;
    }

    public int sumOfMultiples(int n) {
        OptionalInt a = IntStream.range(1, n + 1).filter(x -> (x % 3 == 0) || (x % 5 == 0) || (x % 7 == 0)).reduce(Integer::sum);
        return a.isPresent() ? a.getAsInt() : 0;
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            map.put(i, count);
        }

        int max = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).findFirst().get().getValue();
        Map.Entry<Integer, Integer> e = map.entrySet().stream().filter(x -> x.getValue() == max).sorted(Map.Entry.<Integer, Integer>comparingByKey()).findFirst().get();

        return new int[]{e.getKey(), e.getValue()};
    }

    public int minOperations1(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            } else if (log.equals("../")) {
                depth--;
                if (depth < 0) {
                    depth = 0;
                }
            } else depth++;
        }
        return depth;

    }

    public int minOperations(String[] logs) {

        int count = 0;
        for (String s : logs) {
            if (s.equals("./")) {

            } else if (s.equals("../")) {
                count--;
                if (count < 0) {
                    count = 0;
                }
            } else {
                count++;
            }
        }

        return count;

    }

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int current = 1;
        int max = 1;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                current += 1;
                if (current > max) {
                    max = current;

                }
            } else {
                current = 1;
            }
        }

        return max;

    }


    public int partitionDisjoint(int[] nums) {
        int left = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    return left;
                }
            }

            left++;
        }

        return left;
    }

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }

    public static int maxScore(String s) {
        int len = s.length();
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            l.add(count(0, i, s, 0) + count(i, len, s, 1));
        }
        return l.stream().sorted(Comparator.reverseOrder()).findFirst().get();
    }

    private static int count(int start, int end, String s, int flag) {
        int count = 0;
        if (flag == 0) {
            for (int i = start; i < end; i++) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }
        }
        if (flag == 1) {
            for (int i = start; i < end; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
        }

        return count;
    }

    public static int romanToInt1(String s) {
        Map<String, Integer> map = Map.ofEntries(Map.entry("I", 1), Map.entry("V", 5), Map.entry("X", 10), Map.entry("L", 50), Map.entry("C", 100), Map.entry("D", 500), Map.entry("M", 1000));

        int count = 0;
        String[] srr = s.split("");
        int len = srr.length;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            count = map.get(srr[i]);
            if (4 * count < ans) {
                ans = ans - count;
            } else {
                ans = ans + count;
            }
        }
        return count;
    }

    public String fractionAddition(String expression) {
        String first = expression.substring(0, expression.indexOf("/") + 2);
        String second = expression.substring(expression.indexOf("/") + 2);

        return null;

    }

    public int minimumMoves(String s) {
        if (!s.contains("X")) {
            return 0;
        }

        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'X') {
                count++;
                i += 2;
            }
        }

        return count;
    }

    public static boolean findSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                if (!set.add(nums[i] + nums[j])) {
                    return true;
                }
            }
        }

        return false;

    }

    public static int countVowelSubstrings(String word) {
        if (word.length() < 5) return 0;
        Set<String> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        char[] crr = word.toCharArray();
        int size = word.length();
        for (int len = 1; len <= size; len++) {
            // Pick ending point
            for (int i = 0; i <= size - len; i++) {
                //  Print characters from current
                // starting point to current ending
                // point.
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    sb.append(crr[k]);
                }
                String s1 = sb.toString();
                sb = new StringBuilder();
                if (s1.length() >= 5 && s1.contains("a") && s1.contains("e") && s1.contains("i") && s1.contains("o") && s1.contains("u") && s1.replaceAll("[aeiou]", "").length() == 0) {
                    set.add(s1);
                }
            }
        }
        System.out.println(set);
        return set.size();
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
        }

        while (k != 0) {
            pq.add(-pq.poll());
            k--;
        }

        return pq.stream().reduce(Integer::sum).get();
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        return 0;

    }

    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int finArray[][] = new int[len - 2][len - 2];

        for (int i = 0; i < len - 2; i++) {
            for (int j = 0; j < len - 2; j++) {
                finArray[i][j] = maxFromGrid(grid, i, j);
            }
        }

        return finArray;
    }

    private int maxFromGrid(int[][] grid, int i, int j) {
        int max = Integer.MIN_VALUE;

        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {

                max = Math.max(grid[k][l], max);
            }
        }
        return max;
    }

    public int splitNum(int num) {
        List<Integer> l = new ArrayList<>();
        while (num != 0) {
            l.add(num % 10);
            num = num / 10;
        }


        Collections.sort(l);

        boolean flag = true;
        String num1 = "";
        String num2 = "";

        for (int i : l) {
            if (flag) {
                num1 += i;
                flag = false;
            } else {
                num2 += i;
                flag = true;
            }
        }

        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }

    public String shiftingLetters(String s, int[] shifts) {
        char[] crr = s.toCharArray();
        int len = shifts.length;

        for (int i = 0; i < len; i++) {
            int temp = shifts[i] % 26;
            for (int j = 0; j < i + 1; j++) {

                crr[j] = (char) (crr[j] + temp);
                if (crr[j] > 'z') {
                    crr[j] = (char) ('a' + crr[j] - 'z' + 1);
                }
            }

        }

        return String.valueOf(crr);
    }

    public int lengthOfLongestSubstring(String s) {
        String[] srr = s.split("");
        int len = srr.length;
        int countMax = Integer.MIN_VALUE;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (!sb.toString().contains(srr[i])) {
                sb.append(srr[i]);
            } else {
                countMax = Math.max(countMax, sb.length());
                sb = new StringBuffer();
                sb.append(srr[i]);
            }
        }

        return Math.max(countMax, sb.length());

    }

    public static int findLHS(int[] nums) {
        List<Integer> countList = new ArrayList<>();
        int len = nums.length;
        int count = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            temp.add(nums[i]);
            if (temp.size() > 1 && max - min == 1) {
                temp.add(nums[i]);

            } else {
                countList.add(temp.size());
                temp = new ArrayList<>();
                temp.add(nums[i]);
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
            }
        }

        return countList.stream().sorted(Comparator.reverseOrder()).findFirst().get();

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
        Map<String, Integer> map = Map.ofEntries(Map.entry("I", 1), Map.entry("V", 5), Map.entry("X", 10), Map.entry("L", 50), Map.entry("C", 100), Map.entry("D", 500), Map.entry("M", 1000));

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
                Map.entry(1, 31), Map.entry(2, 28), Map.entry(3, 31), Map.entry(4, 30), Map.entry(5, 31), Map.entry(6, 30), Map.entry(7, 31), Map.entry(8, 31), Map.entry(9, 30), Map.entry(10, 31), Map.entry(11, 30), Map.entry(12, 31));
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

        map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

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

                if (s.substring(0, prefLen).equals(pref) && s.substring(sLen - suffLen).equals(suff)) {
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


class A {
    int i = 10;

    public static void main(String[] args) {
        A a = new BB();
        System.out.println(a.i);
    }

}

class BB extends A {
    int i = 20;
}
