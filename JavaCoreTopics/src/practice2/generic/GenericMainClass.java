package practice2.generic;

class Student {

	private int id;
	private String studentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}
	
	

}

public class GenericMainClass<T> {

	public static void main(String[] args) {
		
		JsonResponse<Student> st = new JsonResponse<Student>();
		Student s = new Student();
		s.setId(1);
		s.setStudentName("Sid");
		
		st.setT(s);
		GenericMainClass<Student> s4 = new GenericMainClass<Student>();
		System.out.println(s4.show(st.getT()));

	}
	
	public  T show(T e) {
		Student e1 = (Student) e;
		
		return (T) e1;
	}

}
