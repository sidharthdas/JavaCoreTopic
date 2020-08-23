package practice3.staticblock;

public class Test {
	
	
	public Test() {
		System.out.println("in test constructor");
	}
	
	static {
		System.out.println("in static block of test class");
	}
	
	{
		System.out.println("in non-static block of test class");
	}
}
