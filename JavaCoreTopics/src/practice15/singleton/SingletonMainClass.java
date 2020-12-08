package practice15.singleton;

public class SingletonMainClass {
	
	public static void main(String[] args) {
		
		System.out.println(Student.getInstance().hashCode());
		System.out.println(Student.getInstance().hashCode());
	}

}
