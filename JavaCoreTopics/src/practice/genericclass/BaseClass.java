package practice.genericclass;

public class BaseClass<T> {
	
	T obj;
	int id = 10;
	
	
	public void test() {
		Student s = (Student) obj;
		System.out.println(s.name);
	}

}
