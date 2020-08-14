package generics;

import java.util.Arrays;
import java.util.List;

public class GenericsMainMethod {
	
	
	public static void main(String[] args) {
		
		MyGeneric<String> str = new MyGeneric<>();
		str.display("Ram");
		System.out.println(str.get());
		
		
		MyGeneric<Integer> num = new MyGeneric<>();
		num.display(1);
		System.out.println(num.get());
		
		String[] names = {"Sid","Ram", "Raju"};
		display(names);
		
		Integer[] nums = {1,2,3,4,5,6,7};
		display(nums);
		
	}
	
	//Generic method
	public static <E> void display(E[] arr) {
		
		for(E e : arr) {
			System.out.println(e);
		}
		
	}
	
	

}
