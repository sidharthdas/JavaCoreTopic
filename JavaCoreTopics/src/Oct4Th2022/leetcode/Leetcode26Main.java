package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode26Main {

    public static void main(String[] args) {
        //Bitset b = new Bitset(5);
        waysToBuyPensPencils(20, 10, 5);
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if(properties[j][0] > properties[i][0] && properties[j][1] > properties[i][1]){
                        count ++;
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
