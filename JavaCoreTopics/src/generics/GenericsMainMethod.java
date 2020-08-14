package generics;

public class GenericsMainMethod<T> {
	
	
	
	
	public static void main(String[] args) {	
		  MyGeneric<String> str = new MyGeneric<>(); str.display("Ram");
		  System.out.println(str.get());
		  
		  
		  MyGeneric<Integer> num = new MyGeneric<>(); num.display(1);
		  System.out.println(num.get());
		  
		  String[] names = {"Sid","Ram", "Raju"}; display(names);
		  
		  Integer[] nums = {1,2,3,4,5,6,7}; display(nums);
		 
		
		
		//BaseDTO<>
		
		Student std = new Student();
		std.setId(1);
		std.setStudentName("Sidharth");
		std.setStudentAddress("Banglore");
		
		JsonResponse<Student> jsonStudent = new JsonResponse<>();
		
		jsonStudent.setId(1);
		jsonStudent.setBaseDTOName("StudentDTO");
		jsonStudent.setObjT(std);
		
		System.out.println(jsonStudent);
		
		
		GenericsMainMethod<Student> t = new GenericsMainMethod<Student>();
		t.show(std);
		
		Student std3 = t.show(std);
		
		System.out.println(std3);
		
		final int j;
		

		
	}
	
	//Generic method
	public static <E> void display(E[] arr) {
		
		for(E e : arr) {
			System.out.println(e);
		}
		
	}
	
	//Generic method
	@SuppressWarnings("unchecked")
	public T show(T t) {
		
		Student s3 = new Student();
		
		if(Student.class.isInstance(t)) {
			System.out.println("pass");
		}
		Student s  = (Student) t;
		s.setStudentName("Test");
		return (T) s;
	}
	
	

}
