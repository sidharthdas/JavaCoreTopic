package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  08/10/22
 */
public class LeetcodeMain5 {

    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public static boolean checkDistances(String s, int[] distance) {
        String[] srr = s.split("");
        int len = srr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {

            String s1 = srr[i];

            boolean flag = false;
            for (int j = i + 1; j < len; j++) {
                if (j < len) {
                    if (!s1.equals(srr[j])) {
                        count++;
                    } else {
                        if (distance[i] != count) {
                            return false;
                        } else {
                            count = 0;
                            break;
                        }
                    }
                }
                if(j == len - 1){
                    if(count != 0 && distance[i] ==0){
                        count = 0;

                    }else{
                        return false;
                    }
                }
            }

            /*if(distance[i] != 0 && count == 0){
                return false;
            }*/
        }
        if(distance[len -1] != count){
            return false;
        }

        return true;
    }

    public int bitwiseComplement(int n) {

        String s = Integer.toBinaryString(n);
        String comS = "";
        String[] srr = s.split("");

        for (String s1 : srr) {
            if (s1.equals("0")) {
                comS += "1";
            } else {
                comS += "0";
            }
        }

        return Integer.parseInt(comS, 2);

    }

    public int maxArea(int[] height) {
        // Todo: Implement computeSnowpack

        int size = height.length;
        int first = height[0];
        int second = height[1];
        int prev = 0;
        int firstIndex = 0;
        if (first < second) {
            for (int i = 2; i < size; i++) {
                if (height[i] >= second) {
                    second = height[i];
                    firstIndex = i;
                } else {
                    break;
                }
            }

        } else {
            second = first;
        }
        int lastIndex = size - 1;
        int fromLastEqualOrGreater = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            if (height[i] >= fromLastEqualOrGreater) {
                fromLastEqualOrGreater = height[i];
                lastIndex = i;
            } else {
                break;
            }
        }

        System.out.println("First highest Number  :" + second + " with index :" + firstIndex);
        System.out.println("Last highest/equal Number  :" + fromLastEqualOrGreater + " with index :" + lastIndex);

        int totalIce = 0;

        for (int i = firstIndex + 1; i < lastIndex; i++) {
            if (second - height[i] > 0) {
                totalIce += (second - height[i]);
            }
        }
        System.out.println("Total ice: " + totalIce);
        return totalIce;
    }

    public int xorOperation(int n, int start) {
        int xor = 0;

        for (int i = 0; i < n; i++) {
            int val = start + 2 * i;
            xor = xor ^ val;
        }
        return xor;

    }

    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((i * i) == ((j * j) + (k * k))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countEven(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (i < 9) {
                if (i % 2 == 0) {
                    count++;
                }
            } else {
                if (checkPrimeNumber(i)) {
                    count++;
                }
            }
        }

        return count;

    }

    private boolean checkSumEven(int number) {
        int sum = 0;
        while (number > 0) {
            int a = number % 10;
            sum = sum + a;
            number = number / 10;
        }

        return sum % 2 == 0;

    }

 /*   int number; // = some int

while (number > 0) {
        print( number % 10);
        number = number / 10;
    }*/

    static int printSubsets(int num[]) {
        int xor = 0;
        int sum = 0;

        int n = num.length;


        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {

                if ((i & (1 << j)) > 0)
                    xor = xor ^ num[j];
            }

            sum = sum + xor;
            xor = 0;
        }
        return sum;

    }

    public boolean equalFrequency(String word) {
        String[] srr = word.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String s : srr) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }


        int first = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new)).entrySet()
                .stream().findFirst().get().getValue();

        int last = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new)).entrySet()
                .stream().findFirst().get().getValue();

        if ((last - first) == 1) {
            return true;
        }
        if (last == 1 && first == 1) {
            return true;
        }
        return false;
    }

    public boolean validPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();

        int len = s.length();
        String[] str = s.split("");
        for (String s1 : str) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }

        long l = map.entrySet().stream().filter(x -> x.getValue() % 2 != 0).count();

        if (len % 2 == 0 && l == 0) {
            return true;
        }
        if (len % 2 != 0 && l == 1) {
            return true;
        }

        if (len % 2 == 0 && l == 2) {
            return true;
        }
        if (len % 2 != 0 && l == 1) {
            return true;
        }

        return false;


    }

    public int countKDifference(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; i < len; i++) {
                if (i != j) {
                    int tar = nums[i] - nums[j];
                    if (tar >= 0) {
                        if (tar == k) {
                            count++;
                        }
                    } else {
                        if ((-1 * tar) == k) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int countPrimes(int n) {
        int count = 0;
        int start = 2;
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }

        while (start < n) {
            if (checkPrimeNumber(start)) {
                count++;
            }
            start++;
        }

        return count;

    }

    private boolean checkPrimeNumber(int n) {
        int i, m = 0, flag = 0;
        m = n / 2;
        for (i = 2; i <= m; i++) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return true;
        }


        return false;
    }

    public int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        return removeAlternate(list, true);

    }

    private int removeAlternate(List<Integer> l, boolean flag) {
        if (l.size() == 1) {
            return l.get(0);
        }
        List<Integer> list = new ArrayList<>();
        int len = l.size();
        if (flag) {
            for (int i = 0; i < len; i++) {
                if (i % 2 != 0) {
                    list.add(l.get(i));
                }
            }
        } else {

            for (int i = len - 2; i >= 0; i = i - 2) {
                list.add(0, l.get(i));
            }

        }
        flag = flag == true ? false : true;
        return removeAlternate(list, flag);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Set<Row> rowList = new TreeSet<>();
        int count = 0;
        for (int m[] : mat) {
            int sum = Arrays.stream(m).boxed().reduce(Integer::sum).get();
            rowList.add(new Row(count, sum));
            count++;
        }

        int[] fArr = new int[k];

        int i = 0;
        List<Row> l = rowList.stream().toList();
        while (i <= k) {
            fArr[i] = l.get(i).getRowId();
        }

        return fArr;
    }
}

class Row implements Comparable<Row> {
    private int rowId;
    private int rowCount;

    public Row(int rowId, int rowCount) {
        this.rowId = rowId;
        this.rowCount = rowCount;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return rowId == row.rowId && rowCount == row.rowCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowId, rowCount);
    }


    @Override
    public int compareTo(Row o) {
        return this.rowCount - o.rowCount;
    }
}