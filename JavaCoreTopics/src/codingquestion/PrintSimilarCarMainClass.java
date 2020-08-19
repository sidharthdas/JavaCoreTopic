package codingquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintSimilarCarMainClass {

	public static void main(String[] args) {

		String[] strArr = { "coobk", "loobk", "book",  "toobk"};

		Map<String, Integer> mainMainMap = new HashMap<>();

		List<Map<String, Integer>> mapOfnames = new ArrayList<>();
		List<String> mainList1 = new ArrayList<>();

		for (String str4 : strArr) {

			Map<String, Integer> map0 = new HashMap<>();

			for (String s : str4.split("")) {
				if (map0.containsKey(s)) {
					map0.put(s, map0.get(s) + 1);
				} else {
					map0.put(s, 1);
				}
			}
			mapOfnames.add(map0);

		}

		for (Map.Entry<String, Integer> m : mapOfnames.get(0).entrySet()) {
			int count = 0;
			for (Map<String, Integer> m00 : mapOfnames) {
				if (m00.containsKey(m.getKey())) {
					count++;
					continue;
				} else {
					break;
				}
			}

			if (count == mapOfnames.size()) {
				List<Integer> val = new ArrayList<>();
				for (Map<String, Integer> m00 : mapOfnames) {
					val.add(m00.get(m.getKey()));
				}

				Collections.sort(val);
				mainMainMap.put(m.getKey(), val.get(0));

			}

		}
		
		
		for (Map.Entry<String, Integer> m : mainMainMap.entrySet()) {
			int val = m.getValue();
			while (val != 0) {
				mainList1.add(m.getKey());
				val--;
			}
		}

		System.out.println(mainList1);

		/*
		 * System.out.println(mainMainMap);
		 * 
		 * Map<String, Integer> map = new HashMap<>(); Map<String, Integer> map1 = new
		 * HashMap<>(); Map<String, Integer> map2 = new HashMap<>(); List<String>
		 * mainList = new ArrayList<>();
		 * 
		 * Map<String, Integer> mainMap = new HashMap<>();
		 * 
		 * for (String s : strArr[0].split("")) { if (map.containsKey(s)) { map.put(s,
		 * map.get(s) + 1); } else { map.put(s, 1); } }
		 * 
		 * for (String s : strArr[1].split("")) {
		 * 
		 * if (map1.containsKey(s)) { map1.put(s, map1.get(s) + 1); } else { map1.put(s,
		 * 1); }
		 * 
		 * }
		 * 
		 * for (String s : strArr[2].split("")) {
		 * 
		 * if (map2.containsKey(s)) { map2.put(s, map2.get(s) + 1); } else { map2.put(s,
		 * 1); }
		 * 
		 * }
		 * 
		 * for (Map.Entry<String, Integer> m : map.entrySet()) { if
		 * (map1.containsKey(m.getKey()) && map2.containsKey(m.getKey())) {
		 * List<Integer> num = new ArrayList<>(); num.add(m.getValue());
		 * num.add(map1.get(m.getKey())); num.add(map2.get(m.getKey()));
		 * 
		 * Collections.sort(num);
		 * 
		 * mainMap.put(m.getKey(), num.get(0));
		 * 
		 * } }
		 * 
		 * // System.out.println(mainMap);
		 * 
		 * for (Map.Entry<String, Integer> m : mainMap.entrySet()) { int val =
		 * m.getValue(); while (val != 0) { mainList.add(m.getKey()); val--; } }
		 * 
		 * System.out.println(mainList);
		 */
	}

}
