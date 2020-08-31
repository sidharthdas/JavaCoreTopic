package practice5.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
	
	private void test() {
		System.out.println("in private method");
	}
}

public class ReflectipnMainClass {
	
	
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Class c = Class.forName("practice5.reflection.Student");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("test", null);
		m.setAccessible(true);
		m.invoke(o, null);
		
	}

}
