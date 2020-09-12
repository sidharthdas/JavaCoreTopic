package playbookITC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*7.	Given a group of words we need to write a code which will group the words which are anagrams of each other. 
For e.g. [art,cheese,cat,rat,tar,act,tca]
Output: [[art,rat,tar],[cat,act,tca],[cheese]] 
Time:30min
*/

public class MainClass7 {

	public static void main(String[] args) {

		String[] arr = { "art", "cheese", "cat", "rat", "tar", "act", "tca" };

		Map<String, List<String>> map = new HashMap<>();

		for (String s : arr) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String newS = String.valueOf(c);

			if (map.containsKey(newS)) {
				List<String> list = map.get(newS);
				list.add(s);
				map.put(newS, list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(newS, list);

			}
		}
		
		System.out.println(map);
	}

}
