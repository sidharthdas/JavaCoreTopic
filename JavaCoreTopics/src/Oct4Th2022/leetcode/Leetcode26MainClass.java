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
        System.out.println(minOperations(new int[]{1, 5, 2, 4, 1}));
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


