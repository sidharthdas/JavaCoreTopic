package playbookITC;

import java.util.ArrayList;
import java.util.List;

/*12.	Merge Two Sorted Arrays
Example: { 5, 8, 9} {4, 7, 8}
Output: {4, 5, 7, 8, 8, 9}*/

public class MainClass12 {

	public static void main(String[] args) {

		int[] arr = { 5, 8, 9 };
		int[] arr1 = { 4, 7, 8 };
		
		List<Integer> finalList = new ArrayList<>();

		//int[] arr3 = new int[(arr.length + arr.length)];
		
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i]< arr1[i]) {
				finalList.add(arr[i]);
				finalList.add(arr1[i]);
			}else {
				finalList.add(arr1[i]);
				finalList.add(arr[i]);
			}
		}
		
		System.out.println(finalList);
	}

}
