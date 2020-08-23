package practice3.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExMainClass {

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(new Employee(1, "test1", 20000, 21),
				new Employee(2, "test2", 200000, 60), new Employee(3, "test3", 120000, 31));
		
		Collections.sort(empList, new SalaryComparator());
		
		//Sorting by salary
		System.out.println("Sorting by salary");
		System.out.println(empList);
		
		Comparator<Employee> sorting = (Employee e1, Employee e2)->{
			if(e1.getAge()>e2.getAge()) {
				return 1;
			}else if(e1.getAge()<e2.getAge()) {
				return -1;
			}else {
				return 0;
			}
		};
		
		//Sorting by age
		System.out.println("Sorting by age");
		Collections.sort(empList, sorting);
		System.out.println(empList);
	}

}
