package practice5.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {
	
	public static void main(String[] args) {
		
		
		List<Student> studentList = Arrays.asList(new Student(1, "Test1", 10000),
				new Student(2, "test2", 5000),
				new Student(3, "test3", 50000),
				new Student(4, "test5", 24000),
				new Student(5, "test4", 16000));
		
		System.out.println("Sorting by salary");
		
		
		Comparator<Student> comp = (Student o1, Student o2)->{
			if(o1.getSalary()> o2.getSalary()) {
				return 1;
			}else if(o1.getSalary()< o2.getSalary()) {
				return -1;
			}else {
				return 0;
			}
		};
		
		Collections.sort(studentList, comp);
		System.out.println(studentList);
	}

}
