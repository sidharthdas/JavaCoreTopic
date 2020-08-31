package practice5.generic;

class Student {

	private String studName;
	private int id;
	
	

	public Student(String studName, int id) {
		this.studName = studName;
		this.id = id;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [studName=" + studName + ", id=" + id + "]";
	}

}

public class MainClass {

	public static void main(String[] args) {
		
		JsonResponse<Student> res = new JsonResponse<Student>();
		res.setT(new Student("test", 1));
		res.setName("first");
		
		System.out.println(res);

	}

}
