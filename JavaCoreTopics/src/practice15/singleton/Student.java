package practice15.singleton;

public class Student {

	private static Student student;

	private Student() {

	}

	public static Student getInstance() {
		if (student == null) {
			student = new Student();
		}

		return student;
	}

}
