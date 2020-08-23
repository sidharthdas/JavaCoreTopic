package practice3.abstractclass;

public interface InterfaceClass {
	
	int i = 20;
	
	
	void test();
	
	default void test2() {
		System.out.println("in default test2 method of Interface class");
	}
	
	static void test3() {
		System.out.println("in static test3 method of Interface class");
	}

	int test1();

}
