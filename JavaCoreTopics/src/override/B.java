package override;

public class B extends A{
	
	
	
	public B(int i) {
		super(i);
	}

	@Override
	public void test() {
		System.out.println("In test method of B class");
	}

}
