package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  16/01/23
 */
public class Leetcode23MainClass {

    public static void main(String[] args) {

    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, List<String>> creatorsWithIds = new HashMap<>();
        Map<String, Integer> creatorsWithViews = new HashMap<>();
        int count = creators.length;

        for(int i = 0; i < count; i++){
            creatorsWithIds.putIfAbsent(creators[i],new ArrayList<>());
            creatorsWithIds.get(creators[i]).add(ids[i]);
            creatorsWithViews.put(creators[i], creatorsWithViews.getOrDefault(creators[i], 0)+ views[i]);
        }

        int highestView = creatorsWithViews.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .findFirst().get().getValue();

        List<String> keys = creatorsWithViews.entrySet().stream().filter(x -> x.getValue() == highestView).map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<List<String>> finalList = new ArrayList<>();

        keys.forEach(x -> {
            List<String> l = new ArrayList<>();
            l.add(x);
            l.add(creatorsWithIds.get(x).stream().sorted(Comparator.reverseOrder()).findFirst().get());
            finalList.add(l);
        });
        return finalList;
    }
}

class NumberContainers {
    Map<Integer, Integer> map;

    public NumberContainers() {
        map = new TreeMap<>();
    }

    public void change(int index, int number) {
        map.put(index, number);
    }

    public int find(int number) {
        if(map.entrySet().stream().filter(x -> x.getValue() == number).count() == 0){
            return -1;
        }
        Map.Entry<Integer, Integer> e = map.entrySet().stream().filter(x -> x.getValue() == number)
                .findFirst().get();
        return e.getKey();
    }
}