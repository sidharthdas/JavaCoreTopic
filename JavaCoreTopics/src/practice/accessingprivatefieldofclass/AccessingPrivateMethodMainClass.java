package practice.accessingprivatefieldofclass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

class Student {
	
	private int rollNo = 10;
	private String name = "Sidharth";
	
	private void show(String name) {
		System.out.println("name : "+this.name+" & rollNo is "+rollNo);
	}
}

public class AccessingPrivateMethodMainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class c = Class.forName("practice.accessingprivatefieldofclass.Student");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("show", null);
		m.setAccessible(true);
		m.invoke(o, null);
	}

}
