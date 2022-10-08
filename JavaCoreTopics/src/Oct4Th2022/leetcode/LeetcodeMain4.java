package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  08/10/22
 */
public class LeetcodeMain4 {
    public static void main(String[] args) {
        List<List<String>> displayTable =
                Arrays.asList(Arrays.asList("David","3","Ceviche"),
                        Arrays.asList("Corina","10","Beef Burrito"),
                        Arrays.asList("David","3","Fried Chicken"),
                        Arrays.asList("Carla","5","Water"),
                        Arrays.asList("Carla","5","Ceviche"),
                        Arrays.asList("Rous","3","Ceviche"));

displayTable(displayTable);

    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> set = new TreeSet<>();
        //orders[i]=[customerNamei,tableNumberi,foodItemi]
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (List<String> order : orders) {
            set.add(order.get(2));
            if (map.containsKey(Integer.valueOf(order.get(1)))) {
                Map<String, Integer> m = map.get(Integer.parseInt(order.get(1)));
                if (m.containsKey(order.get(2))) {
                    m.put(order.get(2), m.get(order.get(2)) + 1);
                    map.put(Integer.valueOf(order.get(1)), m);
                } else {
                    m.put(order.get(2), 1);
                    map.put(Integer.valueOf(order.get(1)), m);
                }
            } else {
                Map<String, Integer> m = new HashMap<>();
                m.put(order.get(2), 1);
                map.put(Integer.valueOf(order.get(1)), m);
            }
        }

        map = map.entrySet().stream().sorted(Map.Entry.<Integer, Map<String, Integer>>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<List<String>> finalList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("Table");
        list.addAll(set.stream().toList());
        finalList.add(list);

        map.entrySet().forEach(x -> {
            List<String> l = new ArrayList<>();
            l.add(String.valueOf(x.getKey()));
            set.forEach(y -> {
                if(x.getValue().containsKey(y)){
                    l.add(String.valueOf(x.getValue().get(y)));
                }else{
                    l.add("0");
                }
            });

            finalList.add(l);
        });


        return finalList;
    }
}


class Restrrrant {

    private String TableNum;
    private Map<String, Integer> dishesCount;

    public Restrrrant(String tableNum) {
        TableNum = tableNum;
        dishesCount = new HashMap<>();
    }

    public String getTableNum() {
        return TableNum;
    }

    public void setTableNum(String tableNum) {
        TableNum = tableNum;
    }

    public Map<String, Integer> getDishesCount() {
        return dishesCount;
    }

    public void setDishesCount(Map<String, Integer> dishesCount) {
        this.dishesCount = dishesCount;
    }
}
