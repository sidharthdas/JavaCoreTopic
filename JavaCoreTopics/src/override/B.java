package override;

public class B extends A{
	
	
	
	public B(int i) {
		super(i);
	}

	@Override
	public void test() {
		System.out.println("In test method of B class");
	}
	
	public void test3() {
		System.out.println("in test 3 method of B class");
	}
}
