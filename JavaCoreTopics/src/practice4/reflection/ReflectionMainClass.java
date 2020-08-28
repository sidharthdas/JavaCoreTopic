package practice4.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
	
	private void getStudent() {
		System.out.println("In private method of student class");
	}
}

public class ReflectionMainClass {
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		
		
		Class c = Class.forName("practice4.reflection.Student");
		Object o = c.newInstance();
		
		Method m = c.getDeclaredMethod("getStudent", null);
		m.setAccessible(true);
		m.invoke(o, null);
		
		
		
	}

}
