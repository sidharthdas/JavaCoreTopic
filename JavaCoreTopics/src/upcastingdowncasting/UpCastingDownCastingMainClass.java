package upcastingdowncasting;

public class UpCastingDownCastingMainClass {
	
	
	public static void main(String[] args) {
		
		//Up-casting example
		System.out.println("Up-casting example. . . .");
		Animal animal = new Dog();
		
		animal.eat();
		animal.shoutAminal();
		
		System.out.println("-----------------------------");
		//Down-casting example
		System.out.println("Down-casting example. . . .");
		Animal animal1 = new Dog();
		Dog dog = (Dog) animal1;
		
		dog.barke();
		dog.eat();
		dog.shoutAminal();
		
		
	}

}
