package playbookITC;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*21. Given a 2 dimensional array that holds student name and score,calculate the maximum average score.
A student can have multiple entry with different score.

Example:
Input:
[
  {
      "Bob",80
       "Charles",85
       "Rob",70  
       "Bob",100  
       "Charles",75
  }
]

Output would be 90 which is the highest average score of Bob 

*/
public class MainClass21 {

	public static void main(String[] args) {
		Map<String, Integer> mapValues = new HashMap<>();
		Map<String, Integer> mapMarks = new HashMap<>();
		
		final int mainmark ;
		int mark = 0;

		String s[][] = { { "jerry", "65" }, { "bob", "80" }, { "jerry", "23" }, { "bob", "100" },{ "Eric", "83" } };

		for (String[] s1 : s) {
			if (mapValues.containsKey(s1[0]) && mapMarks.containsKey(s1[0])) {
				mapValues.put(s1[0], mapValues.get(s1[0]) + 1);
				mapMarks.put(s1[0], mapMarks.get(s1[0]) + Integer.parseInt(s1[1]));
			} else {
				mapValues.put(s1[0], 1);
				mapMarks.put(s1[0], Integer.parseInt(s1[1]));
			}
		}

		for (Map.Entry<String, Integer> map : mapMarks.entrySet()) {
			int val = mapValues.get(map.getKey());
			map.setValue((map.getValue() / val));
		}

		for (Map.Entry<String, Integer> map : mapMarks.entrySet()) {

			if (mark < map.getValue()) {
				mark = map.getValue();
			}
		}
		
		mainmark = mark;

		Map<String, Integer> mainMap = mapMarks.entrySet().stream().filter(x -> x.getValue() == mainmark)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(mainMap);

	}

}
