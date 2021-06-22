package accessingprivatememberusingreflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DemoTest{
	private int i;
	private String name;
	
	private void show() {
		System.out.println("In private show method of Student class");
	}
}

public class ReflectionMainClass {//
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		/*
		 * String s = "1\n,2,3"; if(s.isBlank()) { return; } if(s.contains("\n,")) {
		 * return; } int sum = 0; String s1 =
		 * s.replaceAll(System.getProperty("line.separator"), ","); String[] stringArr =
		 * s1.split(","); for(String str : stringArr) {
		 * 
		 * sum = sum + Integer.parseInt(str);
		 * 
		 * }
		 * 
		 * System.out.println(sum);
		 */
		
		
	}

}
