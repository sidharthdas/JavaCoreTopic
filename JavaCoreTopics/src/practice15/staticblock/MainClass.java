package practice15.staticblock;

class Test {
	static {
		System.out.println("test static");
	}
	{
		System.out.println("test non static");
	}

	public Test() {
		System.out.println("test const");
	}
}

public class MainClass {

	static {
		System.out.println("in static b.ock");
	}
	{
		System.out.println("in non-static");
	}

	public MainClass() {
		System.out.println("in const");
	}

	

	public static void main(String[] args) {

		//Test m = new Test();
	}

}
