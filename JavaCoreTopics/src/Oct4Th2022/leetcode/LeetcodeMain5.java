package Oct4Th2022.leetcode;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  08/10/22
 */
public class LeetcodeMain5 {

    public static void main(String[] args) {
        /*LeetcodeMain5 leetcodeMain5 = new LeetcodeMain5();
        System.out.println(leetcodeMain5.lastRemaining(9));*/
        List<Integer> l = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            l.add(0, i);
        }

        System.out.println(l);
    }

    public boolean validPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();

        int len = s.length();
        String[] str = s.split("");
        for(String s1 : str){
            if(map.containsKey(s1)){
                map.put(s1, map.get(s1) + 1);
            }else{
                map.put(s1, 1);
            }
        }

        long l = map.entrySet().stream().filter(x -> x.getValue() % 2 != 0).count();

        if(len % 2 == 0 && l == 0){
            return true;
        }
        if(len % 2 != 0 && l == 1){
            return true;
        }

        if(len % 2 == 0 && l == 2){
            return true;
        }
        if(len % 2 != 0 && l == 1){
            return true;
        }

        return false;



    }

    public int countKDifference(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; i < len; i++) {
                if(i != j){
                    int tar =  nums[i] - nums[j];
                    if(tar >=0){
                        if(tar == k){
                            count++;
                        }
                    }else{
                        if((-1 * tar) == k){
                            count ++;
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