package codingquestion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student{
	public void studentTest() {
		System.out.println("In student test method. . .");
	}
}

public class ClassLoadingDynamicallyMainClass {
	
	
	public static final void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Student  student = (Student) Class.forName("codingquestion.Student").newInstance();
		
		student.studentTest();
		
		Student student1 = Student.class.newInstance();
		student1.studentTest();
		
		Constructor con = Student.class.getConstructor();
		Student student3 = (Student) con.newInstance();
		student3.studentTest();
		
		
		
	}

}
