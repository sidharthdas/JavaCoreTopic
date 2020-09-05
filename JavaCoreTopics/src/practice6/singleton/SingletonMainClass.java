package practice6.singleton;

public class SingletonMainClass {
	
	
	public static void main(String[] args) {
		System.out.println(Student.getInstance());
		System.out.println(Student.getInstance());
	}

}
