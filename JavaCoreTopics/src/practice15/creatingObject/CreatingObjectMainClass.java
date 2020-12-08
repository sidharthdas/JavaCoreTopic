package practice15.creatingObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Employee implements Cloneable{
	
	public void emp() {
		System.out.println("emp");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}

public class CreatingObjectMainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException {
		
		//1st using new operator
		Employee emp = new Employee();
		emp.emp();
		
		//2nd using newInstance
		Employee emp1 = Employee.class.newInstance();
		emp1.emp();
		
		//3rd using Constructor
		Constructor constr = Employee.class.getDeclaredConstructor(null);
		Employee emp3 = (Employee) constr.newInstance(null);
		emp3.emp();
		
		//4th using clone
		Employee emp4 = (Employee) emp1.clone();
		emp4.emp();
		
	}

}
