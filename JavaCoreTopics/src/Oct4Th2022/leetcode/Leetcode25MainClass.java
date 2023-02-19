package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  10/02/23
 */
public class Leetcode25MainClass {

    public static void main(String[] args) {
        /*Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});

        cashier.getBill(new int[]{1, 2}, new int[]{1, 2});                        // return 500.0. 1st customer, no discount.
        // bill = 1 * 100 + 2 * 200 = 500.
        cashier.getBill(new int[]{3, 7}, new int[]{10, 10});                      // return 4000.0. 2nd customer, no discount.
        // bill = 10 * 300 + 10 * 100 = 4000.
        cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1});    // return 800.0. 3rd customer, 50% discount.
        // Original bill = 1600
        // Actual bill = 1600 * ((100 - 50) / 100) = 800.
        cashier.getBill(new int[]{4}, new int[]{10});                           // return 4000.0. 4th customer, no discount.
        cashier.getBill(new int[]{7, 3}, new int[]{10, 10});                      // return 4000.0. 5th customer, no discount.
        cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7}); // return 7350.0. 6th customer, 50% discount.
        // Original bill = 14700, but with
        // Actual bill = 14700 * ((100 - 50) / 100) = 7350.
        cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2});     */               // return 2500.0.  6th customer, no discount.

        //hIndex(new int[]{1,3,1});
        //System.out.println(isPossibleDivide(new int[]{1, 1, 2, 2, 3, 3}, 2));
        //test("123".describeConstable());
        //System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        //System.out.println(Integer.parseInt("-2"));
        /*
        * An integer x. Record a new score of x.
                    '+'. Record a new score that is the sum of the previous two scores.
                    'D'.Record a new score that is the double of the previous score.
                    'C'.Invalidate the previous score, removing it from the record.
        * */

        //System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        //System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
        //getNoZeroIntegers(11);
        //System.out.println(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
        //construct2DArray(new int[]{1, 2}, 1, 1);
        //Stack<String> s = new Stack<>();
        //System.out.println("s : " + s.peek());
        //matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1);
        //System.out.println(makeFancyString("aaaaa"));
        //System.out.println(luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
        //int a[] = new int[]{1,10,4,2};
        //System.out.println(String.valueOf(a));
        //Input: arr = {91,4,64,78}, pieces = {{78},{4,64},{91}}
        System.out.println(canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        StringBuffer sb = new StringBuffer();
        for(int a : arr){
            sb.append(a + ",");
        }
        for(int[] a1 : pieces ){
            if(a1.length == 1){
                if(!sb.toString().contains(String.valueOf(a1[0]))){
                    return false;
                }
            }else{
                StringBuffer sb1 = new StringBuffer();
                for(int i : a1){
                    sb1.append(i+",");
                }

                if(!sb.toString().contains(sb1.toString())){
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> minInRow = new ArrayList<>();
        List<Integer> maxInCol = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        for(int[] i : matrix){
            minInRow.add(Arrays.stream(i).boxed().min(Integer::compareTo).orElse(0));
        }

        while(startCol < col){
            int max = Integer.MIN_VALUE;
            startRow = 0;
            while(startRow < row){
                if(matrix[startRow][startCol] > max){
                    max = matrix[startRow][startCol];
                }
                startRow++;
            }
            maxInCol.add(max);
            startCol++;
        }

        List<Integer> finalList = new ArrayList<>();

        minInRow.forEach(x -> {
            if(maxInCol.contains(x)){
                finalList.add(x);
            }
        });

        return finalList;
    }

    public static String makeFancyString(String s) {
        String srr[] = s.split("");
        Stack<String> stack = new Stack<>();

        int count = 0;
        String prevChr = srr[0];
        for (String s1 : srr) {
            if (count < 2 && prevChr.equals(s1)) {
                count++;
                stack.push(s1);
            } else {
                if (!prevChr.equals(s1)) {
                    stack.push(s1);
                    prevChr = s1;
                    count = 1;
                }
            }

        }

        System.out.println(stack);
        String finalAns = "";
        while (!stack.isEmpty()) {
            finalAns = stack.pop() + finalAns;
        }
        return finalAns;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int currRow = 0;
        int currCol = 0;

        while (true) {

        }
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int len = sandwiches.length;
        for (int i : students) {
            queue.add(i);
        }

        while (count != len) {

        }

        return 0;
    }

    public static String removeDuplicates(String s) {
        String[] srr = s.split("");
        Stack<String> stack = new Stack<>();

        for (String s1 : srr) {
            if (stack.isEmpty()) {
                stack.push(s1);
            } else {
                if (stack.peek().equals(s1)) {
                    stack.pop();
                } else {
                    stack.push(s1);
                }
            }
        }

        int l = stack.size();
        String s2 = "";
        while (l != 0) {
            s2 = stack.pop() + s2;
        }
        return s2;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int row = mat.length;
        int col = mat[0].length;

        if (row * col != r * c) {
            return mat;
        }

        if (row == r && col == c) {
            return mat;
        }
        int[][] finalArr = new int[r][c];
        int currRow = 0;
        int currCol = 0;
        for (int[] m : mat) {
            for (int n : m) {
                if (currRow < r) {
                    if (currCol < c) {
                        finalArr[currRow][currCol] = n;
                        currCol++;
                    } else {
                        currCol = 0;
                        currRow += 1;
                        finalArr[currRow][currCol] = n;
                        currCol += 1;
                    }
                }
            }
        }

        return finalArr;

    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] finalArr = new int[m][n];

        int i = 0;
        int j = 0;
        int currPointer = 0;
        int len = original.length;
        while (i < m) {
            j = 0;
            while (j < n) {
                finalArr[i][j] = original[currPointer];
                currPointer++;
                j++;
            }
            i++;
        }

        return finalArr;

    }

    public static long zeroFilledSubarray(int[] nums) {

        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // j is the number of elements which should be printed
            for (int j = i; j < nums.length; j++) {
                List<Integer> l1 = new ArrayList<>();
                // print the array from i to j
                for (int k = i; k <= j; k++) {
                    l1.add(nums[k]);
                }
                System.out.println(l1);
                l.add(l1);
            }
        }

        return 0;

    }

    public static int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                return new int[]{i, n - i};
            }
        }

