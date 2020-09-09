package playbookITC;

import java.util.HashMap;
import java.util.Map;

/*15.	Find Missing And Repeating
Example: {4, 3, 6, 2, 1, 1}
Output: 1, 5  // 5 is missing and 1 occurs twice
*/

public class MainClass15 {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 6, 2, 1, 1 };
		int sumPresent = 0;
		int totalSum = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			sumPresent = sumPresent + m.getKey();
			if (m.getValue() > 1) {
				System.out.println("repeated number is : " + m.getKey());
			}
		}

		for (int i = 1; i < 7; i++) {
			totalSum = totalSum + i;
		}

		System.out.println("Missing number is : " + (totalSum - sumPresent));

	}

}
