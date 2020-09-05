package arrayquestions;

import java.util.HashSet;
import java.util.Set;

//How do you find all pairs of an integer array whose sum is equal to a given number?
public class MainClass4 {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 5, 4, 8, 4, 10, 11 };
		int sum = 12;
		printPair(arr, sum);
	}

	public static void printPair(int[] arr, int a) {

		Set<Integer> indexes = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {

			if (!indexes.contains(i)) {

				for (int j = 0; j < arr.length; j++) {
					if (i != j) {
						if (!indexes.contains(j)) {
							if (arr[i] + arr[j] == a) {
								System.out.println(arr[i] + " " + arr[j]);
								indexes.add(i);
								indexes.add(j);
							}
						}
					}
				}

			}
		}

	}
}
