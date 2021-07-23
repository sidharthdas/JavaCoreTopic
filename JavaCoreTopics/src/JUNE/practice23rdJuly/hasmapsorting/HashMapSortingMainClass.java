package JUNE.practice23rdJuly.hasmapsorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 23/07/21.
 */
public class HashMapSortingMainClass {

    public static void main ( String[] args ) {


        Map< String, Integer > map = new HashMap<>();
        map.put("Sidharth", 10);
        map.put("Ram", 50);
        map.put("Shayam", 25);
        map.put("Raj", 20);

        //SortedByValue
       Map<String, Integer> sortByValueMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));

       //SortedByKey
        sortByValueMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e1, LinkedHashMap::new));

        //ReversedSorting
         Map< String, Integer > sortedByCount = map.entrySet()
                .stream()
                .sorted((Map.Entry.< String, Integer >comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));




        System.out.println(sortByValueMap);

    }
}
