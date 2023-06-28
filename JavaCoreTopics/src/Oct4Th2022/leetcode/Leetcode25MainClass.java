package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  10/02/23
 */

record Alien(String alienId, String alienName) {

    //This has a capalibity that it automatically implemented equals and hascode
    //It doesnt have setter, as it is just use to send and access the data
    public Alien(String alienId) { //constructor with one argument
        this(alienId, null);
    }
}

public class Leetcode25MainClass {

    public static void main(String[] args) {

        Alien a1 = new Alien("1", "Sid");
        Alien a2 = new Alien("2");
        System.out.println(a1);
        System.out.println(a2);

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
        //System.out.println(canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
        //System.out.println(makeGood("leEeetcode"));
        //char c = 'a';
        //  System.out.println(String.valueOf(c));
        //System.out.println(checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        //System.out.println(longestNiceSubstring("qQUjJ"));
        //System.out.println(shortestToChar("loveleetcode", 'e'));
        //System.out.println(gcdOfStrings("ABCABC", "ABC"));
        //str1 = "ABCABC", str2 = "ABC"
        //s = "ab#c", t = "ad#c"
        //s = "ab##", t = "c#d#"
        //System.out.println(backspaceCompare("ab##", "c#d#"));
        //System.out.println(validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
        //System.out.println(onesMinusZeros(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}}));
        //System.out.println(equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        //System.out.println(diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}));
        //System.out.println(searchMatrix(new int[][]{{-9, -9, -9, -8, -8, -7, -6, -4, -4, -3}, {0, 1, 2, 2, 4, 5, 5, 5, 7, 9}, {12, 12, 14, 14, 15, 17, 19, 19, 19, 21}, {22, 23, 23, 25, 25, 26, 26, 28, 28, 29}, {31, 31, 31, 33, 34, 36, 37, 38, 38, 39}, {40, 42, 43, 44, 46, 46, 46, 47, 49, 50}, {52, 54, 55, 57, 59, 60, 60, 62, 64, 66}, {68, 68, 70, 71, 71, 72, 74, 76, 78, 80}, {82, 83, 85, 85, 85, 87, 88, 88, 89, 89}, {90, 90, 90, 91, 93, 94, 94, 95, 95, 97}, {98, 98, 99, 99, 101, 103, 105, 106, 108, 109}, {112, 112, 112, 113, 113, 113, 114, 116, 118, 118}, {119, 121, 122, 124, 125, 125, 125, 126, 127, 128}, {131, 133, 134, 134, 134, 135, 135, 137, 137, 139}, {141, 143, 145, 147, 148, 150, 150, 150, 150, 152}, {153, 153, 154, 155, 157, 157, 157, 159, 161, 162}, {164, 166, 167, 167, 167, 169, 170, 170, 171, 173}, {176, 176, 178, 179, 181, 182, 183, 183, 184, 186}}, 135));
        //System.out.println(findDiagonalOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}}));
        //System.out.println( findKthBit(5, 16));
        System.out.println(findLongestWord("abpcplea", List.of("ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa").stream().collect(Collectors.toList())));
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int len = words.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    StringBuffer sb = new StringBuffer(words[j]);
                    if(words[i].equals(sb.reverse().toString())){
                        count++;
                    }
                }
            }
        }

        return count/2;
    }


    public int numFriendRequests(int[] ages) {
        //List<Integer> l = Arrays.stream(ages).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int len = ages.length;
        int count = 0;
        Arrays.sort(ages);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if (ages[i] == ages[j]) {
                        count++;
                    } else {
                        boolean flag = true;

                        if (ages[j] <= 0.5 * ages[i] + 7) {
                            flag = false;
                        } else if (ages[j] > ages[i]) {
                            flag = false;
                        } else if (ages[j] > 100 && ages[i] < 100) {
                            flag = false;
                        }

                        if (flag) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        int highestLen = Integer.MIN_VALUE;
        int lowDeletion = Integer.MAX_VALUE;
        Collections.sort(dictionary, (s1, s2) -> s2.length() - s1.length());
        List<String> l = new ArrayList<>();
        String finalString = "";
        int charCount = 0;
        for (String word : dictionary) {
            String tempWord = s;
            String[] srr = word.split("");
            boolean flag = true;
            for (String s1 : srr) {
                if (tempWord.contains(s1)) {
                    tempWord = tempWord.replaceFirst(s1, "#");
                    charCount++;
                } else {
                    flag = false;
                    charCount = 0;
                    break;
                }
            }

            if (flag) {
                if (word.length() > highestLen) {
                    highestLen = word.length();
                }
                map.put(word, s.length() - word.length());
                l.add(word);
                charCount = 0;
                if (lowDeletion > s.length() - word.length()) {
                    lowDeletion = s.length() - word.length();
                }
            }

        }
        int finalHighestLen = highestLen;
        int finalLowDeletion = lowDeletion;
        return l.size() == 0 ? "" : (l.size() == 1 ? l.get(0) :
                map.entrySet()
                        .stream()
                        .filter(x -> x.getValue() == finalLowDeletion)
                        .map(x -> x.getKey())
                        .sorted(Comparator
                                .comparingInt(String::length)
                                .reversed()
                                .thenComparing(Comparator.naturalOrder()))
                        .findFirst()
                        .get()
        );
    }

    public int[] maximumBeauty1(int[][] items, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] item : items) {
            map.put(item[0], map.getOrDefault(item[0], 0)
                    > item[1] ? map.getOrDefault(item[0], 0) : item[1]);
        }
        int len = queries.length;
        int[] finalResult = new int[len];
        for (int i = 0; i < len; i++) {
            int finalI = i;
            map.entrySet()
                    .stream()
                    .filter(x -> x.getKey() <= queries[finalI])
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .findFirst().ifPresentOrElse(m -> {
                        finalResult[finalI] = m.getValue();
                    }, () -> {
                        finalResult[finalI] = 0;
                    });
        }

        return finalResult;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] item : items) {
            map.put(item[0], map.getOrDefault(item[0], 0)
                    > item[1] ? map.getOrDefault(item[0], 0) : item[1]);
        }
        int len = queries.length;
        int[] finalResult = new int[len];
        for (int i = 0; i < len; i++) {
            int finalI = i;
            map.entrySet()
                    .stream()
                    .filter(x -> x.getKey() <= queries[finalI])
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .findFirst().ifPresentOrElse(m -> {
                        finalResult[finalI] = m.getValue();
                    }, () -> {
                        finalResult[finalI] = 0;
                    });
        }

        return finalResult;
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int prevVal = nums[0];
        int count = 0;
        for (int i = 1; i < len; i++) {
            while (nums[i] <= prevVal) {
                count++;
                nums[i] = nums[i] + 1;
            }
            prevVal = nums[i];
        }
        return count;
    }

    public static String bit(String prev) {
        String temp = "";
        char[] crr = prev.toCharArray();
        for (char c : crr) {
            if (c == '0') {
                temp += "1";
            } else {
                temp += 0;
            }
        }
        StringBuffer sb = new StringBuffer(temp);
        return prev + "1" + sb.reverse();
    }

    public static char findKthBit(int n, int k) {
        List<String> l = new ArrayList<>();
        l.add("0");
        for (int i = 1; i <= n; i++) {
            l.add(bit(l.get(i - 1)));
        }
        int len = l.size();
        return l.get(len - 1).charAt(k - 1);

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> firstList = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();
        int[] rows = null;

        for (int[] m : matrix) {
            if (m[0] == target || m[col - 1] == target) {
                return true;
            }
            if (target > m[0] && target < m[col - 1]) {
                rows = m;
                break;
            }
        }


        return rows == null ? false : Arrays.stream(rows).boxed().filter(x -> x == target).count() >= 1;
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        int index = 0;
        boolean flag = true;

        for (List<Integer> l : triangle) {
            if (flag) {
                sum += l.get(0);
                flag = false;
            } else {
                if (l.get(index) < l.get(index + 1)) {
                    sum += l.get(index);
                } else {
                    sum += l.get(index + 1);
                    index++;
                }
            }

        }
        return sum;
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> list = new ArrayList<>();
        int row = mat.length;
        int col = mat[0].length;

        if (row == 1 && col == 1) {
            List<Integer> l = new ArrayList<>();
            for (int[] i : mat) {
                l.add(i[0]);
            }

            return l.stream().mapToInt(x -> x).toArray();
        }

        if (row == 1 && col != 1) {

            return mat[0];
        }
        int len = row * col;
        int[] finalArr = new int[len];


        list.add(List.of(mat[0][0]));

        for (int i = 1; i < row; i++) {
            int tempCol = 0;
            List<Integer> l = new ArrayList<>();
            int tempRow = i;
            while (tempRow >= 0 && tempCol < col) {
                l.add(mat[tempRow][tempCol]);
                tempRow--;
                tempCol++;
            }

            list.add(l);
        }

        for (int i = 1; i < col; i++) {
            int tempCol = i;
            int tempRow = row - 1;
            List<Integer> l = new ArrayList<>();
            while (tempRow < row && tempCol < col) {
                l.add(mat[tempRow][tempCol]);
                tempRow--;
                tempCol++;
            }

            list.add(l);
        }

        boolean flag = true;
        int currIndex = 0;

        for (List<Integer> l1 : list) {
            if (flag) {
                for (int i : l1) {
                    finalArr[currIndex] = i;
                    currIndex++;
                }
                flag = false;
            } else {
                int l1Len = l1.size();
                for (int i = l1Len - 1; i >= 0; i--) {
                    finalArr[currIndex] = l1.get(i);
                    currIndex++;
                }
                flag = true;
            }
        }

        return finalArr;
    }

    public static long findScore(int[] nums) {

        int len = nums.length;
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Integer> indexes = new HashSet<>();
        long lValue = 0;
        int count = 0;


        while (count != len) {
            List<Integer> tempList = new ArrayList<>(l);
            int shortest = tempList.stream().sorted().findFirst().get();
            lValue += shortest;
            int curr = l.indexOf(shortest);
            l.remove(curr);
            l.add(curr, Integer.MAX_VALUE);
            count++;
            if (curr + 1 < len) {
                l.remove(curr + 1);
                l.add(curr + 1, Integer.MAX_VALUE);
                count++;
            }
            if (curr - 1 >= 0) {
                l.remove(curr - 1);
                l.add(curr - 1, Integer.MAX_VALUE);
                count++;
            }
        }

        return lValue;
    }

    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }
        return null;
    }

    public static int[][] diagonalSort(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        int[][] newMat = new int[row][col];
        int r = 0;
        for (int i = 0; i < col; i++) {
            List<Integer> l = new ArrayList<>();
            int tempI = i;
            while (r < row && tempI < col) {
                l.add(mat[r][tempI]);
                r++;
                tempI++;
            }

            r = 0;
            Collections.sort(l);
            tempI = i;
            int curr = 0;
            while (r < row && tempI < col) {
                newMat[r][tempI] = l.get(curr);
                curr++;
                r++;
                tempI++;
            }
            r = 0;
            tempI = i;
        }

        int c = 0;
        for (int i = 1; i < row; i++) {
            List<Integer> l = new ArrayList<>();
            int tempI = i;
            while (tempI < row && c < col) {
                l.add(mat[tempI][c]);
                c++;
                tempI++;
            }

            c = 0;
            Collections.sort(l);
            tempI = i;
            int curr = 0;
            while (tempI < row && c < col) {
                newMat[tempI][c] = l.get(curr);
                curr++;
                c++;
                tempI++;
            }

            c = 0;
            tempI = i;
        }
        return newMat;
    }

    public int numSpecial(int[][] mat) {

        int count = 0;
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean rowFlag = true;
                boolean colFlag = true;

                for (int k = 0; k < row; k++) {
                    if ((k != i) && mat[k][j] == 1) {
                        rowFlag = false;
                        break;
                    }
                }

                if (rowFlag) {
                    for (int k = 0; k < col; k++) {
                        if ((k != j) && mat[i][k] == 1) {
                            colFlag = false;
                            break;
                        }
                    }
                }

                if (colFlag && rowFlag) {
                    count++;
                }
            }
        }

        return count;

    }

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = row > col ? row : col;
        int[][] transpose = new int[col][row];

        int k = 0;
        int l = 0;

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                transpose[k][l] = matrix[i][j];
                l++;
            }
            l = 0;
            k++;
        }

        return Arrays.copyOfRange(transpose, 0, col);
    }

    public int minNumber(int[] nums1, int[] nums2) {

        List<Integer> l = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (!set.add(i)) {
                l.add(i);
            }
        }
        if (!l.isEmpty()) {
            return l.stream().sorted().findFirst().get();
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums1[0] > nums2[0] ? Integer.parseInt(nums2[0] + "" + nums1[0]) : Integer.parseInt(nums1[0] + "" + nums2[0]);

    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] c = new int[len];

        for (int i = 0; i < len; i++) {
            int count = 0;
            List<Integer> l = Arrays.stream(Arrays.copyOfRange(B, 0, i + 1)).boxed().collect(Collectors.toList());
            for (int j = 0; j <= i; j++) {
                if (l.contains(A[j])) {
                    count++;
                }
            }
            c[i] = count;
        }

        return c;
    }

    public int countSeniors(String[] details) {
        int count = 0;

        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                count++;
            }
        }

        return count;
        //return (int) Arrays.stream(details).filter(x -> Integer.parseInt(x.substring(11, 13)) > 60).count();
    }

    public static int equalPairs(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int currentCol = 0;
        int currentRow = 0;
        for (int[] g : grid) {
            boolean flag = true;

            for (int i = 0; i < row; i++) {
                if (g[i] != grid[currentRow][currentCol]) {
                    if (currentCol == row - 1) {
                        break;
                    } else {
                        i = -1;
                        currentCol++;
                        currentRow = 0;
                    }
                } else {
                    if (i == row - 1) {
                        count++;
                    } else {
                        currentRow++;
                    }
                }

            }
            currentRow = 0;
            currentCol = 0;
        }
        return count;
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        //oneRow-
        //zeroRow-
        //oneCol-
        //zeroCol-
        int row = grid.length;
        int col = grid[0].length;
        int[][] newGrid = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int oneRow = 0;
                int oneCol = 0;
                int zeroRow = 0;
                int zeroCol = 0;

                if (map.containsKey("oneRow-" + i)) {
                    oneRow = map.get("oneRow-" + i);
                } else {
                    int countOne = 0;
                    for (int k = 0; k < col; k++) {
                        if (grid[i][k] == 1) {
                            countOne++;
                        }
                    }
                    oneRow = countOne;
                    map.put("oneRow-" + i, countOne);
                }

                if (map.containsKey("oneCol-" + j)) {
                    oneCol = map.get("oneCol-" + j);
                } else {
                    int countOne = 0;
                    for (int k = 0; k < row; k++) {
                        if (grid[k][j] == 1) {
                            countOne++;
                        }
                    }
                    oneCol = countOne;
                    map.put("oneCol-" + j, countOne);

                }

                if (map.containsKey("zeroRow-" + i)) {
                    zeroRow = map.get("zeroRow-" + i);
                } else {
                    int countZero = 0;
                    for (int k = 0; k < col; k++) {
                        if (grid[i][k] == 0) {
                            countZero++;
                        }
                    }
                    zeroRow = countZero;
                    map.put("zeroRow-" + i, countZero);
                }

                if (map.containsKey("zeroCol-" + j)) {
                    zeroCol = map.get("zeroCol-" + j);
                } else {
                    int countZero = 0;
                    for (int k = 0; k < row; k++) {
                        if (grid[k][j] == 0) {
                            countZero++;
                        }
                    }
                    zeroCol = countZero;
                    map.put("zeroCol-" + j, countZero);

                }

                newGrid[i][j] = oneRow + oneCol - zeroRow - zeroCol;
            }
        }

        return newGrid;
    }

    public long coloredCells(int n) {
        /*
         * 1 + 4*1 + 4*2 + . . .
         * 1 + 4 * (1 + 2 + . . . + n-1)
         * 1 + 4 * (n * (n + 1) / 2)
         * 1 + (2 * n * (n - 1))
         * */

        return 1 + ((long) (2 * n) * (n - 1));
    }

    public static boolean validTicTacToe(String[] board) {
        int[][] mat = new int[3][3];

        int xCount = 0;
        int yCount = 0;

        int row = 0;
        int col = 0;

        for (String s : board) {
            String[] str = s.split("");
            for (String t : str) {
                if (t.equals(" ")) {
                    mat[row][col] = -1;
                    col++;
                } else if (t.equals("X")) {
                    mat[row][col] = 1;
                    xCount++;
                    col++;
                } else if (t.equals("O")) {
                    mat[row][col] = 0;
                    col++;
                    yCount++;
                }
            }
            col = 0;
            row++;
        }

        if (xCount == 0 && yCount == 0) {
            return true;
        }

        if ((xCount == 0 && yCount != 0)) {
            return false;
        }

        if (!(xCount - 1 == yCount || yCount - 1 == xCount) && (xCount != yCount)) {
            return false;
        }

        if (yCount > xCount) {
            return false;
        }

        if (xCount >= 3 && yCount >= 3) {
            boolean xCheck = check(mat, 1, board);
            boolean yCheck = check(mat, 0, board);
            if (xCheck == true && yCheck == true) {
                return false;
            } else if (xCheck == false && yCheck == true) {
                return false;
            } else if (xCheck == true && yCheck == false) {
                return false;
            }

            return true;
        }

        return false;

    }

    private static boolean check(int[][] mat, int i, String[] str) {
        long count = Arrays.stream(str).filter(x -> x.equals(i == 1 ? "XXX" : "OOO")).count();
        if (count == 0) {
            if (mat[0][0] == i && mat[1][1] == i && mat[2][2] == i) {
                return true;
            } else if (mat[0][2] == i && mat[1][1] == i && mat[2][0] == i) {
                return true;
            } else if (mat[0][0] == i && mat[1][0] == i && mat[2][0] == i) {
                return true;
            } else if (mat[0][1] == i && mat[1][1] == i && mat[2][1] == i) {
                return true;
            } else if (mat[0][2] == i && mat[1][2] == i && mat[2][2] == i) {
                return true;
            } else {
                return false;
            }
        }

        return true;

    }

    public static boolean backspaceCompare(String s, String t) {

        String srr[] = s.split("");
        int lenS = srr.length;

        String trr[] = t.split("");
        int lenT = trr.length;

        StringBuffer sb = new StringBuffer("");
        int count = 0;
        for (int i = lenS - 1; i >= 0; i--) {
            if (!srr[i].equals("#")) {
                i = i - count;
            } else {
                count++;
                //i = i - 1;
            }
        }

        StringBuffer tb = new StringBuffer("");
        for (int i = lenT - 1; i >= 0; i--) {
            if (!trr[i].equals("#")) {
                i = i - count;
                count = 0;
                if (i >= 0 && !trr[i].equals("#")) {
                    tb.append(trr[i]);
                } else {
                    count++;
                }
            } else {
                count++;
                //i = i - 1;
            }
        }

        return sb.toString().equals(tb.toString());
    }


    public String reverseStr(String s, int k) {
        if (s.length() == k) {
            return new StringBuffer(s).reverse().toString();
        }
        StringBuffer sb = new StringBuffer();
        int twoK = k * 2;
        while (!s.equals("")) {

            if (s.length() >= twoK) {
                String sub = s.substring(0, twoK);
                s = s.replaceFirst(sub, "");
                sb.append(reverse(sub.substring(0, k)) + sub.substring(k));
            } else if (s.length() < k) {
                sb.append(reverse(s));
                s = "";
            } else if (s.length() < twoK && s.length() > k) {
                sb.append(reverse(s.substring(0, k)) + s.substring(k));
                s = "";
            }
        }

        return sb.toString();
    }

    public int findTheLongestSubstring(String s) {
        if (!s.contains("a") && !s.contains("e") && !s.contains("i") && !s.contains("o") && !s.contains("u")) {
            return s.length();
        }

        List<String> list = new ArrayList<>();
        int len = s.length();
        String[] srr = s.split("");
        for (int i = 0; i < len; i++) {
            // j is the number of elements which should be printed
            for (int j = i; j < len; j++) {
                String s1 = "";
                for (int k = i; k <= j; k++) {
                    s1 += srr[k];
                }
                if (checkEvenVowels(s1)) {
                    System.out.println(s1);
                    list.add(s1);
                }
            }
        }
        Collections.sort(list, (a1, a2) -> a2.length() - a1.length());
        return list.get(0).length();
    }

    private boolean checkEvenVowels(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("e", 0);
        map.put("i", 0);
        map.put("o", 0);
        map.put("u", 0);

        String[] str = s.split("");
        for (String s1 : str) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            }
        }

        return map.entrySet().stream().filter(x -> x.getValue() % 2 != 0).count() == 0;
    }

    private String reverse(String str) {
        String nstr = "";
        char ch;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            ch = str.charAt(i);
            nstr = ch + nstr;
        }
        return nstr;
    }

    public static String gcdOfStrings(String str1, String str2) {
        String gcd = str1.length() > str2.length() ? str2 : str1;

        while (gcd.length() != 0) {
            int len = gcd.length();
            if (gcd.equals(str1.substring(0, len)) && gcd.equals(str2.substring(0, len))) {
                return gcd;
            }
            gcd = gcd.substring(0, len - 1);
        }

        return gcd;
    }

    public static String makeFancyString1(String s) {
        char srr[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        String s2 = "";
        int count = 0;
        char prevChr = srr[0];
        for (char s1 : srr) {
            if (count < 2 && prevChr == s1) {
                count++;
                stack.push(s1);
                s2 += s1;
            } else {
                if (prevChr != s1) {
                    stack.push(s1);
                    prevChr = s1;
                    s2 += s1;
                    count = 1;
                }
            }

        }
        /*String finalAns = "";
        while(!stack.isEmpty()){
            finalAns = stack.pop() + finalAns;
        }*/
        return s2;
    }

    public static int[] shortestToChar(String s, char c) {
        String[] arr = s.split("");
        int len = arr.length;
        int[] arrFinal = new int[len];

        for (int i = 0; i < len; i++) {
            if (String.valueOf(c).equals(arr[i])) {
                arrFinal[i] = 0;
            } else {
                int rightIndex = -1;
                int leftIndex = -1;

                for (int j = i + 1; j < len; j++) {
                    if (String.valueOf(c).equals(arr[j])) {
                        rightIndex = j;
                        break;
                    }
                }

                for (int j = i - 1; j >= 0; j--) {
                    if (String.valueOf(c).equals(arr[j])) {
                        leftIndex = j;
                        break;
                    }
                }

                if (leftIndex == -1) {
                    arrFinal[i] = Math.abs(i - rightIndex);
                } else if (rightIndex == -1) {
                    arrFinal[i] = Math.abs(i - leftIndex);
                } else {
                    int path1 = Math.abs(i - leftIndex);
                    int path2 = Math.abs(i - rightIndex);

                    arrFinal[i] = path1 > path2 ? path2 : path1;
                }


            }
        }

        return arrFinal;
    }

    public static String longestNiceSubstring(String s) {
        String[] srr = s.split("");
        List<String> list = new ArrayList<>();
        int len = srr.length;
        for (int i = 0; i < len; i++) {
            // j is the number of elements which should be printed
            for (int j = i; j < len; j++) {
                String s1 = "";
                for (int k = i; k <= j; k++) {
                    s1 += srr[k];
                }
                if (checkNice(s1) && s1.length() > 1) {
                    System.out.println(s1);
                    list.add(s1);
                }
            }
        }

        if (list.size() == 0) {
            return "";
        }
        Collections.sort(list, (a1, a2) -> a2.length() - a1.length());
        return list.get(0);
    }

    private static boolean checkNice(String s) {
        String lowerCase = "qwertyuiopasdfghjklzxcvbnm";
        String upperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
        char[] c = s.toCharArray();
        for (char c1 : c) {
            if (lowerCase.contains(String.valueOf(c1)) && !s.contains(String.valueOf(c1).toUpperCase())) {
                return false;
            }
            if (upperCase.contains(String.valueOf(c1)) && !s.contains(String.valueOf(c1).toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDistances(String s, int[] distance) {
        int currentIndex = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            int first = s.indexOf(i);
            int last = s.lastIndexOf(i);
            if (first != -1 && (last - first - 1) != distance[currentIndex]) {
                return false;
            }
            currentIndex++;
        }
        return true;
    }

    public static String makeGood(String s) {
        String caps = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String small = "qwertyuiopasdfghjklzxcvbnm";
        char[] srr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char s1 : srr) {
            if (stack.isEmpty()) {
                stack.push(s1);
            } else {
                if (caps.contains(String.valueOf(s1)) && String.valueOf((char) (stack.peek() - 32)).equals(String.valueOf(s1))) {
                    stack.pop();
                } else if (small.contains(String.valueOf(s1)) && String.valueOf((char) (stack.peek() + 32)).equals(String.valueOf(s1))) {
                    stack.pop();
                } else {
                    stack.push(s1);
                }
            }
        }

        if (stack.isEmpty()) {
            return "";
        }

        String finalS = "";
        while (!stack.isEmpty()) {
            finalS = stack.pop() + finalS;
        }

        return finalS;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> l = new ArrayList<>();

        String[] srr = s.split("");
        String temp = "";
        int len = s.length();

        for (int i = 0; i < len; i++) {
            //s.substring(i+1).contains(srr[])
        }

        return null;

    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        StringBuffer sb = new StringBuffer();
        for (int a : arr) {
            sb.append(a + ",");
        }
        for (int[] a1 : pieces) {
            if (a1.length == 1) {
                if (!sb.toString().contains(String.valueOf(a1[0] + ","))) {
                    return false;
                }
            } else {
                StringBuffer sb1 = new StringBuffer();
                for (int i : a1) {
                    sb1.append(i + ",");
                }

                if (!sb.toString().contains(sb1.toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> minInRow = new ArrayList<>();
        List<Integer> maxInCol = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        for (int[] i : matrix) {
            minInRow.add(Arrays.stream(i).boxed().min(Integer::compareTo).orElse(0));
        }

        while (startCol < col) {
            int max = Integer.MIN_VALUE;
            startRow = 0;
            while (startRow < row) {
                if (matrix[startRow][startCol] > max) {
                    max = matrix[startRow][startCol];
                }
                startRow++;
            }
            maxInCol.add(max);
            startCol++;
        }

        List<Integer> finalList = new ArrayList<>();

        minInRow.forEach(x -> {
            if (maxInCol.contains(x)) {
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

        Map.Entry<Integer, Integer> e = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).findFirst().get();

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
