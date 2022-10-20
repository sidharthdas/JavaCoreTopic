package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  17/10/22
 */
public class LeetCodeMain14 {

    public static void main(String[] args) {

        /*FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        foodRatings.highestRated("korean"); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        foodRatings.highestRated("japanese"); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".*/

        //reorderSpaces("  this   is  a sentence ");
        //sumOfThree(15);
        brokenCalc(2, 3);

    }
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++)

                if ((i & (1 << j)) > 0) {
                    l.add(nums[j]);
                }
            subsets.add(l);
        }
        return subsets;
    }
    public int numMatchingSubseq(String s, String[] words) {
        List<String> l = Arrays.stream(words).toList();
        return 0;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> wordSubsets = new ArrayList<>();

        for (String s : words1) {
            boolean flag = true;
            for (String w : words2) {
                if(w.length() == 1) {
                    if (!s.contains(w)) {
                        flag = false;
                        break;
                    }
                }
                else{
                    String[] wrr = w.split("");
                    for(String wr : wrr){
                        if (!s.contains(wr)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if(flag){
                wordSubsets.add(s);
            }
        }
        return wordSubsets;
    }
    //(i + (i - 1) + (i - 2))

    public static int brokenCalc(int startValue, int target) {
        int count = 0;
        while (true) {
            if (startValue < target) {
                startValue *= 2;
                count += 1;
            } else if (startValue > target) {
                startValue -= 1;
                count += 1;
            } else {
                break;
            }
        }

        return count;

    }

    public static long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }
        num = num / 3;

        return new long[]{num - 1, num, num + 1};

    }

    public String complexNumberMultiply(String num1, String num2) {
        String num1Arr[] = num1.split("\\+");
        String num2Arr[] = num1.split("\\+");

        int a = Integer.valueOf(num1Arr[0]);
        int b = Integer.valueOf(num1Arr[1].replace("i", ""));
        int c = Integer.valueOf(num2Arr[0]);
        int d = Integer.valueOf(num2Arr[1].replace("i", ""));


        return String.valueOf(a * c - b * d) + "+" + String.valueOf(b * c + a * d) + "i";
    }

    public String complexNumberMultiply1(String num1, String num2) {
        String[] one = num1.split("\\+");
        String[] two = num2.split("\\+");
        int a = Integer.valueOf(one[0]);
        int b = Integer.valueOf(one[1].replace("i", ""));
        int c = Integer.valueOf(two[0]);
        int d = Integer.valueOf(two[1].replace("i", ""));
        return String.valueOf(a * c - b * d) + "+" + String.valueOf(b * c + a * d) + "i";
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int totcalCount = numBottles;

        while (true) {
            int drinkableBottle = numBottles / numExchange;
            int reminderBottle = numBottles % numExchange;
            totcalCount += drinkableBottle;
            numBottles = drinkableBottle + reminderBottle;
            if (numBottles < numExchange) {
                break;
            }
        }
        return totcalCount;

    }

    public static int reverseBits(int n) {

        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        return Integer.parseInt(s.reverse().toString(), 2);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++)

                if ((i & (1 << j)) > 0) {
                    l.add(nums[j]);
                }
            subsets.add(l);
        }
        return subsets;
    }

    static void printSubsets(char set[]) {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }
}

class FoodRatings {
    Map<FoodCuisine, Integer> map;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        int len = foods.length;
        for (int i = 0; i < len; i++) {
            map.put(new FoodCuisine(foods[i], cuisines[i]), ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        FoodCuisine fc = map.entrySet().stream().filter(x -> x.getKey().getFood().equals(food)).findFirst().get().getKey();
        map.put(fc, newRating);

    }

    public String highestRated(String cuisine) {
        int val = map.entrySet().stream().filter(x -> x.getKey().getCuisine().equals(cuisine)).
                sorted(Map.Entry.<FoodCuisine, Integer>comparingByValue().reversed())
                .findFirst().get().getValue();

        Comparator<FoodCuisine> comparator = (FoodCuisine f1, FoodCuisine f2) -> {
            return f1.getFood().compareTo(f2.getFood());
        };

        return map.entrySet().stream().filter(x -> x.getKey().getCuisine().equals(cuisine) && x.getValue() == val)
                .sorted(Map.Entry.<FoodCuisine, Integer>comparingByKey(comparator))
                .findFirst().get().getKey().getFood();
    }
}

class FoodCuisine {

    private String food;
    private String cuisine;

    public FoodCuisine(String food, String cuisine) {
        this.food = food;
        this.cuisine = cuisine;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodCuisine that = (FoodCuisine) o;
        return Objects.equals(food, that.food) && Objects.equals(cuisine, that.cuisine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, cuisine);
    }
}

class AllOne {

    Map<String, Integer> map;

    public AllOne() {
        map = new HashMap<>();

    }

    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public void dec(String key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }

    }

    public String getMaxKey() {
        if (map.size() == 0) {
            return "";
        }
        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .findFirst().get().getKey();

    }

    public String getMinKey() {
        if (map.size() == 0) {
            return "";
        }
        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .findFirst().get().getKey();
    }
}

class Solution {
    int[] arr;
    int size;

    public Solution(int[] nums) {
        this.arr = nums;
        this.size = nums.length;
    }

    public int[] reset() {
        return arr;

    }

    public int[] shuffle() {
        List<Integer> l = new ArrayList<>();
        for (int i : arr) {
            l.add(i);
        }
        Collections.shuffle(l);
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = l.get(i);
        }
        return arr;
    }
}

class MinStack {

    Stack<Integer> stack;
    int top;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        top = val;
    }

    public void pop() {
        stack.pop();
        if (stack.isEmpty()) {
            top = 0;
        }
        top = stack.peek();
    }

    public int top() {
        return top;
    }

    public int getMin() {
        Optional<Integer> op = stack.stream().sorted().findFirst();
        if (op.isEmpty()) {
            return -1;
        } else {
            return op.get();
        }
    }
}

