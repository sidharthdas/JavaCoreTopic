package sortingcollectionwithlambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListSortingUsingLAMBDAmainClass {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 8, 77, 444, 22, 2, 3, 4, 5);

		Collections.sort(list, (I1, I2) -> (I1 > I2) ? 1 : (I1 < I2) ? -1 : 0);

		// System.out.println(list);

		int[] nums = { 3,2,4 };

		

		int[] indexes = new int[2];
		int x = 0;
		int target = 6;

		for (int i = 0; i < nums.length; i++) {

			if (contain(nums, target - nums[i])) {
				indexes[x] = index(nums, nums[i]);
				x += 1;
				indexes[x] = index(nums, (target - nums[i]));
				break;
			}
		}

		for(int i : indexes) {
			System.out.print(i +" ");
		}

	}

	public static boolean contain(int[] arr, int num) {
		boolean isPresent = false;
		for (int i : arr) {
			if (i == num) {
				isPresent = true;
				break;
			}
		}

		return isPresent;
	}

	public static int index(int[] arr, int num) {
		if (arr.length == 0) {
			return -1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				return i;
			}
		}

		return -1;

	}

}
