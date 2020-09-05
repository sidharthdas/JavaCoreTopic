package practice6.singleton;

public class Student {

	private static Student instance;

	private Student() {

	}

	public static Student getInstance() {
		return instance == null ? instance = new Student() : instance;
	}

}
