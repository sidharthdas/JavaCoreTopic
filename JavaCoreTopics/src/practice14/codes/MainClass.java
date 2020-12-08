package practice14.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> nums3 = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		//Add list of integers using stream
		int sum = nums.stream().mapToInt(Integer::intValue).sum();

		List<List<Integer>> listOf = new ArrayList<>();

		listOf.add(nums3);
		listOf.add(nums1);
		listOf.add(nums2);
		listOf.add(nums);

		//Add list of list of integers using stream API
		int sumTotal = listOf.stream().map(x -> x.stream().mapToInt(Integer::intValue).sum())
				.mapToInt(Integer::intValue).sum();
		System.out.println(sumTotal);
	

		System.out.println(sum);
	}

}
