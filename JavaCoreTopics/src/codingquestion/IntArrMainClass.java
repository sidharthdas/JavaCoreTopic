package codingquestion;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class IntArrMainClass {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 3, 3, 2, 2, 2 };

		int val = arr.length / 3;

		Map<Integer, Integer> map = new HashMap<>();

		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}

		Map<Integer, Integer> newMap = map.entrySet().stream().filter(x -> x.getValue() > val)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(newMap);

	}

}
