package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.sortingjava8.mapsorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 31/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Sidharth", 10);
        map.put("Ram", 9);
        map.put("Ramesh", 101);
        map.put("Kapoor", 1220);
        map.put("Singh", 110);

        System.out.println("Sorting in asec");

        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        System.out.println(map);

        System.out.println("Sorting in desc");

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e1, LinkedHashMap::new));

        System.out.println(map);

    }
}
