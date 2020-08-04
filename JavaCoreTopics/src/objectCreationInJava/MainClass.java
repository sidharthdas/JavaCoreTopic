package objectCreationInJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student implements Cloneable{
	
	public void studentHello() {
		System.out.println("in studentHello method of student class");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}

public class MainClass {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		//Fist way
		
		Student std = new Student();
		std.studentHello();
		
		//2nd way
		
		Student std1 = (Student) Class.forName("objectCreationInJava.Student").newInstance();
		std1.studentHello();
		
		//or
		
		Student std5 = Student.class.newInstance();
		std5.studentHello();
		
		//3rd way
		Student std2 = new Student();
		Student std3 = (Student) std2.clone();
		std3.studentHello();
		
		//4th way
		
		Constructor<Student> constructor = Student.class.getConstructor();
		
		Student std6 =constructor.newInstance();
		std6.studentHello();
		
		
	}

}
