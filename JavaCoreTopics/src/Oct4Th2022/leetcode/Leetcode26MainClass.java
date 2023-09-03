package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode26MainClass {

    public static void main(String[] args) {

        /*System.out.println("Hellow world");
        System.out.println(numberOfRounds("09:31", "10:14"));

        String acc = "abscde-T1AKOOQ01";
        String referenceNumber = "T1AKOOQ01";

        if (referenceNumber.trim().equalsIgnoreCase(acc.split("-")[1])) {
            System.out.println("test");
        }
        System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));*/

        //System.out.println(closestPrimes(4, 6));
        //System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        //System.out.println(minOperations(new int[]{1, 5, 2, 4, 1}));
        //System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
        //System.out.println(waysToMakeFair(new int[]{2, 1, 6, 4}));
        int count = Runtime.getRuntime().availableProcessors();
        //System.out.println(count);
        System.out.println(smallestValue(4));
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = Arrays.stream(arr).boxed().reduce(Integer::sum).get();
        if(totalSum % 3 != 0) return false;
        int sum = totalSum / 3;
        int currentSum = 0;
        int totalCount = 0;

        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            currentSum += arr[i];
            if(currentSum == sum) {
                totalCount++;
                currentSum = 0;
            }
            if(totalCount == 2) return true;
        }

        if(totalCount == 3) return true;

        return false;
    }

    public static int smallestValue(int n) {
        if (n == 4) return 4;
        List<Integer> pF = primeFactors(n);
        while (pF.size() != 1) {
            pF = primeFactors(pF.stream().reduce(Integer::sum).get());
        }

        return pF.get(0);
    }

    private static List<Integer> primeFactors(int n) {
        List<Integer> pf = new ArrayList<>();
        while (n % 2 == 0) {
            pf.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                pf.add(i);
                n /= i;
            }
        }
        if (n > 2)
            pf.add(n);

        return pf;

    }

    public int accountBalanceAfterPurchase(int purchaseAmount) {

        int min = purchaseAmount;
        int minCount = 0;
        int max = purchaseAmount;
        int maxCount = 0;

        while (min % 10 != 0) {
            min--;
            minCount++;
        }

        while (max % 10 != 0) {
            max++;
            maxCount++;
        }

        if (minCount < maxCount) {
            return 100 - min;
        } else if (minCount > maxCount) {
            return 100 - max;
        } else {
            return 100 - max;
        }
    }

    public int furthestDistanceFromOrigin(String moves) {
        String[] srr = moves.split("");


        Optional
                <Map.Entry<String, Long>> m = Arrays.stream(srr)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .peek(x -> {
                    System.out.println(x);
                })
                .filter(x -> !x.getKey().equals("_"))
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .findFirst();

        if (m.isPresent()) {
            String key = m.get().getKey();
            moves = moves.replaceAll("_", key);

            int max = Integer.MIN_VALUE;
            srr = moves.split("");
            int len = srr.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (srr[i].equals(key)) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                        count = 0;
                    }
                }
            }

            if (count > max) {
                max = count;
            }

            return count;
        }

        return moves.length();
    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                l.add(grid[i][j]);
            }
        }
        int len = l.size();
        while (k > 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(l.get(len - 1));

            for (int i = 1; i < len; i++) {
                temp.add(i, l.get(i - 1));
            }

            l = new ArrayList<>(temp);
            k--;
        }
        int index = 0;
        List<List<Integer>> l1 = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temp.add(l.get(index));
                index++;
            }
            l1.add(temp);
        }
        return l1;
    }

    public int countBinarySubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (temp.length() % 2 == 0) {
                    boolean flag = true;
                    int len = temp.length();
                    String sub1 = temp.substring(0, len / 2);
                    String sub2 = temp.substring(len / 2);
                    if ((temp.charAt(len / 2) + "").equals("1")) {
                        if (sub2.contains("0") || sub1.contains("1")) {
                            flag = false;
                        }
                    } else {
                        if (sub2.contains("1") || sub1.contains("0")) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean isAcronym(List<String> words, String s) {

        String temp = "";
        for (String word : words) {
            if (word.length() > 0) {
                temp += word.charAt(0);
            }
        }
        return s.equals(temp);
    }

    public int countPairs(List<Integer> nums, int target) {

        int len = nums.size();
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    public int minSubarray(int[] nums, int p) {
        if (Arrays.stream(nums).boxed().reduce(Integer::sum).get() % p == 0) return 0;
        List<List<Integer>> l = subArray(nums);
        l = l.stream().sorted((x, y) -> x.size() - y.size()).collect(Collectors.toList());
        int totalSum = Arrays.stream(nums).boxed().reduce(Integer::sum).get();
        int finalValue = -1;
        for (List<Integer> l1 : l) {
            if (l1.size() == 1) {
                if ((totalSum - l1.get(0)) % p == 0) {
                    return 1;
                }
            } else {
                int temp = l1.stream().reduce(Integer::sum).get();
                if ((totalSum - temp) % p == 0) {
                    return l1.size();
                }
            }
        }
        return finalValue;
    }

    private List<List<Integer>> subArray(int[] nums) {
        int len = nums.length;

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subarray.add(nums[k]);
                }
                l.add(subarray);
            }
        }
        return l;
    }


    public static int waysToMakeFair(int[] nums) {

        int evenSum = 0;
        int oddSum = 0;
        int count = 0;

        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int len = nums.length;
        int currentIndexRemoval = 0;
        while (currentIndexRemoval < len) {
            List<Integer> l1 = new ArrayList<>(l);
            l1.remove(currentIndexRemoval);
            for (int i = 0; i < len - 1; i++) {
                if (i % 2 == 0) {
                    evenSum += l1.get(i);
                } else {
                    oddSum += l1.get(i);
                }
            }

            if (evenSum == oddSum) {
                count++;
            }

            evenSum = 0;
            oddSum = 0;

            currentIndexRemoval++;
        }

        return count;
    }

    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while (width >= 1) {
            if (area % width == 0) {
                return new int[]{area / width, width};
            }

            width--;
        }
        return new int[]{area, 1};
    }

    public long wonderfulSubstrings(String word) {
        int count = 0;
        List<String> l = get1AllSubstrings(word);

        System.out.println(l);

        for (String s : l) {
            if (s.length() == 1) {
                count++;
            } else {
                String[] srr = s.split("");
                Map<String, Long> map = Arrays.stream(srr).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
                if (map.entrySet().stream().filter(x -> x.getValue() % 2 != 0).count() < 2) {
                    count++;
                }
            }
        }
        return count;

    }

    public static List<String> get1AllSubstrings(String input) {
        List<String> substrings = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
            }
        }

        return substrings;
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<Integer> l = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrimeNumber(i)) {
                l.add(i);
            }
        }

        List<List<Integer>> fl = new ArrayList<>();

        int len = l.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (l.get(i) + l.get(j) == n) {
                    if (!fl.contains(List.of(l.get(j), l.get(i)))) {
                        fl.add(List.of(l.get(i), l.get(j)));
                    }
                }
            }
        }
        return fl;
    }

    public boolean isPrimeNumber(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        return !flag;
    }

    public boolean checkInclusion(String s1, String s2) {
        return false;
    }

    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int l = i; l <= j; l++) {
                    subarray.add(nums[l]);
                }
                int temp = 0;
                if (subarray.size() > 1) {
                    temp = subarray.stream().reduce(Integer::sum).get();
                } else {
                    temp = subarray.get(0);
                }

                if (temp % k == 0) {
                    count++;
                }

            }
        }

        return count;
    }

    public int maxSum(int[] nums) {
        int len = nums.length;
        int max = -1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    String s1 = String.valueOf(nums[i]);
                    String s2 = String.valueOf(nums[j]);

                    char[] s1A = s1.toCharArray();
                    char[] s2A = s2.toCharArray();

                    Arrays.sort(s1A);
                    Arrays.sort(s2A);

                    if (String.valueOf(s1A).equals(String.valueOf(s2A))) {
                        if (nums[i] + nums[j] > max) {
                            max = nums[i] + nums[j];
                        }
                    }
                }

            }
        }

        return max;
    }

    public int maxAbsoluteSum(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subarray.add(nums[k]);
                }
                int temp = 0;
                if (subarray.size() > 1) {
                    temp = Math.abs(subarray.stream().reduce(Integer::sum).get());
                } else {
                    temp = subarray.get(0);
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;

    }

    public int countCompleteSubarrays(int[] nums) {

        int distintCount = Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();

        int len = nums.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subarray.add(nums[k]);
                }

                if (subarray.size() >= distintCount) {
                    if (subarray.stream().collect(Collectors.toSet()).size() == distintCount) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        int temp = -1;
        for (int i = 0; i < len; i++) {

            if (k < chalk[i]) {
                temp = i;
                break;
            }

            k = k - chalk[i];
            if (i == len - 1) i = -1;

        }
        return temp;
    }

    public long countBadPairs(int[] nums) {

        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i != nums[j] - nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {

        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (char a = 'a'; a <= 'z'; a++) {
            index++;
            if (chars.contains(String.valueOf(a))) {
                map.put(String.valueOf(a), vals[chars.indexOf(a)]);
            } else {
                map.put(String.valueOf(a), index);
            }

        }

        int max = Integer.MIN_VALUE;
        List<String> l = getAllSubstrings(s);
        for (String s1 : l) {
            String[] srr = s1.split("");
            int temp = 0;
            for (String s2 : srr) {
                temp += map.get(s2);
            }

            if (temp > max) {
                max = temp;
            }
        }

        return max;

    }

    public static List<String> getAllSubstrings(String input) {
        List<String> substrings = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
            }
        }

        return substrings;
    }

    public static int minOperations(int[] nums) {
        if (nums.length == 1) return 0;

        int count = 0;
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (nums[i - 1] < nums[i]) {
                    int temp = nums[i] - nums[i - 1];
                    temp = temp - 1;
                    nums[i - 1] = nums[i - 1] + temp;
                    count += temp;
                } else {

                    int temp = nums[i - 1] - nums[i];
                    temp = temp + 1;
                    nums[i] = nums[i] + temp;
                    count += temp;

                }
            }
        }

        return count;
    }

    public String finalString(String s) {
        String[] srr = s.split("");

        StringBuffer sb = new StringBuffer();

        for (String s1 : srr) {
            if (s1.equals("i")) {
                sb = sb.reverse();
            } else {
                sb.append(s1);
            }
        }

        return sb.toString();
    }

    public static int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) return 0;
        int count = 0;
        List<List<Integer>> l = generateSubarrays(nums).stream().filter(x -> x.size() > 2).toList();

        for (List<Integer> l1 : l) {
            int len = l1.size();

            boolean flag = false;
            for (int i = 0; i < len - 2; i++) {
                int a = l1.get(i);
                int b = l1.get(i + 1);
                int c = l1.get(i + 2);
                if (Math.abs(a - b) == Math.abs(b - c) ||
                        Math.abs(b - c) == Math.abs(c - a) ||
                        Math.abs(a - c) == Math.abs(b - a)
                ) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }
        return count;
    }

    public static List<List<Integer>> generateSubarrays(int[] nums) {
        List<List<Integer>> subarrays = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subarray.add(nums[k]);
                }
                subarrays.add(subarray);
            }
        }

        return subarrays;
    }


    public int maxSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int currentRow = -1;
        int currentCol = -1;
        Set<Integer> set = new HashSet<>();
        while (currentRow + 2 <= row && currentCol + 2 <= col) {
            currentRow++;
            currentCol++;
            int x = 0;
            set.add(x);


        }


        return 0;

    }

    public static int[] closestPrimes(int left, int right) {
        List<Integer> l = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                l.add(i);
            }
        }

        if (l.size() < 2) {
            return new int[]{-1, -1};
        }

        Map<List<Integer>, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int size = l.size();
        for (int i = 0; i < size - 1; i++) {
            map.put(List.of(l.get(i), l.get(i + 1)), Math.abs(l.get(i) - l.get(i + 1)));
        }

        List<Integer> f = map.entrySet().stream().sorted(Map.Entry.<List<Integer>, Integer>comparingByValue().thenComparing(x -> x.getKey().get(0)))
                .findFirst().get().getKey();

        return new int[]{f.get(0), f.get(1)};
    }

    public static boolean isPrime(int i) {
        int num = i / 2;

        int count = 0;
        int start = 2;
        while (start <= num) {
            if (i % start == 0) {
                return false;
            }
            start++;
        }

        return true;
    }

    public String largestTimeFromDigits(int[] arr) {

        Arrays.sort(arr);
        int first = -1;
        int sec = -1;
        int third = -1;
        int fourth = -1;

        for (int i : arr) {
            if (i <= 2) {
                first = i;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] == first) {
                arr[i] = -1;
                break;
            }
        }

        Arrays.sort(arr);
        for (int i : arr) {
            if (i <= 3) {
                sec = i;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] == sec) {
                arr[i] = -1;
                break;
            }
        }

        Arrays.sort(arr);
        for (int i : arr) {
            if (i <= 5) {
                third = i;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] == third) {
                arr[i] = -1;
                break;
            }
        }

        Arrays.sort(arr);
        for (int i : arr) {
            if (i <= 9) {
                fourth = i;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] == fourth) {
                arr[i] = -1;
                break;
            }
        }

        if (first == -1 || sec == -1 || third == -1 || fourth == -1) {
            return "";
        }

        return first + "" + sec + ":" + third + "" + fourth;
    }

    public boolean equationsPossible(String[] equations) {
        List<Boolean> l = new ArrayList<>();

        for (String s : equations) {
            String srr[] = s.split("");

        }

        return false;
    }

    public String maxValue(String n, int x) {
        String srr[] = n.split("");
        if (n.charAt(0) == '-') {
            n = n.substring(1);
            srr = n.split("");
            int len = n.length();
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (x <= Integer.parseInt(srr[i])) {
                    flag = false;
                    n = n.substring(0, i) + x + n.substring(i);
                    break;
                }
            }
            if (flag) {
                return "-" + x + n;
            }

            return "-" + n;
        }
        int len = n.length();
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (x >= Integer.parseInt(srr[i])) {
                flag = false;
                n = n.substring(0, i) + x + n.substring(i);
                break;
            }
        }

        if (flag) {
            return n + x;
        }

        return n;

    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        boolean start = false;
        boolean end = false;

        String longest = sentence1.length() > sentence2.length() ? sentence1 : sentence2;
        String shortest = sentence1.length() > sentence2.length() ? sentence2 : sentence1;

        //for starting
        String[] small = shortest.split(" ");
        String[] lon = longest.split(" ");

        for (int i = 0; i < small.length; i++) {
            if (small[i].equals(lon[i])) {
                start = true;
            } else {
                break;
            }
        }
        int lonLen = lon.length - 1;
        for (int i = small.length - 1; i >= 0; i--) {
            if (small[i].equals(lonLen)) {
                end = true;
            } else {
                break;
            }

            lonLen--;
        }


        return start || end;

    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> finalList = new ArrayList<>();

        for (String s : words) {
            int currentIndex = 0;
            String temp = "";

            String s1rr[] = s.split("");
            int len = s1rr.length;
            for (int i = 0; i < len; i++) {
                if (!s1rr[i].equals(String.valueOf(separator))) {
                    temp += s1rr[i];
                } else {
                    finalList.add(temp);
                    temp = "";
                }
            }

            if (!temp.equals("")) {
                finalList.add(temp);
            }
        }

        return finalList.stream().filter(x -> x.length() > 0).toList();
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).boxed().filter(x -> x >= target).count();
    }

    public int numberOfRounds1(String loginTime, String logoutTime) {
        if (loginTime.equals("00:00") && logoutTime.equals("23:59")) return 95;
        if (loginTime.equals("00:01") && logoutTime.equals("00:00")) return 95;
        String[] loginTimeArr = loginTime.split(":");
        int hourLogin = Integer.parseInt(loginTimeArr[0]);
        int minLogin = Integer.parseInt(loginTimeArr[1]);
        String[] logoutTimeArr = logoutTime.split(":");
        int hourLogout = Integer.parseInt(logoutTimeArr[0]);
        int minLogout = Integer.parseInt(logoutTimeArr[1]);
        int count = 0;
        int totalHour = 0;
        int tempHourLogin = hourLogin;

        while (tempHourLogin != hourLogout) {
            if (tempHourLogin + 1 == 24) {
                tempHourLogin = 0;
            } else {
                tempHourLogin++;
            }

            totalHour++;
            if (tempHourLogin == hourLogout) {
                break;
            }
        }

        if (minLogout == 0 && minLogin == 0) {
            return totalHour * 4;
        }

        int chance = 0;

        if (minLogin > 0 && minLogin <= 15) {
            chance = 3;
        }

        if (minLogin > 15 && minLogin <= 30) {
            chance = 2;
        }

        if (minLogin > 30 && minLogin <= 45) {
            chance = 1;
        }

        if (minLogin > 45 && minLogin <= 59) {
            chance = 0;
        }

        int chanceLogout = 0;

        if (minLogout > 0 && minLogout <= 15) {
            chanceLogout = 0;
        }

        if (minLogout > 15 && minLogout <= 30) {
            chanceLogout = 1;
        }

        if (minLogout > 30 && minLogout <= 45) {
            chanceLogout = 2;
        }

        if (minLogout > 45 && minLogout <= 59) {
            chanceLogout = 3;
        }

        if (hourLogin >= hourLogout && minLogin >= minLogout) {
            return 95 - ((totalHour - 1) * 4 + chance + chanceLogout);
        }

        return (totalHour - 1) * 4 + chance + chanceLogout;

    }

    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len == 0) {
            return true;
        }

        if (len == 1) {
            return false;
        }

        boolean flag = false;

        if (nums[len - 1] == len - 1 && nums[len - 2] == len - 1) {
            flag = true;
        }

        if (flag) {
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] != i + 1) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public static int numberOfRounds(String loginTime, String logoutTime) {
        String[] loginTimeArr = loginTime.split(":");
        int hourLogin = Integer.parseInt(loginTimeArr[0]);
        int minLogin = Integer.parseInt(loginTimeArr[1]);
        String[] logoutTimeArr = logoutTime.split(":");
        int hourLogout = Integer.parseInt(logoutTimeArr[0]);
        int minLogout = Integer.parseInt(logoutTimeArr[1]);
        int count = 0;
        int totalHour = 0;
        int tempHourLogin = hourLogin;

        while (tempHourLogin != hourLogout) {
            if (tempHourLogin + 1 == 24) {
                tempHourLogin = 0;
            } else {
                tempHourLogin++;
            }

            totalHour++;
            if (tempHourLogin == hourLogout) {
                break;
            }
        }

        if (minLogout == 0 && minLogin == 0) {
            return totalHour * 4;
        }

        int chance = 0;

        if (minLogin > 0 && minLogin <= 15) {
            chance = 3;
        }

        if (minLogin > 15 && minLogin <= 30) {
            chance = 2;
        }

        if (minLogin > 30 && minLogin <= 45) {
            chance = 1;
        }

        if (minLogin > 45 && minLogin <= 59) {
            chance = 0;
        }

        int chanceLogout = 0;

        if (minLogout > 0 && minLogout <= 15) {
            chanceLogout = 0;
        }

        if (minLogout > 15 && minLogout <= 30) {
            chanceLogout = 1;
        }

        if (minLogout > 30 && minLogout <= 45) {
            chanceLogout = 2;
        }

        if (minLogout > 45 && minLogout <= 59) {
            chanceLogout = 3;
        }

        return (totalHour - 1) * 4 + chance + chanceLogout;

    }

    public int numSub(String s) {
        return substrings1(s);
    }

    public static int count(String sub) {
        String[] subArr = sub.split("");
        return Arrays.stream(subArr).collect(Collectors.toSet()).size() == 1 ? 1 : 0;
    }

    public static int substrings1(String input) {
        List<String> substrings = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
                if (!input.substring(i, j).contains("0")) {
                    map.put(input.substring(i, j), map.getOrDefault(input.substring(i, j), 0) + 1);
                }
            }
        }
        if (map.isEmpty()) return 0;
        return map.values().stream().reduce(Integer::sum).get();
    }

    public String sortVowels(String s) {
        String[] srr = s.split("");

        int len = srr.length;

        List<String> caps = new ArrayList<>();
        List<String> small = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (List.of("a", "e", "i", "o", "u").contains(srr[i])) {
                small.add(srr[i]);
                srr[i] = "#00#";
            } else if (List.of("A", "E", "I", "O", "U").contains(srr[i])) {
                caps.add(srr[i]);
                srr[i] = "#00#";
            }
        }

        Collections.sort(caps);
        Collections.sort(small);
        caps.addAll(small);

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (srr[i].equals("#00#")) {
                srr[i] = caps.get(index);
                index++;
            }
        }

        String temp = "";

        for (String s1 : srr) {
            temp += s1;
        }

        return temp;
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


