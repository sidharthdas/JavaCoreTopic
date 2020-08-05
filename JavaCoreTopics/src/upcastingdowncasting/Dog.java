package upcastingdowncasting;

public class Dog extends Animal{
	
	@Override
	public void eat() {
		
		System.out.println("In eat method of dog class");
		
	}
	
	public void barke() {
		System.out.println("In barke method of dog class");
	}

}
