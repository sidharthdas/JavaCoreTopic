package playbookITC;

import java.util.ArrayList;
import java.util.List;

/*17.	Insert element in a sorted array
Example: { 12, 16, 20, 40, 50, 70 } Insert 58
Output: { 12, 16, 20, 40, 50, 58, 70 }
*/

public class MainClass17 {

	public static void main(String[] args) {

		int[] arr = { 12, 16, 20, 40, 50, 70, 400, 450 };

		int numTo = 58;
		List<Integer> num = new ArrayList<>();
		int check = 0;

		for (int i = 0; i < arr.length; i++) {
			if (numTo > arr[i]) {
				num.add(arr[i]);
			} else if (numTo < arr[i] && check == 0) {
				num.add(numTo);
				num.add(arr[i]);
				check = 1;
			} else {
				num.add(arr[i]);
			}
		}

		System.out.println(num);

	}

}
