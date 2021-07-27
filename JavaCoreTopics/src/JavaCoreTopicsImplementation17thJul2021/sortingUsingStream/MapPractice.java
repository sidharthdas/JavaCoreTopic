package JavaCoreTopicsImplementation17thJul2021.sortingUsingStream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 27/07/21.
 */
public class MapPractice {

    public static void main ( String[] args ) {


        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("9", 9);
        map.put("8", 8);
        map.put("7", 7);
        map.put("6", 6);
        map.put("5", 5);
        map.put("4", 4);

        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));

        System.out.println(map);

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));
        System.out.println(map);

    }
}
