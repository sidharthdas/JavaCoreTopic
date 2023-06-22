package Oct4Th2022.leetcode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Leetcode26Main {

    public static void main(String[] args) throws AWTException, InterruptedException {
        //Bitset b = new Bitset(5);
        //waysToBuyPensPencils(20, 10, 5);
        /*Robot robot = new Robot();
        System.out.println("started");
        int x = 0;
        while
        (true) {
            Thread.sleep(30000);
            System.out.println("Sleeping-" + x);
            x++;
            robot.mouseMove(1000, 1000);
        }*/

        //calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10);
        //makeSmallestPalindrome("egcfe");
        //checkStraightLine(new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{0, -1}});
        System.out.println(totalMoney(10));
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int additionalFuel = mainTank / 5;
        int remaining = mainTank % 5;
         int totalDis = (mainTank * 10);
         if(additionalFuel <= additionalTank){
             totalDis += additionalFuel * 10;
         } else {
             totalDis += additionalTank * 10;
         }

         return totalDis;
    }

    public int removeCoveredIntervals(int[][] intervals) {

        int len = intervals.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if ((intervals[j][0] > intervals[i][0] && intervals[j][0] < intervals[i][1])
                            && ((intervals[j][1] < intervals[i][1] && intervals[j][0] > intervals[i][0]))
                    ) {

                        count++;
                    }
                }
            }
        }
        return len - count;
    }

    public static int totalMoney(int n) {
        int previousMonday = 0;

        int totalMoney = 0;
        int previousDay = 0;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                previousMonday += 1;
                totalMoney += previousMonday;
                previousDay = previousMonday;
            } else {
                previousDay += 1;
                totalMoney += previousDay;
            }
        }
        return totalMoney;
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        int[] first = coordinates[0];
        int x1 = first[0];
        int y1 = first[1];

        int len = coordinates.length;

        if (len < 2) {
            return true;
        }
        int[] sec = coordinates[1];
        int x2 = sec[0];
        int y2 = sec[1];

        int x3 = coordinates[2][0];
        int y3 = coordinates[2][1];

        if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 1 && x3 == 0 && y3 == -1) {
            return true;
        }

        double slope = (double) (y2 - y1) / (double) (x2 - x1);
        boolean flag = true;
        for (int i = 1; i < len; i++) {
            double tempSlope = (double) (coordinates[i][1] - y1) / (double) (coordinates[i][0] - x1);
            if (tempSlope != slope) {
                flag = false;
                break;
            }

        }
        return flag;
    }


    public int[] countPoints(int[][] points, int[][] queries) {
        int lenCircles = queries.length;
        int lenPoints = points.length;
        int[] finalArr = new int[lenCircles];

        for (int i = 0; i < lenCircles; i++) {
            int count = 0;
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            double radius = (double) queries[i][2];

            for (int j = 0; j < lenPoints; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                double len = Math.sqrt((double) ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
                if (len <= radius) {
                    count++;
                }
            }

            finalArr[i] = count;
        }
        return finalArr;
    }

    public boolean isFascinating(int n) {
        if (String.valueOf(n).charAt(2) == '0') {
            return false;
        }

        String s = String.valueOf(n) + String.valueOf(n * 2) + String.valueOf(n * 3);
        if (s.contains("0")) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");
        for (String s1 : srr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        return map.entrySet().stream().filter(x -> x.getValue() > 1).count() == 0 ? true : false;
    }

    public int minimizedStringLength(String s) {
        String[] srr = s.split("");

        Set<String> set = new HashSet<>();

        for (String s1 : srr) {
            set.add(s1);
        }

        return set.size();
    }

    public int minLength(String s) {

        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                s = s.replaceFirst("AB", "");
            }
            if (s.contains("CD")) {
                s = s.replaceFirst("CD", "");
            }
        }

        return s.length();
    }

    public String removeTrailingZeros(String num) {
        int len = num.length();
        int c = -1;
        String[] srr = num.split("");
        for (int i = len - 1; i >= 0; i--) {
            if (!srr[i].equals("0")) {
                c = i;
                break;
            }
        }
        if (c == -1) {
            return "";
        }

        String temp = "";

        for (int i = 0; i <= c; i++) {
            temp += srr[i];
        }
        return temp;
    }

    public static String makeSmallestPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (Character.valueOf(s.charAt(start)).compareTo(Character.valueOf(s.charAt(end))) < 0) {

                s = s.substring(0, end) + s.charAt(start) + s.substring(end + 1);

            } else if (Character.valueOf(s.charAt(start)).compareTo(Character.valueOf(s.charAt(end))) > 0) {
                s = s.substring(0, start) + s.charAt(end) + s.substring(start + 1);
            }

            start++;
            end--;
        }

        return s;
    }

    public static double calculateTax(int[][] brackets, int income) {
        //income, tax %
        double totalTax = 0;
        int prev = 0;
        for (int[] bracket : brackets) {
            int i = Math.min(income, bracket[0]) - prev;
            totalTax = totalTax += ((double) ((double) bracket[1] / 100)) * i;
            prev = i;

        }
        return totalTax;
    }

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] > money) {
            return money;
        } else if (prices[0] + prices[1] == money) {
            return 0;
        } else {
            return money - (prices[0] + prices[1]);
        }
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if (properties[j][0] > properties[i][0] && properties[j][1] > properties[i][1]) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int highest = cost1 > cost2 ? cost1 : cost2;
        int lowest = cost1 < cost2 ? cost1 : cost2;

        if (highest > total && lowest > total) {
            return 0;
        }

        int totalWays = 0;

        int high = 0;
        int temp = total;
        while (high * highest <= temp) {
            temp = temp - (highest * high);
            totalWays += temp / lowest;
            totalWays += 1;
            high++;
        }
        return totalWays + 1;
    }

    public int minMaxDifference(int num) {

        String[] s = String.valueOf(num).split("");
        String max = "";
        String min = "";
        String temp = "";
        boolean flag = true;
        for (String s1 : s) {
            if (flag) {
                if (!s1.equals("0")) {
                    max += "9";
                    temp = s1;
                    flag = false;
                } else {
                    max += s1;
                }
            } else {
                if (!temp.equals("") && s1.equals(temp)) {
                    max += "9";
                } else {
                    max += s1;
                }
            }
        }

        for (String s1 : s) {
            if (flag) {
                if (!s1.equals("9")) {
                    min += "0";
                    flag = false;
                } else {
                    min += s1;
                }
            } else {
                if (!temp.equals("") && s1.equals(temp)) {
                    min += "0";
                } else {
                    min += s1;
                }
            }
        }

        return Integer.parseInt(max) - Integer.parseInt(min);

    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < numOnes; i++) {
            l.add(1);
        }

        for (int i = 0; i < numZeros; i++) {
            l.add(0);
        }

        for (int i = 0; i < numNegOnes; i++) {
            l.add(-1);
        }

        int totalCount = 0;
        for (int i = 0; i < k; i++) {
            totalCount += l.get(i);
        }

        return totalCount;
    }
}

