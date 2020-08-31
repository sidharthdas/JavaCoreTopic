package practice5.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("Sidharth", 10);
		map.put("Ram", 5);
		map.put("sayam", 2);
		map.put("tina", 100);
		map.put("twinkle", 50);
		map.put("sita", 110);
		map.put("gita", 20);

		Map<String, Integer> newMap = map.entrySet().stream().filter(x -> x.getValue() > 50)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		
		System.out.println(newMap);
	}

}
