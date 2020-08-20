package override;

public class OverrideMainClass {
	public static void main(String[] args) {

		
		//UpCasting
		A a = new B(1);
		a.test();
		//a.test3();
		a.test1();
		
		
		System.out.println("----downcasting");
		//DownCasting
		A a1 = new B(3);
		B b = (B) a1;
		
		b.test();
		b.test1();
		b.test3();
		

	}

}
