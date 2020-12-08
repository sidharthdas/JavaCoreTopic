package practice16.immutable;

import java.util.ArrayList;
import java.util.List;

public final class Employee {
	
	private final int empId;
	private final String empName;
	private final ArrayList<Integer> list;
	
	
	public Employee(int empId, String empName, List<Integer> list) {
		super();
		this.empId = empId;
		this.empName = empName;
		ArrayList<Integer> list1 = new ArrayList<>();
		for(int i : list) {
			list1.add(i);
		}
		this.list = list1;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public ArrayList<Integer> getList() {
		return (ArrayList<Integer>) list.clone();
	}
	
	

}
