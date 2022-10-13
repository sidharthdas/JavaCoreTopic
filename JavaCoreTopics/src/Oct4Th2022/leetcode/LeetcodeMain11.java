package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  11/10/22
 */
public class LeetcodeMain11 {
    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};

        //System.out.println(arr[j][i]);

/*        int[] arrr = new int[]{6, 3, 7, 1, 8, 2, 9, 1};
        System.out.println(Arrays.binarySearch(arrr, 1));*/

       /* FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());    // return 4 -> [2]
        System.out.println(q.popBack());      // return 2 -> []
        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)*/

        //System.out.println(simplifiedFractions(2));

        /*
         * dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
         * */
        // System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        //System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
        //System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(checkValid(new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}}));

    }

    public boolean checkZeroOnes(String s) {
        String srr[] = s.split("");
        List<Integer> count1 = new ArrayList<>();
        List<Integer> count2 = new ArrayList<>();
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(srr[i].equals("1")){
                count+=1;
            }else{
                count1.add(count);
                count = 0;
            }
        }

        count1.add(count);
        count = 0;

        for (int i = 0; i < len; i++) {
            if(srr[i].equals("0")){
                count+=1;
            }else{
                count2.add(count);
                count = 0;
            }

        }
        count2.add(count);

        Collections.sort(count1, Comparator.reverseOrder());
        Collections.sort(count2, Comparator.reverseOrder());

        return count1.get(0) > count2.get(0);

    }

    public static boolean checkValid(int[][] matrix) {
        int size = matrix.length;
        int sum = (size * (size + 1)) / 2;

        for (int[] i : matrix) {
            int s = sum(i);
            if (s == sum) {
                boolean ch = check(i);
                if (!ch) {
                    return false;
                }
            }
            if (s != sum) {
                return false;
            }
        }

        for (int i = 0; i < size; i++) {
            int sum1 = 0;
            for (int j = 0; j < size; j++) {
                sum1 += matrix[j][i];
            }
            if (sum != sum1) {
                return false;
            } else {
                sum1 = 0;
            }
        }
        return true;
    }

    private static boolean check(int a[]) {
        List<Integer> l = Arrays.stream(a).boxed().toList();
        int len = a.length;
        int c = 1;
        for (int i = 1; i <= len; i++) {
            if (!l.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static int sum(int[] ar) {
        int sum = 0;
        for (int a : ar) {
            sum += a;
        }
        return sum;
    }

    public static int firstMissingPositive(int[] nums) {
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        Arrays.sort(nums);
        int len = nums.length;
        int lar = nums[len - 1];
        for (int i = 1; i <= lar; i++) {
            map.put(i, false);
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, true);
            }
        }
        if (map.size() == 0) {
            return lar + 1;
        }

        map = map.entrySet().stream().filter(x -> x.getValue() == false).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
        ));

        if (map.size() == 0) {
            return lar + 1;
        } else {
            return map.entrySet().stream().findFirst().get().getKey();
        }

    }

    public static boolean canBeIncreasing(int[] nums) {
        int len = nums.length;
        int prev = nums[0];
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (prev < nums[i]) {
                prev = nums[i];
            } else {
                prev = prev > nums[i] ? nums[i] : prev;

                count += 1;

            }

            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static int balancedStringSplit(String s) {
        String[] srr = s.split("");
        int len = srr.length;
        int mainCount = 0;
        int countR = 0;
        int countL = 0;
        for (int i = 0; i < len; i++) {
            if (countR != 0 && countL != 0 && (countL == countR)) {
                mainCount += 1;
                if (srr[i].equals("R")) {
                    countR += 1;
                } else {
                    countL += 1;
                }
            } else {
                if (srr[i].equals("R")) {
                    countR += 1;
                } else {
                    countL += 1;
                }
            }
        }
        if (countR != 0 && countL != 0 && (countL == countR)) {
            mainCount += 1;
        }
        return mainCount;
    }

    public int numOfPairs(String[] nums, String target) {
        int len = nums.length;
        int count = 0;
        int tarLen = target.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    String s = nums[i] + nums[j];
                    if (s.equals(target)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static String removeDuplicates(String s) {
        String[] srr = s.split("");
        String prev = srr[0];
        StringBuffer s1 = new StringBuffer(srr[0]);
        int count = 1;
        int len = srr.length;
        for (int i = 1; i < len; i++) {
            if (prev.equals(srr[i])) {
                s1.append(srr[i]);
                count++;
            } else {
                if (count == 2) {
                    break;
                } else {
                    prev = srr[i];
                    s1 = new StringBuffer(srr[i]);
                }
            }
            if (count == 2) {
                break;
            }
        }
        if (count > 1) {
            s = s.replaceAll(s1.toString(), "");
            return removeDuplicates(s);
        } else {
            return s;
        }
    }


    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = dominoes.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!map.containsKey(j)) {
                    if (i != j) {
                        if (((dominoes[i][0] == dominoes[j][0]) && (dominoes[i][1] == dominoes[j][1])) ||
                                ((dominoes[i][0] == dominoes[j][1]) && (dominoes[i][1] == dominoes[j][0]))) {
                            count++;
                        }
                    }
                } else if (map.containsKey(j) && map.get(j) != i) {
                    if (i != j) {
                        if (((dominoes[i][0] == dominoes[j][0]) && (dominoes[i][1] == dominoes[j][1])) ||
                                ((dominoes[i][0] == dominoes[j][1]) && (dominoes[i][1] == dominoes[j][0]))) {
                            count++;
                        }
                    }
                }
            }
        }
        return count / 2;
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> prefixes = new ArrayList<>();
        int len = nums.length;
        String s = "";
        for (int i : nums) {
            s = s + i;
            if (Integer.parseInt(s, 2) % 5 == 0) {
                prefixes.add(true);
            } else {
                prefixes.add(false);
            }

        }

        return prefixes;
    }

    public static int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int count = 1;
        int longest = 1;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count += 1;
            } else {
                if (longest < count) {
                    longest = count;
                    count = 1;
                } else {
                    count = 1;
                }
            }
        }
        if (count > longest) {
            return count;
        }
        return longest;
    }

    public int maximumDifference(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {

                if (nums[i] < nums[j]) {
                    set.add(nums[j] - nums[i]);
                }
            }

        }

        int len1 = set.size();
        if (len1 == 0) {
            return -1;
        }
        return set.stream().toList().get(len1);

    }


    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int greatest = Integer.MIN_VALUE;
        int[] newNum = new int[len];
        int curr = 0;
        for (int i = 0; i < len; i++) {
            curr = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (curr < nums[j]) {
                    greatest = nums[j];
                    break;
                }
            }
            if (greatest == Integer.MIN_VALUE) {
                for (int j = 0; j < i; j++) {
                    if (curr < nums[j]) {
                        greatest = nums[j];
                        break;
                    }
                }
            }

            if (greatest == Integer.MIN_VALUE) {
                newNum[i] = -1;
            } else {
                newNum[i] = greatest;
                greatest = Integer.MIN_VALUE;
            }
        }

        return newNum;

    }

    public static int countCharacters(String[] words, String chars) {
        Map<String, Integer> map = new HashMap<>();
        String[] arr = chars.split("");
        int count = 0;

        for (String s1 : arr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        for (String word : words) {

            Map<String, Integer> m = new HashMap<>();
            String[] wArr = word.split("");

            for (String s1 : wArr) {
                m.put(s1, m.getOrDefault(s1, 0) + 1);
            }
            boolean flag = true;
            for (Map.Entry<String, Integer> m1 : m.entrySet()) {
                if (!map.containsKey(m1.getKey())) {
                    flag = false;
                    break;
                }
                if (m1.getValue() > map.get(m1.getKey())) {
                    flag = false;
                    break;

                }
            }
            if (flag) {
                count += word.length();
            } else {
                flag = true;
            }


        }

        return count;

    }

    public int[] decompressRLElist(int[] nums) {
        int len = nums.length;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < len; i += 2) {
            //freq, val]
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq != 0) {
                l.add(val);
                freq--;
            }

        }
        int lLen = l.size();
        int[] arr = new int[lLen];
        for (int i = 0; i < lLen; i++) {
            arr[i] = l.get(i);
        }

        return arr;
    }

    public int[] decode(int[] encoded, int first) {
        int encodedLen = encoded.length;
        int[] newArr = new int[encodedLen + 1];
        newArr[0] = first;
        for (int i = 0; i < encodedLen; i++) {
            newArr[i + 1] = newArr[i] ^ encoded[i];
        }
        return newArr;
    }

    public int largestPerimeter1(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().sorted().toList();
        int len = l.size();
        for (int i = len - 1; i > 2; i++) {
            int a = l.get(len - 1);
            int b = l.get(len - 2);
            int c = l.get(len - 3);

            if ((a + b > c)) {
                return a + b + c;
            }

        }

        return 0;
    }

    public String interpret(String command) {
        command = command.replaceAll("\\(\\)", "o");
        command = command.replaceAll("\\(", "").replaceAll("\\)", "");
        return command;
    }

    public int numberOfSubstrings(String s) {
        int count = 0;
        int len = s.length();
        int temp = 0;
        String arr[] = new String[len * (len + 1) / 2];


        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                arr[temp] = s.substring(i, j + 1);
                if (s.substring(i, j + 1).length() >= 3) {
                    if (s.substring(i, j + 1).contains("a") &&
                            s.substring(i, j + 1).contains("b") &&
                            s.substring(i, j + 1).contains("c")) {
                        count++;
                    }

                }
                temp++;
            }
        }

        return count;

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // map.entrySet().stream().sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
        return 0;
    }

    public static String addSpaces(String s, int[] spaces) {
        List<String> l = new ArrayList<>();
        int len = spaces.length;
        int prevIndex = -1;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                l.add(s.substring(0, spaces[i]) + "-");
                prevIndex = spaces[i];
            } else {
                l.add(s.substring(prevIndex, spaces[i]) + "-");
                prevIndex = spaces[i];
            }
        }
        l.add(s.substring(prevIndex));
        System.out.println(l);
        StringBuffer sb = new StringBuffer("");
        l.forEach(x -> {
            sb.append(x);
        });
        return sb.toString().replaceAll("-", " ");

    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        List<String> l = new ArrayList<>();
        String sentenceArr[] = sentence.split(" ");
        String mainSen = "";
        int count = 0;
        int len = dictionary.size();
        for (String s1 : sentenceArr) {
            for (int i = 0; i < len; i++) {
                int s1Len = s1.length();
                String s2 = dictionary.get(i);
                int s2Len = s2.length();

                if (s2Len <= s1Len) {
                    if (s1.substring(0, s2Len).equals(s2)) {
                        l.add(s2);
                        //mainSen += s2 + " ";
                    }
                }
                count++;
            }
            if (l.isEmpty()) {
                mainSen += s1 + " ";
            } else {
                if (l.size() == 1) {
                    mainSen += l.get(0) + " ";
                    l = new ArrayList<>();
                } else {
                    Collections.sort(l, (x, y) -> x.length() - y.length());
                    mainSen += l.get(0) + " ";
                    l = new ArrayList<>();
                }
            }
        }

        return mainSen.trim();
    }




            /*for (String s2 : dictionary) {
                int s1Len = s1.length();
                int s2Len = s2.length();
                if (s2Len <= s1Len) {
                    if (s1.substring(0, s2Len).equals(s2)) {
                        mainSen += s2 + " ";
                        count = 0;
                        break;
                    }
                }
                if (count == len - 1) {
                    if (s2Len <= s1Len) {
                        if (s1.substring(0, s2Len).equals(s2)) {
                            mainSen += s2 + " ";
                            count = 0;
                            break;
                        }else{
                            mainSen += s1 + " ";
                            count = 0;
                        }
                    } else {
                        mainSen += s1 + " ";
                        count = 0;
                    }
                }
                count += 1;
            }

        }
        return mainSen.trim();
    }*/

    public List<String> simplifiedFractions(int n) {
        List<String> l = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            for (int j = i + 1; j <= n; j++) {
                if (i % j != 0) {
                    if (i == 1) {
                        l.add(i + "/" + j);
                    } else if (simplify(i, j)) {
                        l.add(i + "/" + j);
                    }
                }
            }
        }
        return l;
    }

    private boolean simplify(int first, int sec) {
        int i = 2;
        boolean flag = true;
        while (i <= first) {
            if (first % i == 0 && sec % i == 0) {
                flag = false;
                break;
            }
            i++;
        }

        return flag;
    }

    public boolean canConstruct(String s, int k) {

        int len = s.length();

        if (len < k) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");

        for (String s1 : srr) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }

        int sol = 0;

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 != 0) {
                sol += 1;
            }
        }
        return sol >= k;
    }

    public static String removeOccurrences(String s, String part) {
        if (!s.contains(part)) {
            return s;
        }
        s = s.replaceFirst(part, "");
        return removeOccurrences(s, part);
    }

    public int largestPerimeter(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().sorted().toList();
        int len = nums.length;
        int a = l.get(len - 1);
        int b = l.get(len - 2);
        int c = l.get(len - 3);

        if ((a + b > c) && (b + c > a) && (a + c > b)) {
            return a + b + c;
        }
        return 0;
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] srr = domain.split(" ");
            int times = Integer.parseInt(srr[0]);
            if (map.containsKey(srr[1])) {
                map.put(srr[1], map.get(srr[1]) + times);
            } else {
                map.put(srr[1], times);
            }
            List<String> l = new ArrayList<>();
            int lastIndexOfDot = srr[1].lastIndexOf('.');
            int currIndexOfDot = srr[1].indexOf('.');
            while (currIndexOfDot != lastIndexOfDot) {
                String s1 = srr[1].substring(currIndexOfDot + 1);
                if (map.containsKey(s1)) {
                    map.put(s1, map.get(s1) + times);
                } else {
                    map.put(s1, times);
                }

                srr[1] = srr[1].replaceFirst("\\.", "-");
                currIndexOfDot = srr[1].indexOf('.');
            }
            String s1 = srr[1].substring(lastIndexOfDot + 1);
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + times);
            } else {
                map.put(s1, times);
            }
        }

        System.out.println(map);
        map.entrySet().forEach(x -> {
            list.add(x.getValue() + " " + x.getKey());
        });
        return list;
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int currIndex = 0;

        while (list.size() != 1) {
            currIndex += k - 1;
            if (currIndex < list.size()) {
                list.remove(currIndex);
                //currIndex -= 1;
            } else {
                while (currIndex >= list.size()) {
                    currIndex = (currIndex - list.size());
                }
                list.remove(currIndex);
            }
        }
        return list.get(0);
    }
}

class FrontMiddleBackQueue {

    List<Integer> list;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(val);
    }

    public void pushMiddle(int val) {
        int middle = list.size() / 2;
        list.add(middle + 1, val);
    }

    public void pushBack(int val) {
        if (list.size() == 0) {
            list.add(val);
        } else {
            list.add(0, val);
        }
    }

    public int popFront() {
        int size = list.size();
        if (size == 0) {
            return -1;
        }
        int val = list.get(size - 1);
        return list.remove(size - 1);

    }

    public int popMiddle() {
        int middle = list.size() / 2;
        return list.remove(middle + 1);

    }

    public int popBack() {
        return list.remove(0);
    }
}

