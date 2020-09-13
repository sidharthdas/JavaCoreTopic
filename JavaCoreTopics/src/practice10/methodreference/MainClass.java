package practice10.methodreference;

interface Sayable {
	void say();
}

interface Messageable{
	Message mes();
}

class Message {

	public Message() {
		System.out.println("in message const");
	}
}

public class MainClass {

	public static void main(String[] args) {

		Sayable sayaable = MainClass::hello;
		sayaable.say();

		Sayable sayaable1 = new MainClass()::hey;
		sayaable1.say();
		
		Messageable m = Message::new;
		m.mes();

	}

	public static void hello() {
		System.out.println("hello");
	}

	public void hey() {
		System.out.println("hey");
	}

}
