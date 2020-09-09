package playbookITC;

import java.util.Arrays;

//9.	Find the second smallest on array

/*Example: {12, 13, 1, 10, 34, 1}
Output: 10
Time: 15 min*/

public class MainClass9 {

	public static void main(String[] args) {

		int arr[] = { 12, 13, 1, 10, 34, 1 };
		
		Arrays.sort(arr);

		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] != arr[i+1]) {
				System.out.println(arr[i+1]);
				break;
			}
		}

	}
}