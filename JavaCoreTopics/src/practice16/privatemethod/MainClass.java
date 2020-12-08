package practice16.privatemethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Employee{
	private void test() {
		System.out.println("in private method");
	}
}

public class MainClass {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Class c = Class.forName("practice16.privatemethod.Employee");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("test", null);
		m.setAccessible(true);
		m.invoke(o, null);
	}

}
