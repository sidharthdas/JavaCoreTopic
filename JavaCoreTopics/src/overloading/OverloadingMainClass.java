package overloading;

class Test{
	
	
	public static void m1(String s1) {
		System.out.println("In string argument method");
	}
	
	public static void m1(Object o1) {
		System.out.println("In Object argument method");
	}
	
	
}

public class OverloadingMainClass {
	
	public static void main(String[] args) {
		
		//here String will get preference
		Test t = new Test();
		t.m1("String");
		
		
	}

}
