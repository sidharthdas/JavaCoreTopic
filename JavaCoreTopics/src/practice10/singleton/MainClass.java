package practice10.singleton;

public class MainClass {
	public static void main(String[] args) {
		
		System.out.println(Student.getInstance().hashCode());
		System.out.println(Student.getInstance().hashCode());
	}
}
