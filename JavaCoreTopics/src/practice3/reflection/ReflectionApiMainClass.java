package practice3.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApiMainClass {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		
		
		Class c = Class.forName("practice3.reflection.Student");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("testStudent", null);
		m.setAccessible(true);
		m.invoke(o, null);
		
	}

}
