package Oct4Th2022.leetcode;

import java.util.*;
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
        shortestToChar("loveleetcode", 'e');

    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        count = count.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int half = arr.length/2;
        Set<Integer> s = new TreeSet<>();
        for (Map.Entry<Integer, Integer> m : count.entrySet()) {
            half -= m.getValue();
            s.add(m.getKey());
            if(half <= 0){
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
}