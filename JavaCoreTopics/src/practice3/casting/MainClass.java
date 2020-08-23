package practice3.casting;

import java.io.FileNotFoundException;

class A{
	
	public void a1() {
		System.out.println("In a1 method of A class");
	}
	
	public void a2() {
		System.out.println("In a1 method of A class");
	}
}

class B extends A
{
	
	public void b1() {
		System.out.println("in b1 method of B class");
	}
	
	@Override
	public void a1(){
		System.out.println("a1 method is override in B class");
	}
}
public class MainClass {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//upcasting 
		System.out.println("upcasting in java ");
		A a = new B();
		a.a1();
		a.a2();
		
		//downcasting 
		System.out.println("downcasting in java ");
		A a1 = new B();
		B b = (B) a1;
		b.a1();
		b.a2();
	}

}
