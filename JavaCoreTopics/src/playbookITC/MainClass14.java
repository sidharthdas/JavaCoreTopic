package playbookITC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//14.	Second most repeated string in a sequence

/*Example: {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"}
Output: “bbb”
*/
public class MainClass14 {

	public static void main(String[] args) {

		// List<Integer> val = new ArrayList<>();

		String[] str = { "aaa", "bbb", "ccc", "bbb", "aaa", "aaa" };

		Map<String, Integer> map = new HashMap<>();

		for (String s : str) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}

		int[] num = new int[map.size()];
		int i = 0;
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			// System.out.println(m.getValue());
			num[i] = m.getValue();
			i++;
		}

		Arrays.sort(num);

		int index = num[(map.size() - 2)];

		for (Map.Entry<String, Integer> m : map.entrySet()) {
			if (m.getValue() == index) {
				System.out.println(m.getKey());
			}
		}

	}

}
