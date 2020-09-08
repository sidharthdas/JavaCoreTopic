package thisAndSuper;


class Student{
	//instance variable
	int a = 10;
	
	//static variable
	static int b = 20;
}

public class MainClass extends Student{
	
	int a = 90;
	
	static int b = 200; 
	
	void rr() {
		
		System.out.println("Refering to super class ");
		//refer  to instance variable of super class
		System.out.println(super.a);
		
		//refer to static variable of super class
		System.out.println(super.b);
		
		System.out.println("Refering to child class ");
		
		System.out.println(this.a);
		System.out.println(this.b);
		
		
	}
	
	public static void main(String[] args) {
		
		
		new MainClass().rr();
	}

}
