package Oct4Th2022.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sidharth Das
 * created on  23/01/23
 */
public class Leetcode24MainClass {

    public static void main(String[] args) {
        //System.out.println(deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}}));
        //System.out.println(countOperations(2, 3));
        //System.out.println(distributeCandies(10,3));
        //System.out.println(divisorSubstrings(430043, 2));
        //subString("430043".toCharArray(), 6);
        //System.out.println(categorizeBox(1000, 1000, 1000, 1000));
        // System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        //System.out.println(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        //shortestToChar("loveleetcode", 'e');
        //System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
        //System.out.println(sumFourDivisors(new int[]{21, 4, 7}));
        //System.out.println(calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
        //Arrays.asList("", "").contains("");
        //System.out.println(maximumPopulation(new int[][]{{1950,1961},{1960,1971},{1970,1981}}));
        // System.out.println(getCommon1(new int[]{12,16,24,24,25,27,31,37,38,41,43,50,57,70,71,71,74,76,77,78},
        // new int[]{5,5,9,11,12,17,20,34,36,51,61,68,70,79,85,87,88,90,91,97}));
        //System.out.println(similarPairs(new String[]{"aba","aabb","abcd","bac","aabc"}));

       /* for (int c = 0; c <= 9; c++) {
            System.out.print("\"" + c + "\",");
        }*/

        System.out.println(countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int len = seats.length;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += Math.abs(seats[i] - students[i]);
        }

        return sum;
    }

    public int largestInteger(int num) {
        List<Integer> l = new ArrayList<>();
        while (num != 0) {
            l.add(num % 10);
            num = num / 10;
        }
        int len = l.size();

        List<Integer> evenList = l.stream().filter(x -> x % 2 == 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int evenSize = evenList.size();
        List<Integer> oddList = l.stream().filter(x -> x % 2 != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int oddSize = oddList.size();

        int evenStartIndex = 0;
        int oddStartIndex = 0;

        String ans = "";

        for (int i = len - 1; i >= 0; i--) {
            if(l.get(i) % 2 == 0){
                ans += String.valueOf(evenList.get(evenStartIndex));
                evenStartIndex++;
            } else {
                ans += String.valueOf(oddList.get(oddStartIndex));
                oddStartIndex++;
            }
        }

        return Integer.parseInt(ans);

    }

    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 - a1);
        for (int i : gifts) {
            pq.add(i);
        }

        while (k > 0) {
            pq.add((int) Math.sqrt(pq.remove()));
            k--;
        }

        return pq.stream().map(x -> (long) x).reduce(Long::sum).get();
    }

