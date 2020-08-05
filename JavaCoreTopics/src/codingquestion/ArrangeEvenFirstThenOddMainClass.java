package codingquestion;

import java.util.ArrayList;
import java.util.List;

public class ArrangeEvenFirstThenOddMainClass {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();

		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		numbers.add(11);
		numbers.add(12);
		numbers.add(13);
		
		int[] arr = new int[numbers.size()];
		
		int i = 0;
		int k = numbers.size() - 1;
		while(i < numbers.size()) {
			if(!isPrime(numbers.get(i))){
				arr[i] = numbers.get(i);
			}else {
				arr[k] = numbers.get(i);
				k--;
			}
			i++;
		}
		
		for(int j : arr) {
			System.out.print(arr[j]+" ");
		}
		
		/*
		 * List<Integer> numbersPrime = new ArrayList<>(); List<Integer> numbersOdd =
		 * new ArrayList<>();
		 * 
		 * for(int i : numbers) { if(ArrangeEvenFirstThenOddMainClass.isPrime(i)) {
		 * numbersPrime.add(i); }else { numbersOdd.add(i); } }
		 * 
		 * numbers = Stream.concat(numbersOdd.stream(),
		 * numbersPrime.stream()).collect(Collectors.toList());
		 * 
		 * System.out.println(numbers);
		 */

	}

	public static boolean isPrime(int a) {

		boolean prime = false;

		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				prime = true;
				break;
			}
		}
		return prime;

	}

}
