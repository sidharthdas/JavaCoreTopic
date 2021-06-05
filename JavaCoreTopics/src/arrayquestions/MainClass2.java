package arrayquestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//How do you find the duplicate number on a given integer array?
public class MainClass2 {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 6, 7, 4, 8, 10 };

		// int size = arr.length;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		Map<Integer, Integer> newMap = map.entrySet().stream().filter(x -> x.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		
		/*
		 * Map<Integer, Integer> newMap1 =
		 * map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).
		 * collect(Coll) System.out.println(newMap);
		 */

	}

}
