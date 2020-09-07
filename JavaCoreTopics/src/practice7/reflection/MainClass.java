package practice7.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student {

	private void test() {
		System.out.println("hello world");
	}
}

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		Class c = Class.forName("practice7.reflection.Student");
		Object o = c.newInstance();

		Method m = c.getDeclaredMethod("test", null);
		m.setAccessible(true);
		m.invoke(o, null);
	}

}
