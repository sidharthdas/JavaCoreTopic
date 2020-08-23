package practice3.loadjavaclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student implements Cloneable{
	
	public void st() {
		System.out.println("in student class st method");
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

public class MainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		//First way
		
		Student s1  = new Student();
		s1.st();
		
		//Second way
		Student s2 = Student.class.newInstance();
		s2.st();
		
		//3rd way
		Student s3 = (Student) s2.clone();
		s3.st();
		
		//4th way
		
		Constructor cons = Student.class.getConstructor();
		Student s4 = (Student) cons.newInstance();
		
		s4.st();
		
	}

}
