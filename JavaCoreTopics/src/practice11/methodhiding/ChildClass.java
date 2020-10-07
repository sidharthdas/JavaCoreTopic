package practice11.methodhiding;

public class ChildClass extends SuperClass {

	public static void test2() {
		System.out.println("in  child class test2 method ");
	}

	@Override
	public void test1() {
		System.out.println("in test1 override method");
	}

}
