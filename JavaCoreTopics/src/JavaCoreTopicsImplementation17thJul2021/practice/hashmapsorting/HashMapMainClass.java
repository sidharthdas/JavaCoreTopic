package JavaCoreTopicsImplementation17thJul2021.practice.hashmapsorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 28/07/21.
 */
public class HashMapMainClass {

    public static void main ( String[] args ) {

        Map< String, Integer > map = new HashMap<>();

        map.put("Sidharth", 1);
        map.put("Raju", 10);
        map.put("RAM", 19);
        map.put("sHIV", 16);
        map.put("dEV", 4);
        map.put("Sagaar", 6);
        map.put("Ramesh", 2);

        System.out.println("Sorting by Value. . . ");
        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

        System.out.println(map);

        System.out.println("Sorting my value reverse order. . . ");
        map = map.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));
        System.out.println(map);

    }
}
