package singleton;

public class Student {
	
	private int studentId;
	private static Student studentInstance;
	
	private Student(int studentId) {
		this.studentId = studentId;
		
	}
	 
	public static Student getInstance(int studentId) {
		if(studentInstance == null) {
			studentInstance = new Student(studentId);
		}
		
		return studentInstance;
		
	}

}
