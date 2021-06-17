package test;

import java.util.ArrayList;
import java.util.List;

public class MainClass2 {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3 };
		int div = 2;

		int digit = 8;

		int[] arr1 = {5,8,7,12,14,3,9};
		MainClass2.test(arr1, div, digit);
//Sidharth Das//
		
	}

	public static void test(int[] arr, int div, int digit) {
		List<List<Integer>> mainList = new ArrayList<>();
		// boolean flag = false;
		int size = arr.length;
		List<Integer> l1 = null;
		for (int i = 0; i < size; i++) {

			if (i == 0) { //sidharthdas
				l1 = new ArrayList<>();
				l1.add(arr[i]);
				// flag = true;
			} else {
				if (i % div != 0) {
					l1.add(arr[i]);
				} else {
					mainList.add(l1);
					l1 = new ArrayList<>();
					l1.add(arr[i]);
				}
			}
		}
		mainList.add(l1);


		System.out.println(mainList);

		boolean flag = true;
		for (List<Integer> l : mainList) {
			if (!l.contains(digit)) {
				flag = false;
				break;
			}
		}

		System.out.println(flag);

	}
}
