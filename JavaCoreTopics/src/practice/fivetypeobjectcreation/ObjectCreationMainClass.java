package practice.fivetypeobjectcreation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student implements Cloneable{
	
	public void add() {
		System.out.println("in add method of student class");
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

public class ObjectCreationMainClass {
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		//First way
		Student std = new Student();
		std.add();
		
		//Second way
		Student std1 = Student.class.newInstance();
		std1.add();
		
		//3rd way
		Student std2 = (Student) std1.clone();
		std2.add();
		
		//4th way
		
		Constructor<Student> con = Student.class.getConstructor();
		Student std4 = (Student) con.newInstance();
		std4.add();
	}

}
