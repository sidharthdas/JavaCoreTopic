package mapAllFunctionalities;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  28/02/23
 */
public class MainClass {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Sidharth", 10);
        map.put("Ram", 8);
        map.put("Sita1", 50);
        map.put("Sita2", 48);
        map.put("Sita3", 42);
        map.put("Sita4", 52);
        map.put("Sita5", 50);
        map.put("Sita6", 8);

        //Sort By Key

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        System.out.println("Sort By Key");
        System.out.println(map);

        //Sort By Key in reverse order

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Sort By Key - reversed");
        System.out.println(map);

        //Sort by Value

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        System.out.println("Sort By Value");
        System.out.println(map);

        //Sort by Value - reversed

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Sort By Value - reversed");
        System.out.println(map);

        //Sort by Value and if values are equal, sort by key

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(10, 10);
        map1.put(11, 8);
        map1.put(1, 50);
        map1.put(2, 48);
        map1.put(9, 42);
        map1.put(98, 52);
        map1.put(7, 50);
        map1.put(101, 8);

        /*map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Comparator.comparing(Map.Entry.<String, Integer>comparingByKey())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));*/

        map1 = map1.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Sort By Value - reversed and if equal then sort by key");
        System.out.println(map1);

        List<StudentDTD> list = Arrays.asList(
                new StudentDTD("t1", "8", "D", "000", "test", "2009", "feb"),
                new StudentDTD("t2", "8", "F", "000", "test", "2009", "feb"),
                new StudentDTD("t3", "9", "D", "000", "test", "2009", "feb"),
                new StudentDTD("t4", "9", "D", "000", "test", "2010", "mar"),
                new StudentDTD("t5", "9", "K", "000", "test", "2012", "mar"),
                new StudentDTD("t6", "10", "D", "000", "test", "2010", "mar")
        );


        //group the student based by class

        Map<String, List<StudentDTD>> map2 = list.stream().collect(Collectors.groupingBy(StudentDTD::getClassName));

        System.out.println(map2);
    }
}
