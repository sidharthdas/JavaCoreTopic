package practice16.upcastingdowncasting;

class A{
	public void add() {
		System.out.println("in add method of A ");
	}
	
	public void aa() {
		System.out.println("in aa");
	}
}

class B extends A {
	@Override
	public void add() {
		System.out.println("in add method of B overided");
	}
	
	public void bb() {
		System.out.println("in bb");
	}
}

public class MainClass {
	
	public static void main(String[] args) {
		
		
		A a = new B();
		B b = (B) a;
		
		b.aa();
		b.add();
		b.bb();
	}

}
