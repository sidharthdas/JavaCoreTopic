package practice.genericclass;

public class GeenricMainClass {
	
	public static void main(String[] args) {
		Student s = new Student(10, "Sidharth");
		
		BaseClass<Student> base = new BaseClass<Student>();
		base.id = 1;
		base.obj = s;
		
		base.test();
	}

}
