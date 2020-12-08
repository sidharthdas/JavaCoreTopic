package practice15.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	private int empId;
	private String empName;
	private int empSal;

	public Employee(int empId, String empName, int empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

}

public class ComparatorMainClass {

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(new Employee(1, "Test1", 10000), new Employee(2, "Test2", 20000),
				new Employee(1, "Test3", 90000), new Employee(1, "Test4", 80000), new Employee(1, "Test5", 100000),
				new Employee(1, "Test6", 7000));

		Comparator<Employee> comp = (Employee o1, Employee o2) -> {
			if (o1.getEmpSal() > o2.getEmpSal()) {
				return 1;
			} else if (o1.getEmpSal() < o2.getEmpSal()) {
				return -1;
			} else {
				return 0;
			}
		};

		Collections.sort(empList, comp);
		
		System.out.println(empList);
	}

}
