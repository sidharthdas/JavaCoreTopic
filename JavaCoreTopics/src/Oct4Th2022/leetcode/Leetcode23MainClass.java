package Oct4Th2022.leetcode;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  16/01/23
 */
public class Leetcode23MainClass {

    public static void main(String[] args) {

        /*double n = 3000.12;

        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format(n);

        System.out.println(val);

        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        String val2 = nf2.format(n);

        System.out.println(val2);

        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
        String val3 = nf3.format(n);

        System.out.println("DK : "+val3);*/

        double d = 0;

        System.out.println(d);

    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, List<String>> creatorsWithIds = new HashMap<>();
        Map<String, Long> creatorsWithViews = new HashMap<>();
        Map<String, Map<String, Integer>> creatorsWithSeparate = new HashMap<>();
        int count = creators.length;

        for(int i = 0; i < count; i++){
            creatorsWithIds.putIfAbsent(creators[i],new ArrayList<>());
            creatorsWithIds.get(creators[i]).add(ids[i]);
            creatorsWithViews.put(creators[i], creatorsWithViews.getOrDefault(creators[i], 0l)+ views[i]);
            creatorsWithSeparate.putIfAbsent(creators[i], new HashMap<>());
            creatorsWithSeparate.get(creators[i]).put(ids[i], views[i]);
        }

        long highestView = creatorsWithViews.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .findFirst().get().getValue();

        List<String> keys = creatorsWithViews.entrySet().stream().filter(x -> x.getValue() == highestView).map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<List<String>> finalList = new ArrayList<>();

        keys.forEach(x -> {
            List<String> l = new ArrayList<>();
            l.add(x);
            int val = creatorsWithSeparate.get(x).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .findFirst().get().getValue();
            l.add(creatorsWithSeparate.get(x).entrySet().stream().filter(y -> y.getValue() == val)
                    .map(Map.Entry::getKey)
                    .sorted().findFirst().get());
            //l.add(creatorsWithIds.get(x).stream().sorted(Comparator.reverseOrder()).findFirst().get());
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