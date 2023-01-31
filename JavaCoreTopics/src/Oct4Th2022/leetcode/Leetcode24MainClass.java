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
        subString("430043".toCharArray(), 6);

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
    public String categorizeBox(int length, int width, int height, int mass) {
        Map<String, Integer> map = new HashMap<>();
        if ((length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000)
                || (length * width * height > 1000000000)
        ) {
            map.put("Bulky", 1);
        } else if (mass >= 100) {
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
        } else if(map.containsKey("Bulky") && !map.containsKey("Heavy")) {
            return "Bulky";
        } else if(!map.containsKey("Bulky") && map.containsKey("Heavy")) {
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

        return (int) l.stream().filter(x -> String.valueOf(x).length() == k)
                .map(x -> Integer.parseInt(x))
                .filter(x -> x != 0)
                .filter(x -> num % x == 0).count();
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