        return null;
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {

        }
        return null;
    }

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Map.Entry<Integer, Integer> e = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).findFirst()
                .get();

        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // j is the number of elements which should be printed
            for (int j = i; j < nums.length; j++) {
                List<Integer> l1 = new ArrayList<>();
                // print the array from i to j
                for (int k = i; k <= j; k++) {
                    l1.add(nums[k]);
                }
                l.add(l1);
            }
        }

        l = l.stream().filter(x -> x.size() >= e.getValue()).collect(Collectors.toList());

        List<Integer> lens = new ArrayList<>();


        for (List<Integer> l1 : l) {
            if ((int) l1.stream().filter(x -> x == e.getKey()).count() == e.getValue()) {
                lens.add(l1.size());
            }
        }

        return lens.stream().sorted().findFirst().get();
    }

    public static int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String operation : operations) {
            if (operation.length() >= 2 || operation.matches("[0-9]+")) {
                list.add(Integer.parseInt(operation));
            } else {
                switch (operation) {
                    case "+":
                        int len = list.size();
                        list.add(list.get(len - 1) + list.get(len - 2));
                        break;
                    case "D":
                        len = list.size();
                        list.add(list.get(len - 1) * 2);
                        break;
                    case "C":
                        len = list.size();
                        list.remove(len - 1);
                        break;
                }
            }
        }
        return list.size() == 0 ? 0 : list.stream().reduce(Integer::sum).get();
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.get(5) + 1);
            } else if (bill == 10 && map.get(5) >= 1) {
                map.put(5, map.get(5) - 1);
                map.put(10, map.get(10) + 1);
            } else if (bill == 20) {
                if (map.get(5) != 0 && map.get(10) != 0) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                } else if (map.get(5) >= 3) {
                    map.put(5, map.get(5) - 3);
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;

    }

    public static List<List<Integer>> largeGroupPositions(String s) {

        String[] srr = s.split("");
        int len = srr.length;
        int count = 1;
        String currString = srr[0];
        int sIndex = 0;
        int lIndex = 0;
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (currString.equals(srr[i])) {
                count++;
            } else {
                if (count >= 3) {
                    l.add(List.of(sIndex, i - 1));
                }
                count = 1;
                currString = srr[i];
                sIndex = i;
            }
        }

        if (count >= 3) {
            l.add(List.of(sIndex, len - 1));
        }

        //System.out.println(l);
        return l;

    }

    private static void test(Optional<String> s) {
        if (s.isEmpty()) {
            System.out.println("s is empty");
            System.out.println(s.get());
        } else {
            System.out.println(s.get());
        }
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());

        while (l.size() != 0) {
            Set<Integer> s = new TreeSet<>(l);
            List<Integer> l1 = s.stream().toList();

            int len = k;
            for (int i = 0; i < k - 1; i++) {
                if (l1.size() < (2)) {
                    return false;
                }
                if (l1.get(i) - l1.get(i + 1) != -1) {
                    return false;
                } else {
                    l.remove(new Integer(l1.get(i)));
                }
            }
            l.remove(new Integer(l1.get(k - 1)));
        }
        return true;
    }

    public int distinctIntegers(int n) {
        if (n == 1) return 1;
        return n - 1;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        List<Integer> l = Arrays.stream(citations).boxed().collect(Collectors.toList());
        List<Integer> l1 = new ArrayList<>();
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            int finalI = i;
            int countEqualOrGreater = (int) l.stream().filter(x -> x >= citations[finalI]).count();
            int countLess = (int) l.stream().filter(x -> x <= citations[finalI]).count();

            if (citations[i] == countEqualOrGreater && (len - countEqualOrGreater == countLess - 1)) {
                l1.add(citations[i]);
            }
        }

        return l1.stream().sorted(Comparator.reverseOrder()).findFirst().get();

    }

    public int numberOfSubarrays(int[] nums, int p) {

        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // j is the number of elements which should be printed
            for (int j = i; j < nums.length; j++) {
                List<Integer> l1 = new ArrayList<>();
                // print the array from i to j
                for (int k = i; k <= j; k++) {
                    l1.add(nums[k]);
                }
                l.add(l1);
            }
        }
        int count = 0;
        l = l.stream().filter(x -> x.size() > p).collect(Collectors.toList());
        for (List<Integer> l2 : l) {
            if (l2.stream().filter(t -> t % 2 != 0).count() == p) {
                count++;
            }
        }
        return count;
    }

    public int[] separateDigits(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int num : nums) {
            if (num < 10) {
                l.add(num);
            } else {
                List<Integer> l1 = new ArrayList<>();
                while (num != 0) {
                    l1.add(0, num % 10);
                    num = num / 10;
                }
                l.addAll(l1);
            }
        }

        return l.stream().mapToInt(x -> x).toArray();
    }
}


class Cashier {

    int n;
    int discount;
    List<Integer> products;
    List<Integer> prices;
    int i = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = Arrays.stream(products).boxed().toList();
        this.prices = Arrays.stream(prices).boxed().toList();
    }

    public double getBill(int[] product, int[] amount) {
        double sum = 0.0;
        i += 1;
        int len = product.length;
        for (int i = 0; i < len; i++) {
            sum += amount[i] * prices.get(products.indexOf(product[i]));
        }

        if (i == 3) {
            sum = sum * ((100d - Double.valueOf(discount)) / 100d);
            i = 0;
        }

        return sum;
    }
}

class AuthenticationManager {
    int time;
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        time = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + time);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            map.put(tokenId, currentTime + time);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) map.entrySet().stream().filter(x -> x.getValue() > currentTime).count();
    }
}
