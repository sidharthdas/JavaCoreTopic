package practice15.privatemethodinvoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Employee{
	
	private void test() {
		System.out.println("in private method");
	}
}

public class PrivateMethodMainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Class c = Class.forName("practice15.privatemethodinvoke.Employee");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("test", null);
		m.setAccessible(true);
		m.invoke(o, null);
	}

}
