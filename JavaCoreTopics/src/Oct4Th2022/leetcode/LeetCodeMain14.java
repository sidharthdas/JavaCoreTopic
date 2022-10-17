package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  17/10/22
 */
public class LeetCodeMain14 {

    public static void main(String[] args) {

        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"},new int[] {9, 12, 8, 15, 14, 7});
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
        // However, "ramen" is lexicographically smaller than "sushi".

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

        Comparator<FoodCuisine> comparator = (FoodCuisine f1, FoodCuisine f2) ->{
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
        if(map.get(key) == 1){
            map.remove(key);
        }else{
            map.put(key, map.get(key) - 1);
        }

    }

    public String getMaxKey() {
        if(map.size() == 0){
            return "";
        }
        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .findFirst().get().getKey();

    }

    public String getMinKey() {
        if(map.size() == 0){
            return "";
        }
        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .findFirst().get().getKey();
    }
}

