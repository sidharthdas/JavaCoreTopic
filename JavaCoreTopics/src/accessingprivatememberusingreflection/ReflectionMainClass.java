package accessingprivatememberusingreflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionMainClass {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		
		Class c = Class.forName("accessingprivatememberusingreflection.Student");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("show", null);
		m.setAccessible(true);
		m.invoke(o, null);
		
		
	}

}
