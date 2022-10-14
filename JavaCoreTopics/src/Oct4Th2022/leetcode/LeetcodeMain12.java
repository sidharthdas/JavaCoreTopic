package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  14/10/22
 */
public class LeetcodeMain12 {

    public static void main(String[] args) {
        //arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3);
        //countPairs(new int[]{3,1,2,2,2,1,3}, 2);
        //flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
        //numberOfPairs(new int[]{1,3,2,1,3,2,2});
        //checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        //digitSum("11111222223", 3);
        //countLargestGroup(13);
        firstMissingPositive(new int[]{2147483647});
    }

    public int maximumGap(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int len = nums.length;
        int high = Integer.MIN_VALUE;
        int prevNum = nums[0];
        for(int i = 1; i < len; i++){
            int h = nums[i] - prevNum;
            if(high < h){
                high = h;
            }
            prevNum = nums[i];
        }
        return high;

    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> l = new TreeSet<>();
        for (int i : nums) {
            if (i > 0) {
                l.add(i);
            }
        }
        //Collections.sort(l, Collections.reverseOrder());
        int len = l.size();
        int higst = l.stream().toList().get(len - 1);

        for (int i = 1; i <= higst; i++) {
            if (!l.contains(i)) {
                return i;
            }
        }
        return higst + 1;
    }

    public int largestPerimeter(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().sorted().toList();
        int largest = 0;
        int seclargest = 0;
        int len = l.size();
        for (int i = len - 1; i > 2; i++) {
            int a = l.get(len - 1);
            int b = l.get(len - 2);
            int c = l.get(len - 3);

            if (a > b) {

            }

        }

        return 0;
    }

    public int countElements(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().toList();
        int len = nums.length;
        int count = 0;

        for (int i : nums) {
            if (l.stream().filter(x -> x > i).count() != 0 &&
                    l.stream().filter(x -> x < i).count() != 0) {
                count++;
            }

        }
        return count;
    }

    public static int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = sum(i);
            List<Integer> l = map.getOrDefault(sum, new ArrayList<>());
            l.add(i);
            map.put(sum, l);
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        map.entrySet().forEach(x -> {
            map1.put(x.getKey(), x.getValue().size());
        });

        int lar = map1.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .findFirst().get().getValue();

        return (int) map1.entrySet().stream().filter(x -> x.getValue() == lar).count();

    }

    private static int sum(int number) {
        int digit, sum = 0;
        while (number > 0) {
            digit = number % 10;
            sum = sum + digit;
            number = number / 10;
        }

        return sum;
    }

    public int countPoints(String rings) {
        Map<String, String> map = new HashMap<>();
        String s[] = rings.split("");
        int len = s.length;
        //B0B6G0R6R0R6G9
        for (int i = 0; i < len; i += 2) {
            map.put(s[i + 1], map.getOrDefault(s[i + 1], "") + s[i]);
        }

        return (int) map.entrySet().stream().filter(x -> x.getValue().contains("B") && x.getValue().contains("G") && x.getValue().contains("R"))
                .count();

    }

    public String reformatNumber(String number) {
        number = number.replace(" ", "").replace("-", "");
        int len = number.length();
        String[] num = number.split("");
        String s = "";
        int count = 0;
        String finalString = "";
        for (int i = 0; i < len; i++) {
            if (count < 3) {
                s += num[i];
                count++;
            } else {
                finalString += s + "-";
                count = 1;
                s = num[i];
            }
        }

        finalString += s;

        return finalString;

    }

    public static String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }

        String s1 = "";
        String[] srr = s.split("");
        int len = srr.length;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (count < k) {
                sum += Integer.parseInt(srr[i]);
                count++;
            } else {
                s1 += sum;
                count = 1;
                sum = Integer.parseInt(srr[i]);
            }
        }
        s1 += sum;

        return digitSum(s1, k);
    }

    public static String removeDuplicates(String s) {
        String[] srr = s.split("");
        String prev = srr[0];
        StringBuilder s1 = new StringBuilder(srr[0]);
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
                    s1 = new StringBuilder(srr[i]);
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

    public int findMiddleIndex(int[] nums) {
        int len = nums.length;
        int validindex = -1;

        for (int i = len - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < i; j++) {

            }
        }
        return 0;
    }


    public static boolean checkDistances(String s, int[] distance) {
        String[] srr = s.split("");
        int len = srr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!srr[i].equals(srr[j])) {
                    count++;
                } else {
                    break;
                }

            }

            if (distance[i] != count) {
                if (s.substring(i).length() - 1 != count) {
                    return false;
                } else {
                    if (distance[i] != 0) {
                        return false;
                    }
                }

            }
            count = 0;
        }

        return true;
    }


    public static int[] numberOfPairs(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Integer c = new Integer(0);
        for (int i : nums) {
            l.add(i);
        }
        l = unique(l, c);
        int len = l.size();
        return new int[]{l.get(len - 1), len - 1};
    }


    public static List<Integer> unique(List<Integer> l, Integer count) {
        int len = l.size();
        int index1 = -1;
        int index2 = -1;
        boolean flag = true;
        for (int i : l) {
            if (l.indexOf(i) != l.lastIndexOf(i)) {
                flag = false;
                index1 = l.indexOf(i);
                index2 = l.lastIndexOf(i);
                break;
            }
        }
        if (!flag) {
            flag = true;
            l.remove(index1);
            l.remove(index2 - 1);
            return unique(l, count + 1);
        } else {
            l.add(count);
            return l;
        }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int len = image.length;
        int[][] n = new int[len][len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {
                if (image[i][j] == 0) {
                    n[i][count] = 1;
                } else {
                    n[i][count] = 0;
                }
                count++;
            }
            count = 0;
        }

        return n;


    }

    public static int countPairs(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    public int countKDifference(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int num = nums[i] - nums[j];
                if (num < 0) {
                    if ((-1) * num == k) {
                        count++;
                    }
                } else {
                    if (num == k) {
                        count++;
                    }
                }
            }

        }
        return count;
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = 0; k < len; i++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        count++;
                    }

                }

            }

        }
        return count;
    }

    class RandomizedCollection {

        List<Integer> l;

        public RandomizedCollection() {
            l = new ArrayList<>();

        }

        public boolean insert(int val) {
            boolean flag = l.contains(val);
            l.add(val);
            return flag;
        }

        public boolean remove(int val) {
            boolean flag = l.contains(val);
            l.remove(new Integer(val));
            return flag;

        }

        public int getRandom() {
            Random rand = new Random();
            rand.ints(0, l.size() -1);
            return l.get(rand.nextInt());

        }
    }
}
