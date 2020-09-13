package practice10.objectcreation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student implements Cloneable {
	public void test() {
		System.out.println("student");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

public class MainClass {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, CloneNotSupportedException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {

		Student s1 = new Student();
		s1.test();

		Student s2 = Student.class.newInstance();
		s2.test();
		
		Student s3 = (Student) s2.clone();
		s3.test();
		
		Constructor con = Student.class.getDeclaredConstructor(null);
		Student s4 = (Student) con.newInstance(null);
		s4.test();

	}

}
