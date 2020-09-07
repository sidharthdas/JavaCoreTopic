package practice7.methodReference;

interface Sayable {
	void say();
}

interface Messageable {
	Message m();
}

class Message {

	public Message() {
		System.out.println("in const");
	}
}

public class MainClass {

	public static void main(String[] args) {
		
		Sayable sayable = MainClass::hello;
		sayable.say();

		Sayable sayable1 = new MainClass()::hello2;
		sayable1.say();
		
		Messageable messageable = Message::new;
		messageable.m();
		
	}

	public static void hello() {
		System.out.println("hello");
	}

	public void hello2() {
		System.out.println("hello 2");
	}

}
