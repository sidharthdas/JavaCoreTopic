/**
 * 
 */
package practice18.privateMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sidharthdas
 *
 */

class Employee{
	
	private void test() {
		System.out.println("in private method");
	}
}
public class MainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		
		
		Class c = Class.forName("practice18.privateMethod.Employee");
		Object o = c.newInstance();
		
		Method m = c.getDeclaredMethod("test", null);
		m.setAccessible(true);
		m.invoke(o, null);
	}

}
