package practice10.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
	
	private void test() {
		System.out.println("in test");
	}
}

public class MainClass {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class c = Class.forName("practice10.reflection.Student");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("test", null);
		m.setAccessible(true);
		m.invoke(o, null);
		
	}

}