    public static int countValidWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ");
        String words[] = sentence.split(" ");
        int count = 0;
        //'!', '.', and ','
        List<String> alphaList = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        List<String> intList = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> punList = List.of("!", ".", ",");
        for (String s : words) {
            s = s.trim();
            int len = s.length();
            int alpha = 0;
            int in = 0;
            int hypens = 0;
            int pun = 0;

            if (len > 0) {
                String[] arr = s.split("");
                for (String s1 : arr) {
                    if (alphaList.contains(s1)) {
                        alpha++;
                    }
                    if (intList.contains(s1)) {
                        in++;
                    }
                    if (punList.contains(s1)) {
                        pun++;
                    }
                    if (s1.equals("-")) {
                        hypens++;
                    }
                }
                boolean flag = true;
                if (in == 0 && (hypens == 0 || hypens == 1) && (pun == 0 || pun == 1)) {
                    if (hypens == 1) {
                        if (s.charAt(0) == '-' || s.charAt(len - 1) == '-') {
                            flag = false;
                        }
                        System.out.println(s);
                        int hypenIndex = s.indexOf('-');
                        if ((hypenIndex != 0 && hypenIndex != len - 1) && !(alphaList.contains(String.valueOf(s.charAt(hypenIndex - 1))) && alphaList.contains(String.valueOf(s.charAt(hypenIndex + 1))))) {
                            flag = false;
                        }
                    }

                    if (pun == 1) {
                        if (!punList.contains(String.valueOf(s.charAt(len - 1)))) {
                            flag = false;
                        }
                    }
                } else {
                    flag = false;
                }

                if (flag) {
                    //System.out.println(s);
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isAlienSorted(String[] words, String order) {

        String[] wordArr = order.split("");
        String[] cloneWords = words;

        Arrays.sort(cloneWords, Comparator.comparingInt(x -> indexOf(wordArr, x)));

        return Arrays.toString(cloneWords).equals(Arrays.toString(words));

    }

    private static int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int minOperations(String s) {
        String[] srr = s.split("");
        int len = srr.length;
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                if (!srr[i].equals("0")) {
                    countLeft++;
                }
            } else {
                if (!srr[i].equals("1")) {
                    countLeft++;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                if (!srr[i].equals("1")) {
                    countRight++;
                }
            } else {
                if (!srr[i].equals("0")) {
                    countRight++;
                }
            }
        }

        return Math.min(countLeft, countRight);
    }

    public static int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<String> l = new ArrayList<>();
        for (String word : words) {
            l.add(Arrays.toString(Arrays.stream(word.split("")).collect(Collectors.toSet()).stream().sorted().toArray()));
        }

        int len = l.size();
        int count = 0;

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                if (l.get(i).equals(l.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int getCommon1(int[] nums1, int[] nums2) {
        Set<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> l2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> common = new ArrayList<>();
        for (int i : l2) {
            if (!l1.add(i)) {
                common.add(i);
            }
        }
        return common.size() == 0 ? -1 : common.stream().sorted().findFirst().get();
    }

    public static int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] i : logs) {
            map.put(i[0], 0);
        }

        for (int[] i : logs) {
            map.forEach((x, y) -> {
                if (i[0] <= x && i[1] >= x) {
                    map.put(x, y + 1);
                }

            });
        }

        return map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed().
                        thenComparing(Map.Entry.comparingByKey()))
                .findFirst().get().getKey();
    }

    public int getCommon(int[] nums1, int[] nums2) {
        List<Integer> l1 = Arrays.stream(nums1).boxed().toList();
        List<Integer> l2 = Arrays.stream(nums2).boxed().toList();
        List<Integer> common = new ArrayList<>();

        l1.forEach(x -> {
            if (l2.contains(x)) {
                common.add(x);
            }
        });

        return common.stream().sorted().findFirst().get();

    }


    public List<Integer> luckyNumbers(int[][] matrix) {
        return null;
    }

    public boolean checkPowersOfThree(int n) {
        if (n < 3) {
            return false;
        }

        while (n != 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }

        return true;

    }

    public static double calculateTax(int[][] brackets, int income) {
        //income, tax %
        double totalTax = 0;
        for (int[] bracket : brackets) {
            if (bracket[0] <= income) {
                totalTax += (double) ((bracket[1] / 100d)) * (double) bracket[0];
                income -= bracket[0];
            } else {
                totalTax += (double) ((bracket[1] / 100d)) * (double) income;
                income = 0;

            }
            if (income == 0) {
                break;
            }

        }
        return totalTax;
    }

    public static int sumFourDivisors(int[] nums) {

        List<List<Integer>> l = new ArrayList<>();

        for (int i : nums) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            l1.add(i);
            int x = i / 2;
            boolean flag = true;
            for (int j = 2; j <= x; j++) {
                if (i % j == 0) {
                    l1.add(j);
                    if (l1.size() > 4) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                l.add(l1);
            }
        }

        l = l.stream().filter(x -> x.size() == 4).toList();

        /*int totalSum = 0;
        for (List<Integer> l2 : l) {
            totalSum += l2.stream().reduce(Integer::sum).get();
        }*/


        return l.size() == 0 ? 0 : l.stream().filter(x -> x.size() == 4)
                .flatMap(List::stream).reduce(Integer::sum).get();
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<String> positive_feedback_list = Arrays.stream(positive_feedback).toList();
        List<String> negative_feedback_list = Arrays.stream(negative_feedback).toList();

        int reportLen = report.length;

        for (int i = 0; i < reportLen; i++) {
            String[] words = report[i].split(" ");
            int positiveCount = 0;
            int negativeCount = 0;
            for (String word : words) {
                if (positive_feedback_list.contains(word)) {
                    positiveCount += 3;
                }

                if (negative_feedback_list.contains(word)) {
                    negativeCount += 1;
                }
            }

            map.put(student_id[i], positiveCount - negativeCount);
        }

        map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return map.keySet().stream().limit(k).toList();
    }

