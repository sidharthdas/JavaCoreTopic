package mapAllFunctionalities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  01/03/23
 */
public class MainClass2 {

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

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(map);
    }
}
