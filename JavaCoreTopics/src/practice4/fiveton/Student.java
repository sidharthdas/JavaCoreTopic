package practice4.fiveton;

public class Student {
	
	private static final Student[] instances = new Student[5];
	private static int index = 0;
	
	private Student() {
		
	}
	
	public static Student getInstance() {
		if(instances[index] == null) {
			instances[index] = new Student();
		}
		Student instance = instances[index];
		index = (index + 1) % instances.length;
		System.out.println(index);
		return instance;
	}
	
	

}
