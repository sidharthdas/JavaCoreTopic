package JUNE.practice23rdJuly.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 24/07/21.
 */
public class HasMapMain {

    public static void main ( String[] args ) {


        Map< String, Integer > map = new HashMap<>();
        map.put("Sidharth", 10);
        map.put("Ram", 50);
        map.put("Shayam", 25);
        map.put("Raj", 20);


        Map<String, Integer> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));

        Map<String, Integer> revSorted = map.entrySet().stream().sorted((Map.Entry.<String, Integer>comparingByValue().reversed())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));

        System.out.println(sorted);
        System.out.println(revSorted);

        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);

        int j = list.stream().reduce(0, Integer::sum);
        System.out.println(j);


    }
}
