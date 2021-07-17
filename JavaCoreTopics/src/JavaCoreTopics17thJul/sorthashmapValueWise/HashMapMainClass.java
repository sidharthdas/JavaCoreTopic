package JavaCoreTopics17thJul.sorthashmapValueWise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 17/07/21.
 */
public class HashMapMainClass {

    public static void main ( String[] args ) {

        Map<String, Integer> map = new HashMap<>();

        final Map< String, Integer > sortedByCount = map.entrySet()
                .stream()
                .sorted((Map.Entry.< String, Integer >comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));
    }
}
