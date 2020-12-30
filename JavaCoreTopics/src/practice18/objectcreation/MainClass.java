/**
 * 
 */
package practice18.objectcreation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author sidharthdas
 *
 */

class Employee implements Cloneable{
	
	public void test() {
		System.out.println("in employee class");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
public class MainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException {
		
		
		Employee emp = new Employee();
		emp.test();
		
		Employee emp2 = Employee.class.newInstance();
		emp2.test();
		
		Constructor con = Employee.class.getDeclaredConstructor(null);
		Employee emp3 = (Employee) con.newInstance(null);
		emp3.test();
		
		Employee emp4 = (Employee) emp3.clone();
		emp4.test();
		
	}

}
