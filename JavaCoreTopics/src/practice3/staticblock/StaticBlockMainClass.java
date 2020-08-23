package practice3.staticblock;

public class StaticBlockMainClass {
	
	static {
		System.out.println("in static block of StaticBlockMainClass");
	}
	
	{
		System.out.println("in non static block of StaticBlockMainClass");
	}
	
	public static void main(String[] args) {
		
		//test();
		Test te = new Test();
		
	}
	
	
	public static void test() {
		System.out.println("In test method of StaticBlockMainClass");
	}
}
