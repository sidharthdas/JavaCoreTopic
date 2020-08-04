package codingquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckNumbersPresentOrNotMainClass {
	
	public static void main(String[] args) {
		
		List<Integer> file1 = new ArrayList<>();
		List<Integer> file2 = new ArrayList<>();
		
		file1.add(1);
		file1.add(2);
		file1.add(3);
		file1.add(4);
		file1.add(5);
		file1.add(6);
		file1.add(7);
		file1.add(8);
		file1.add(9);
		file1.add(10);
		
		file2.add(5);
		file2.add(6);
		file2.add(7);
		file2.add(8);
		file2.add(9);
		file2.add(10);
		file2.add(11);
		file2.add(12);
		file2.add(13);
		file2.add(14);
		file2.add(15);

		List<Integer> newFile = file2.stream().filter(num -> !file1.contains(num)).collect(Collectors.toList());
		
		System.out.println(newFile);
	}

}
