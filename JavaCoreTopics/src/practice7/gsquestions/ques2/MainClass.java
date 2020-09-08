package practice7.gsquestions.ques2;

import java.util.Arrays;

//Check if two arrays are equal or not
public class MainClass {

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 5, 4, 0 };
		int arr2[] = { 2, 4, 5, 0, 1 };

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		
		String s1 = Arrays.toString(arr1);
		String s2 = Arrays.toString(arr2);
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s1.equals(s2) ? true : false);
	}

}
