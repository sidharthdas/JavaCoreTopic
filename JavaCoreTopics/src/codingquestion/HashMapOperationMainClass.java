package codingquestion;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapOperationMainClass {

	public static void main(String[] args) {

		Map<String, Integer> names = new HashMap<>();
		names.put("Sidharth", 1);
		names.put("Sagar", 2);
		names.put("Dev", 3);
		names.put("Kou", 5);
		names.put("Raj", 1);
		names.put("Sidharth", 1);

		Map<String, Integer> newNames = names.entrySet().stream().filter(x -> x.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(newNames);

	}

}
