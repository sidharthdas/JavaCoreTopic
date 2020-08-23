package practice3.privatemethodinvoking;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
	
	private void getStudent() {
		System.out.println("in stident method");
	}
}

public class MainClass {
	
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Class c = Class.forName("practice3.privatemethodinvoking.Student");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("getStudent", null);
		m.setAccessible(true);
		m.invoke(o, null);
		
	}

}
