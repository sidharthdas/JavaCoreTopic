package methodreference;

interface Sayable {

	void say();
}

interface HelloWorld {

	void hello();
}

interface StudentInterface {

	Student getStudent();
}

class Student {

	public Student() {
		System.out.println("in constructor of Student class");
	}
}

public class MethodReferenceMainClass {

	public static void main(String[] args) {

		// Method reference to a static method
		Sayable sayable = MethodReferenceMainClass::hello;
		sayable.say();

		// Method reference to a non-static method
		HelloWorld helloWord = new MethodReferenceMainClass()::hey;
		helloWord.hello();

		// Method reference to a Constructor
		StudentInterface studentInterface = Student::new;
		studentInterface.getStudent();

	}

	public static void hello() {
		System.out.println("in hello method of MerthodReference class");
	}

	public void hey() {
		System.out.println("in hey method of MerthodReference class");
	}

}
