package practice3.statickeyword;

public class MainClass {
	
	public MainClass() {
		System.out.println("in const");
	}
	
	static {
		System.out.println("in static block");
	}
	
	{
		System.out.println("in non-static block");
	}
	
	public static void main(String[] args) {
		
		MainClass c = new MainClass();
		c.test();
		
	}
	
	public void test() {
		System.out.println("in test method");
	}

}
