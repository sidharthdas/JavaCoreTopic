package StreamConcept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIMainClass {

	public static void main(String[] args) {

		// Streams on arraylist

		List<Integer> nums = new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		nums.add(40);
		nums.add(50);
		nums.add(60);
		nums.add(70);
		nums.add(80);
		nums.add(90);
		nums.add(100);

		List<Integer> newNums = nums.stream().map(num -> num + 5).collect(Collectors.toList());
		System.out.println(newNums);

		List<Integer> newNums1 = nums.stream().filter(num -> num > 50).collect(Collectors.toList());
		System.out.println(newNums1);

		// Streams on map

		Map<String, Integer> map = new HashMap<>();

		map.put("Sid", 1);
		map.put("Sagar", 2);
		map.put("Tripsy", 3);
		map.put("Sagarika", 4);

		Map<String, Integer> map1 = map.entrySet().stream().filter(x -> x.getValue() > 2)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println(map1);

		// Converting map to list of keys using streams
		List<String> keys = map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(keys);

		// Converting map to list of values using streams
		List<Integer> values = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
		System.out.println(values);

	}

}
