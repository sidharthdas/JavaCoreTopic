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
    }

    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String operation : operations) {
            if (operation.length() == 2 || operation.matches("[0-9]+")) {
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
        return list.stream().reduce(Integer::sum).get();
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