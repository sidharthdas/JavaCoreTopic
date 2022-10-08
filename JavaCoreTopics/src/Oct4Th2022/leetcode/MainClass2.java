package Oct4Th2022.leetcode;

import JavaCoreTopicsImplementation17thJul2021.abstractclass.I;
import override.A;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  06/10/22
 */
public class MainClass2 {

    public static void main(String[] args) {
        //System.out.println(findLonely(new int[]{75, 35, 59, 66, 69, 53, 37, 16, 60, 98, 11, 33, 3, 85, 59, 65, 59, 44, 34, 89, 72, 47}));
        System.out.println(commonFactors(6, 12));
    }

    /*You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

    Return a list answer of size 2 where:

    answer[0] is a list of all players that have not lost any matches.
    answer[1] is a list of all players that have lost exactly one match.
    The values in the two lists should be returned in increasing order.

    Note:

    You should only consider the players that have played at least one match.
    The testcases will be generated such that no two matches will have the same outcome.
    */

    public static int commonFactors(int a, int b) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                }
            }
        }

        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                } else {
                    map.put(i, 2);
                }
            }
        }

        return (int) map.entrySet().stream().filter(x -> x.getValue() == 2).count();

    }

    public int smallestEvenMultiple(int n) {
        if (n % 2 != 0) {
            return n * 2;
        } else {
            return n;
        }

    }

    public int largestPerimeter(int[] nums) {

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if ((a + b > c) && (b + c > a) && (a + c > b)) {
            return a + b + c;
        }
        return 0;
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> l = new ArrayList<>();
        int len = words.length;
        String prev = "";
        for (int i = 0; i < len; i++) {
            char[] crr = words[i].toCharArray();
            Arrays.sort(crr);
            String s = String.valueOf(crr);
            if (!s.equals(prev)) {
                l.add(words[i]);
                prev = s;
            }
        }
        return l;
    }

    public int[] findEvenNumbers1(int[] digits) {

        int len = digits.length;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (i != j && j != k && i != k) {
                        int num = Integer.parseInt(digits[i] + "" + digits[j] + "" + digits[k]);
                        if (num > 99 && num <= 999 && num % 2 == 0) {
                            set.add(num);
                        }

                    }
                }
            }
        }

        //List<Integer> l = set.stream().toList();

        int[] finalNum = new int[set.size()];
        int count = 0;
        for (int i : set) {
            finalNum[count] = i;
            count += 1;
        }

        return finalNum;

    }

    public static List<Integer> findLonely1(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        List<Integer> list1 = new ArrayList<>();

        for (int i : nums) {
            if (list.indexOf(i) == list.lastIndexOf(i)) {
                if (!(list.contains(i - 1) || list.contains(i + 1))) {
                    list1.add(i);
                }
            }
        }
        return list1;

    }

    public static List<Integer> findLonely2(int[] nums) {

        Map<Integer, Long> map = Arrays.stream(nums).boxed().
                collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        Set<Integer> set = map.keySet();
        List<Integer> l = new ArrayList<>();

        for (Map.Entry<Integer, Long> m : map.entrySet()) {
            if (m.getValue() == 1) {
                if (!(set.contains(m.getKey() - 1) || set.contains(m.getKey() + 1))) {
                    l.add(m.getKey());
                }
            }
        }
        return l;
    }

    public static List<Integer> findLonely(int[] nums) {

        List<Integer> unique = Arrays.stream(nums).boxed().
                collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new)).keySet()
                .stream().toList();
        List<Integer> notUnique = Arrays.stream(nums).boxed().collect(Collectors.toSet()).stream().toList();
        List<Integer> finalList = new ArrayList<>();
        for (int i : unique) {
            if (!(notUnique.contains(i - 1) || notUnique.contains(i + 1))) {

                finalList.add(i);

            }
        }


        return finalList;

    }


    public int[] findEvenNumbers(int[] digits) {

        int len = digits.length;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (i != j && j != k && i != k) {
                        String s = digits[i] + "" + digits[j] + "" + digits[k];
                        int num = Integer.parseInt(s);
                        if (num > 99 && num <= 999 && num % 2 == 0) {
                            set.add(num);
                        }

                    }
                }
            }
        }

        List<Integer> l = set.stream().toList();

        int[] finalNum = new int[l.size()];
        int count = 0;
        for (int i : l) {
            finalNum[count] = i;
            count += 1;
        }

        return finalNum;

    }

    public static int trap(Integer[] height) {

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

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String s : words) {
            boolean flag = true;
            String[] srr = s.split("");
            for (String s1 : srr) {
                if (!allowed.contains(s1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += 1;

            } else {
                flag = true;
            }
        }
        return count;
    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        List<Integer> sb1 = new ArrayList<>();
        List<Integer> sb2 = new ArrayList<>();
        List<Integer> sb3 = new ArrayList<>();


        Arrays.stream(nums1).boxed().forEach(x -> {
            sb1.add(x);
            set.add(x);
        });
        Arrays.stream(nums2).boxed().forEach(x -> {
            sb2.add(x);
            set.add(x);
        });
        Arrays.stream(nums3).boxed().forEach(x -> {
            sb3.add(x);
            set.add(x);
        });
        List<Integer> finalList = new ArrayList<>();
        for (int i : set) {
            if (
                    (sb1.contains(i) && sb2.contains(i) && sb3.contains(i))
                            ||
                            (sb1.contains(i) && sb2.contains(i))
                            ||
                            (sb2.contains(i) && sb3.contains(i))
                            ||
                            (sb1.contains(i) && sb3.contains(i))

            ) {
                finalList.add(i);
            }
        }

        return finalList;
    }

}

class SmallestInfiniteSet {

    public static void main(String[] args) {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);
        System.out.println(set.pq);
    }

    PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
        }
    }

    public int popSmallest() {
        return pq.poll();
    }

    public void addBack(int num) {
        if (!pq.contains(num)) {
            pq.add(num);
        }

    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

class RecentCounter {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);

        System.out.println(pq.peek());
        System.out.println(pq.peek());
        System.out.println(pq);

    }

    List<Integer> list;

    public RecentCounter() {
        list = new ArrayList(1000000000);
    }

    public int ping(int t) {
        this.list.add(t);
        int val = t - 3000;
        int count = 0;
        for (int x : list) {
            if (x < val) {
                count += 1;
            } else {
                break;
            }
        }
        return list.size() - count;
    }
}

class SeatManager {

    Map<Integer, Boolean> map;

    public SeatManager(int n) {
        map = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, true);
        }
    }

    public int reserve() {
        int seatNumber = -1;
        for (Map.Entry<Integer, Boolean> m : map.entrySet()) {
            if (m.getValue()) {
                seatNumber = m.getKey();
                break;
            }
        }
        map.put(seatNumber, false);
        return seatNumber;

    }

    public void unreserve(int seatNumber) {
        map.put(seatNumber, true);
    }
}

class SeatManager1 {

    PriorityQueue<Integer> pq;

    public SeatManager1(int n) {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }

    public int reserve() {
        return pq.poll();

    }

    public void unreserve(int seatNumber) {

        pq.add(seatNumber);

    }
}

