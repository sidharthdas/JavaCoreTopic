package codingquestion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		List<Integer> numbersPrime = new ArrayList<>();
		List<Integer> numbersOdd = new ArrayList<>();

		for(int i : numbers) {
			if(ArrangeEvenFirstThenOddMainClass.isPrime(i)) {
				numbersPrime.add(i);
			}else {
				numbersOdd.add(i);
			}
		}
		
		numbers = Stream.concat(numbersOdd.stream(), numbersPrime.stream()).collect(Collectors.toList());
		
		System.out.println(numbers);

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