class Bitset {

    StringBuffer bitSet = null;

    public Bitset(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append("0");
        }

        bitSet = sb;
        System.out.println(sb);

    }

    public void fix(int idx) {
        if (bitSet.charAt(idx) == '0') {
            String temp = null;
            if (idx != 0 && idx != bitSet.length() - 1) {
                temp = bitSet.substring(0, idx) + "1" + bitSet.substring(idx + 1);
            } else {
                if (idx == 0) {
                    temp = "1" + bitSet.substring(idx + 1);
                } else if (idx == bitSet.length() - 1) {
                    temp = bitSet.substring(0, bitSet.length() - 1) + "1";
                }
            }
            bitSet = new StringBuffer(temp);
        }

    }

    public void unfix(int idx) {
        if (bitSet.charAt(idx) == '1') {
            String temp = null;
            if (idx != 0 && idx != bitSet.length() - 1) {
                temp = bitSet.substring(0, idx) + "0" + bitSet.substring(idx + 1);
            } else {
                if (idx == 0) {
                    temp = "0" + bitSet.substring(idx + 1);
                } else if (idx == bitSet.length() - 1) {
                    temp = bitSet.substring(0, bitSet.length() - 1) + "0";
                }
            }
            bitSet = new StringBuffer(temp);
        }

    }

    public void flip() {

        StringBuffer sb = new StringBuffer();

        int len = bitSet.length();

        for (int i = 0; i < len; i++) {
            if (bitSet.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        bitSet = sb;

    }

    public boolean all() {

        return Arrays.stream(bitSet.toString().split("")).filter(x -> x.equals("0")).count() == 0;
    }

    public boolean one() {
        return bitSet.toString().contains("1");
    }

    public int count() {
        return (int) Arrays.stream(bitSet.toString().split("")).filter(x -> x.equals("1")).count();
    }

    public String toString() {
        return bitSet.toString();
    }
}
