package thisandsuperlevel;

public class Base {

	int a;
	int b;

	public Base(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	
	public void getValue() {
		System.out.println("a : "+a);
		System.out.println("b : "+b);
	}

}