    public boolean check(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        if (nums[len - 1] > nums[0]) {
            count++;
        }

        return count > 1 ? false : true;
    }


    public String baseNeg2(int n) {
        return String.valueOf(Integer.parseInt(String.valueOf(n), 2));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        int a = arr.length;
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 0; i < a - 1; i++) {
            while (!(Math.abs(arr[i + 1] - arr[i]) <= 1)) {
                arr[i + 1] -= 1;
            }
        }
        return Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).findFirst().get();
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> subArrays = new ArrayList<Integer>();
                for (int k = i; k <= j; k++) {
                    subArrays.add(nums[k]);

                }
                l.add(subArrays.stream().reduce(Integer::sum).get());
            }
        }

        l = l.stream().sorted().collect(Collectors.toList());
        int[] arr = new int[n * (n + 1) / 2];
        int sum = 0;
        for (int i = left - 1; i <= right - 1; i++) {
            sum += l.get(i);
        }
        return sum;
    }

    public int minDeletions(String s) {

        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");

        for (String s1 : srr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (String s1 : map.keySet()) {
            int val = map.get(s1);
            if (!set.contains(val)) {
                set.add(val);
            } else {
                while (val > 0 && set.contains(val)) {
                    val--;
                    count++;
                }

                if (val > 0) {
                    set.add(val);
                }
            }
        }
        return count;
    }

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int m = arr[(arr.length - 1) / 2];
        ;
        Comparator<Integer> comp = (a, b) -> {
            return Math.abs(a - m) == Math.abs(b - m) ? b - a : Math.abs(b - m) - Math.abs(a - m);
        };

        List<Integer> l = Arrays.stream(arr).boxed().sorted(comp).collect(Collectors.toList());

        int[] arrF = new int[k];
        int index = 0;

        while (index < k) {
            arrF[index] = l.get(index);
            index++;
        }

        return arrF;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Long> map = new HashMap<>();
        int index = 0;
        for (int[] arr : mat) {
            map.put(index, Arrays.stream(arr).boxed().filter(x -> x == 1).count());
            index++;
        }

        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int[] arr = new int[k];
        int start = 0;

        for (Map.Entry<Integer, Long> m : map.entrySet()) {
            if (start < k) {
                arr[start] = (int) m.getKey();
                start++;
            } else {
                break;
            }
        }

        return arr;
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        count = count.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int half = arr.length / 2;
        Set<Integer> s = new TreeSet<>();
        for (Map.Entry<Integer, Integer> m : count.entrySet()) {
            half -= m.getValue();
            s.add(m.getKey());
            if (half <= 0) {
                break;
            }
        }
        return s.size();
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (score1, score2) -> score2[k] - score1[k]);
        return score;
    }


    public boolean isStrictlyPalindromic(int n) {
        int startingBase = 2;

        while (startingBase <= n - 2) {
            int s = Integer.parseInt(String.valueOf(n), startingBase);
            if (!checkPalin(n)) {
                return false;
            }
        }

        return true;

    }

    private boolean checkPalin(int n) {
        int r, sum = 0, temp;
        temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        return temp == sum;
    }

    public static int[] shortestToChar(String s, char c) {
        int len = s.length();
        char[] crr = s.toCharArray();
        int[] finalArr = new int[len];
        int startIndex = 0;
        while (startIndex < len) {
            if (crr[startIndex] == c) {
                finalArr[startIndex] = 0;
            } else {
                int fromFornt = 0;
                int fromBack = 0;

                for (int i = startIndex + 1; i < len; i++) {
                    if (crr[i] != c) {
                        fromFornt++;
                    } else {
                        break;
                    }
                    if (i == len - 1) {
                        i = -1;
                    }
                }

                for (int i = startIndex == 0 ? len - 1 : startIndex - 1; i >= 0; i--) {
                    if (crr[i] != c) {
                        fromBack++;
                    } else {
                        break;
                    }
                    if (i == 0) {
                        i = len - 1;
                    }
                }
                finalArr[startIndex] = fromFornt > fromBack ? fromBack : fromFornt;
            }

            startIndex++;
        }

        return finalArr;
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];

        for (int[] index : indices) {
            int r = index[0];
            int n1 = 0;
            while (n1 < n) {
                arr[r][n1] = arr[r][n1] + 1;
                n1++;
            }

            int c = index[1];
            int m1 = 0;
            while (m1 < m) {
                arr[m1][c] = arr[m1][c] + 1;
                m1++;
            }

        }

        for (int[] arr1 : arr) {
            for (int i : arr1) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        int totalOdds = 0;

        for (int[] arr1 : arr) {
            totalOdds += (int) Arrays.stream(arr1).filter(x -> x % 2 != 0).count();
        }

        return totalOdds;
    }

    public int unequalTriplets(int[] nums) {

        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static int numberOfBeams(String[] bank) {
        int prev1s = 0;
        int totalBeams = 0;
        for (String s : bank) {
            int current1s = (int) Arrays.stream(s.split("")).filter(x -> x.equals("1")).count();
            if (current1s != 0 && prev1s != 0) {
                totalBeams += (current1s * prev1s);
                prev1s = current1s;
            } else if (prev1s == 0) {
                prev1s = current1s;
            }
        }
        return totalBeams;
    }

    static void subString(char str[], int n) {
        // Pick starting point
        for (int len = 1; len <= n; len++) {
            // Pick ending point
            for (int i = 0; i <= n - len; i++) {
                //  Print characters from current
                // starting point to current ending
                // point.
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    System.out.print(str[k]);
                }

                System.out.println();
            }
        }
    }

    public int[] getNoZeroIntegers(int n) {
        return new int[]{n + 10, -10};
    }

    //2525. Categorize Box According to Criteria
    public static String categorizeBox(int length, int width, int height, int mass) {
        Map<String, Integer> map = new HashMap<>();
        if ((length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000) || ((long) length * width * height >= 1000000000)) {
            map.put("Bulky", 1);
        }
        if (mass >= 100) {
            map.put("Heavy", 1);
        }
        /*If the box is both "Bulky" and "Heavy", then its category is "Both".
        If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
        If the box is "Bulky" but not "Heavy", then its category is "Bulky".
        If the box is "Heavy" but not "Bulky", then its category is "Heavy".*/

        if (map.containsKey("Bulky") && map.containsKey("Heavy")) {
            return "Both";
        } else if (!map.containsKey("Bulky") && !map.containsKey("Heavy")) {
            return "Neither";
        } else if (map.containsKey("Bulky") && !map.containsKey("Heavy")) {
            return "Bulky";
        } else if (!map.containsKey("Bulky") && map.containsKey("Heavy")) {
            return "Heavy";
        }
        return null;
    }

    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        return n % 2 == 0 ? n / 2 : n;
    }

    public static int divisorSubstrings(int num, int k) {
        char[] str = String.valueOf(num).toCharArray();
        int n = String.valueOf(num).length();
        List<String> l = new ArrayList<>();
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                String s = "";
                for (int k1 = i; k1 <= j; k1++) {
                    s += str[k1];
                }
                l.add(s);
                s = "";
            }
        }

        return (int) l.stream().filter(x -> String.valueOf(x).length() == k).map(x -> Integer.parseInt(x)).filter(x -> x != 0).filter(x -> num % x == 0).count();
    }


    public boolean isThree(int n) {

        int count = 2;
        int half = n / 2;

        for (int i = 2; i <= half; i++) {
            if (count > 3) {
                break;
            }
            if (n % i == 0) {
                count++;
            }

        }

        return count == 3 ? true : false;
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int currIndex = 0;
        int initialCandy = 1;
        while (candies != 0) {
            if (currIndex == num_people) {
                currIndex = 0;
            }
            if (initialCandy < candies) {
                people[currIndex] += initialCandy;
                candies -= initialCandy;
                initialCandy += 1;
                currIndex++;
            } else {
                people[currIndex] += candies;
                break;
            }
        }

        return people;
    }

    public int alternateDigitSum(int n) {
        List<Integer> l = new ArrayList<>();

        while (n != 0) {
            l.add(n % 10);
            n = n / 10;
        }
        int sum = 0;
        boolean flag = true;
        int len = l.size();
        for (int i = len - 1; i >= 0; i--) {
            if (flag) {
                sum += l.get(i);
                flag = false;
            } else {
                sum -= l.get(i);
                flag = true;
            }

        }
        return sum;
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                count++;
                num1 -= num2;
            } else {
                count++;
                num2 -= num1;
            }
        }

        return count;
    }

    public int differenceOfSum(int[] nums) {

        int totalSum = Arrays.stream(nums).boxed().reduce(Integer::sum).get();
        int digitSum = 0;
        for (int i : nums) {
            if (i < 10) {
                digitSum += i;
            } else {
                digitSum += getSum(i);
            }
        }

        return Math.abs(totalSum - digitSum);
    }

    private int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }

    public int pivotInteger(int n) {
        int mid = n / 2;

        while (!(mid > n)) {
            if (suminRange(1, mid) == suminRange(mid, n)) {
                return mid;
            }
            mid += 1;
        }

        return -1;
    }

    private int suminRange(int l, int r) {
        return sumNatural(r) - sumNatural(l - 1);
    }

    private int sumNatural(int n) {
        int sum = (n * (n + 1)) / 2;
        return sum;
    }

    public int countDigits(int num) {
        int n = num;
        List<Integer> l = new ArrayList<>();
        while (num != 0) {
            int k = num % 10;
            num = num / 10;
            l.add(k);
        }

        return (int) l.stream().filter(x -> n % x == 0).count();
    }

    public double[] convertTemperature(double celsius) {
        return new double[]{(celsius + 273.15), ((celsius * 1.80) + 32.00)};
    }

    public static int deleteGreatestValue(int[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] array : grid) {
            list.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
            //Arrays.stream(array).boxed().collect(Collectors.im)
        }

        int len = list.get(0).size();
        int finalRes = 0;
        while (list.get(0).size() != 0) {
            List<Integer> maxDel = new ArrayList<>();
            for (List<Integer> l : list) {
                int max = l.stream().max(Integer::compare).get();
                l.remove(Integer.valueOf(max));
                maxDel.add(max);
            }
            finalRes += maxDel.stream().max(Integer::compare).get();
        }

        return finalRes;
    }
}

class DataStream {
    int value;
    int k;
    List<Integer> l;

    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
        l = new ArrayList<>();
    }

    public boolean consec(int num) {
        l.add(num);
        if (l.size() < k) {
            return false;
        }
        int lastIn = l.size() - 1;
        int count = 0;
        while (lastIn >= 0) {
            if (l.get(lastIn) == value) {
                count++;
                if (count == k) {
                    return true;
                }
            } else {
                if (count != k) {
                    break;
                }
            }
            lastIn--;
        }

        return false;
    }

    public int[] findMode(TreeNode root) {
        BST b = new BST();
        b.inOrder(root);
        List<Integer> l = b.l;

        /*Map<String, Long> result  = items.stream().
				collect(Collectors.groupingBy(Function.identity(), Collectors. counting()))
				.entrySet().stream().filter(x -> x.getValue() ==1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		*/

        Map<Integer, Long> map = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long val = map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).findFirst().get().getValue();
        map = map.entrySet().stream().filter(x -> x.getValue() == val).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return map.keySet().stream().mapToInt(i -> i).toArray();
    }
}

class BST {

    List<Integer> l = new ArrayList<>();

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        l.add(node.val);
        inOrder(node.right);
    }


}