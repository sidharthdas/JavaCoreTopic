package practice12.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
	
	private void test() {
		System.out.println("in test method");
	}
	
	public void test1() {
		System.out.println("in test1 method");
	}
}

public class MainClass {
	
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Class c = Class.forName("practice12.reflection.Student");
		Object o = c.newInstance();
		
		Method m = c.getDeclaredMethod("test", null);
		m.setAccessible(true);
		m.invoke(o, null);
		
		
		Student s = Student.class.newInstance();
		s.test1();
		
		
		Constructor con = Student.class.getDeclaredConstructor(null);
		Student s1 = (Student) con.newInstance(null);
		s1.test1();
	}

}
