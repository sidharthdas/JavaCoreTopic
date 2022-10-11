package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  11/10/22
 */
public class LeetcodeMain10 {
    public static void main(String[] args) {
        /*
        * ["SORTracker", "add", "add", "get", "add", "get", "add", "get", "add", "get", "add", "get", "get"]
[[], ["bradford", 2], ["branford", 3], [], ["alps", 2], [], ["orland", 2], [], ["orlando", 3], [], ["alpine", 2], [], []]
        * */

        System.out.println(findTheWinner(5, 2));

    }

    public static int findTheWinner(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int currIndex = 0;
        while (list.size() != 1) {
            currIndex = currIndex + k - 1;
            if(currIndex < list.size()){
                list.remove(currIndex);
            }
            if(currIndex >= list.size() && list.size()!= 0){
                currIndex = currIndex - list.size();
                list.remove(currIndex);
            }

        }

        return list.get(0);

    }

    public static int nthMagicalNumber(int n, int a, int b) {
        int count = 0;
        //List<Integer> l = new ArrayList<>();
        for (int i = 1; count <= n; i++) {
            if ((i % a == 0) || (i % b == 0)) {
                count++;

                if (count == n) {
                    return i;
                }
            }
        }
        return 0;
    }

    public long countVowels(String word) {
        int count = 0;
        int len = word.length();
        List<String> list = Arrays.asList("a", "e", "i", "o", "u");
        int temp = 0;
        //This loop maintains the starting character
        for (int i = 0; i < len; i++) {
            //This loop adds the next character every iteration for the subset to form and add it to the array
            for (int j = i; j < len; j++) {
                String s = word.substring(i, j + 1);
                String srr[] = s.split("");
                for (String s3 : srr) {
                    if (list.contains(s3)) {
                        count++;
                    }
                }
                temp++;
            }
        }
        return count;
    }


    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        int len = nums.length;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (min > nums[i]) {
                min = nums[i];
            } else if (secMin > nums[i]) {
                secMin = nums[i];
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }

    class NumIndex {
        int num;
        int index;

        public NumIndex(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = wordDict.size();
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if ((wordDict.get(i) + wordDict.get(j)).equals(s)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public int GCD(int x, int y) {

        int gcd = 1;

        for (int i = 1; i <= x && i <= y; i++) {

            if (x % i == 0 && y % i == 0)

                gcd = i;
        }

        return gcd;
    }

    public int findGCD(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);

        int first = nums[0];
        int last = nums[len - 1];
        return GCD(first, last);


    }


}


class Location {
    String locName;
    int score;

    public Location(String locName, int score) {
        this.locName = locName;
        this.score = score;
    }
}

class SORTracker {
    List<Location> list;
    int count = 0;

    public SORTracker() {
        list = new ArrayList<>();
    }

    public void add(String name, int score) {
        Location l = new Location(name, score);
        list.add(l);

    }

    public String get() {
        Comparator<Location> c = (x, y) -> {
            if (x.score > y.score) {
                return -1;
            } else if (x.score < y.score) {
                return 1;
            } else {
                return 0;
            }
        };
        Comparator<Location> c1 = (x, y) -> {
            return x.locName.compareTo(y.locName);
        };

        int temp = count;
        count += 1;

        return list.stream().sorted(c.thenComparing(c1)).toList().get(temp).locName;
    }
}


