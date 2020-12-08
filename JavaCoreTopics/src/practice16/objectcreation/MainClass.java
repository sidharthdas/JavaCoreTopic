package practice16.objectcreation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Employee implements Cloneable{
	public void test() {
		System.out.println("in emp class");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

public class MainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException {
		//1st
		Employee emp = new Employee();
		emp.test();
		
		//2nd
		Employee emp2 = Employee.class.newInstance();
		emp2.test();
		
		//3rd
		Constructor con = Employee.class.getDeclaredConstructor(null);
		Employee emp3 = (Employee) con.newInstance(null);
		emp3.test();
		
		Employee emp4 = (Employee) emp.clone();
		emp4.test();
	}

}
