package practice3.generic;

public class GenerericMainClass<T> {
	
	public static void main(String[] args) {
		Student s = new Student();
		s.setId(1);
		s.setStudentName("Sidharth");
		
		JsonResponse<Student> json = new JsonResponse<>();
		json.setT(s);
		json.setId("1");
		
		System.out.println(getStudent(json));
	}
	
	public static Student getStudent(JsonResponse r) {
		return (Student) r.getT();
	}
	
	public T getClass(T t) {
		return t;
		
	}

}
