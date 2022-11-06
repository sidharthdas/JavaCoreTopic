package Oct4Th2022.binarysearchtree;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  31/10/22
 */
public class LeetCodeMainClass20 {

    public static void main(String[] args) {
        //System.out.println(calculateTax(new int[][]{{1,0},{4,25},{5,50}}, 2));
        //System.out.println(getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3));
        //System.out.println(pivotIndex(new int[]{1,2,3}));
        //System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(minimumCost(new int[]{1, 2, 3}));
    }

    public List<Integer> intersection(int[][] nums) {

        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] n : nums){
            for(int n1 : n){
                map.put(n1, map.getOrDefault(n1, 0)+1);
            }
        }
        List<Integer> l = new ArrayList<>();
        int len = nums.length;
        map.entrySet().forEach(x ->{
            if(x.getValue() == len){
                l.add(x.getKey());
                System.out.println();
            }
        });

        return l;

    }

    public String sortString(String s) {
        String[] srr = s.split("");
        Map<String, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder("");
        for (String s1 : srr) {

            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        int count = 0;
        while (true) {
            if (map.isEmpty()) {
                break;
            }
            if (count % 2 == 0) {
                for (char a = 'a'; a <= 'z'; a++) {
                    if (map.containsKey(a + "")) {
                        if (map.get(a + "") == 1) {
                            sb.append(a + "");
                            map.remove(a + "");
                        } else {
                            sb.append(a + "");
                            map.put(a + "", map.get(a+"") - 1);
                        }
                    }
                }
                count++;
            } else {

                for (char a = 'z'; a >= 'a'; a--) {
                    if (map.containsKey(a + "")) {
                        if (map.get(a + "") == 1) {
                            sb.append(a + "");
                            map.remove(a + "");
                        } else {
                            sb.append(a + "");
                            map.put(a + "", map.get(a+"") - 1);
                        }
                    }
                }
                count ++;
            }

        }
        return sb.toString();
    }

    public String reorderSpaces(String text) {
        String[] srr = text.split("");
        String[] words = text.trim().split("\\s+");
        int count = 0;

        for (String s : srr) {
            if (s.equals(" ")) {
                count++;
            }
        }

        if (count == 0) return text;

        int wordsLen = words.length;
        if (wordsLen == 1) {
            text = text.trim();
            while (count != 0) {
                text += " ";
                count--;
            }

            return text;
        }
        int gaps = count / (wordsLen - 1);

        int endGaps = count % (wordsLen - 1);

        StringBuilder sb = new StringBuilder("");

        for (String word : words) {
            sb.append(word);
            int temp = gaps;
            while (temp != 0) {
                sb.append(" ");
                temp--;
            }
        }

        sb = new StringBuilder(sb.toString().trim());

        while (endGaps != 0) {
            sb.append(" ");
            endGaps--;
        }
        return sb.toString();
    }

    public int rearrangeCharacters(String s, String target) {
        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");
        String[] trr = target.split("");
        for (String s1 : srr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        int count = 0;
        while (true) {
            boolean flag = true;
            for (String t1 : trr) {
                if (map.containsKey(t1)) {
                    int temp = map.get(t1) - 1;
                    if (temp == 0) {
                        map.remove(t1);
                    } else {
                        map.put(t1, temp);
                    }

                } else {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                return count;
            }

            count += 1;

        }

    }

    public static int minimumCost(int[] cost) {
        int len = cost.length;
        int minCost = 0;
        Arrays.sort(cost);
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (count < 3) {
                minCost += cost[i];
                count++;
            } else if (count >= 3) {
                count = 0;
            }
        }
        return minCost;
    }

    public int[] decrypt(int[] code, int k) {
        int[] arr;
        int len = code.length;
        arr = new int[len];
        if (k == 0) {
            for (int i = 0; i < len; i++) {
                arr[i] = 0;
            }

            return arr;
        } else if (k > 0) {
            for (int i = 0; i < len; i++) {
                int sum = 0;
                int count = 0;
                int current = i + 1;
                if (i == code.length - 1) {
                    current = 0;
                }
                for (int j = current; j < code.length; j++) {

                    sum += code[j];
                    count++;
                    if (j == code.length - 1) {
                        j = -1;
                    }
                    if (count == k) {
                        break;
                    }
                }

                arr[i] = sum;


            }
        } else {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                int count = 0;
                int current = i - 1;
                if (i == 0) {
                    current = code.length - 1;
                }
                for (int j = current; j >= 0; j--) {
                    sum += code[j];
                    count++;
                    if (count == Math.abs(k)) {
                        break;
                    }
                    if (j == 0) {
                        j = code.length;
                    }
                }
                arr[i] = sum;
            }
        }
        return arr;
    }

    public String oddString(String[] words) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String word : words) {
            int len = word.length();
            List<Integer> list = new ArrayList<>();
            char[] crr = word.toCharArray();

            for (int i = 0; i < len - 1; i++) {
                list.add(crr[i + 1] - crr[i]);
            }

            if (map.containsKey(list)) {
                List<String> l = map.get(list);
                l.add(word);
            } else {
                List<String> l = new ArrayList<>();
                l.add(word);
                map.put(list, l);
            }


        }
        for (Map.Entry<List<Integer>, List<String>> m : map.entrySet()) {
            if (m.getValue().size() == 1) {
                return m.getValue().get(0);
            }
        }
        return "";

    }

    public static int maxDepth(String s) {

        String arr[] = s.split("");
        int count = 0;

        List<Integer> l = new ArrayList<>();
        l.add(0);

        for (String s1 : arr) {
            if (s1.equals("(")) {
                count += 1;
            } else if (s1.equals(")")) {

                l.add(count);
                count -= 1;
            }
        }

        Collections.sort(l, Collections.reverseOrder());

        return l.get(0);
    }


    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int pivotIndex = len / 2;
        int sumLeft = 0;
        int sumRight = 0;
        while (true) {
            for (int i = 0; i < pivotIndex; i++) {
                sumLeft += nums[i];
            }

            for (int i = pivotIndex + 1; i < len; i++) {
                sumRight += nums[i];
            }

            if (pivotIndex == 0 && pivotIndex == len - 1) {
                if (sumLeft == sumRight) {
                    return pivotIndex;
                }
                return -1;
            }

            if (sumLeft == sumRight) {
                return pivotIndex;
            }

            if (sumLeft > sumRight) {
                pivotIndex--;
            }

            if (sumLeft < sumRight) {
                pivotIndex++;
            }

            sumRight = 0;
            sumLeft = 0;

        }
    }


    public static int getMinDistance(int[] nums, int target, int start) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                int abs = Math.abs(i - start);
                if (min > abs) {
                    min = abs;
                }
            }
        }
        return min;
    }

    public static double calculateTax(int[][] brackets, int income) {
        //min(income, upperi) - prev.
        int prev = 0;
        int len = brackets.length;
        List<List<Integer>> l = new ArrayList<>();
        for (int[] brac : brackets) {
            if (income >= brac[0]) {
                l.add(List.of(getMin(income, brac[0]) - prev, brac[1]));
                prev = brac[0];
            }
        }

        double totalTax = 0.0;

        for (int i = 0; i < len; i++) {
            totalTax += (double) l.get(i).get(0) * ((double) l.get(i).get(1) / 100);
        }

        return totalTax;
    }

    private static int getMin(int i0, int i1) {
        return i0 >= i1 ? i1 : i0;
    }

    public int[] numberOfLines(int[] widths, String s) {

        int total = Arrays.stream(widths).boxed().reduce(0, Integer::sum);

        int totalLines = total / 100;
        int extra = total % 100;

        return new int[]{totalLines + 1, extra};

    }

    public boolean isPathCrossing(String path) {
        int currentX = 0;
        int currentY = 0;
        Set<Point> set = new HashSet<>();

        String str[] = path.split("");
        for (String s : str) {
            //'N', 'S', 'E' or 'W'
            if (s.equals("N")) {
                currentX += 1;
                if (!set.add(new Point(currentX, currentY))) {
                    return true;
                }
            } else if (s.equals("S")) {
                currentX -= 1;
                if (!set.add(new Point(currentX, currentY))) {
                    return true;
                }
            } else if (s.equals("E")) {
                currentY += 1;
                if (!set.add(new Point(currentX, currentY))) {
                    return true;
                }
            } else if (s.equals("W")) {
                currentY -= 1;
                if (!set.add(new Point(currentX, currentY))) {
                    return true;
                }
            }
        }

        return false;
    }
}

class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
