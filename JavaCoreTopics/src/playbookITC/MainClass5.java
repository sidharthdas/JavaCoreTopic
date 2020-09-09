package playbookITC;

import java.util.Arrays;

//5.	/* Second Smallest */
/*Q1. Find the second smallest number in a one-dimensional array. Using 2 ‘for’ loops
Q2. Find the second smallest number in a one-dimensional array. Using 1 ‘for’ loop*/

public class MainClass5 {
	
	
	public static void main(String[] args) {
		
		int arr[]  = {1,2,3,5,0,5};
		
		
		Arrays.sort(arr);
		
		System.out.println(arr[1]);
		
	}

}
