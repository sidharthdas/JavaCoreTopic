package practice15.methodreference;

interface Sayable {
	int say();
}

interface MessageInter{
	Message mess();
}

class Message{
	
	public Message() {
		System.out.println("in mesage const");
	}
}

public class MethodReferenceMainClass {

	public static void main(String[] args) {
		
		//static method
		Sayable sayable = MethodReferenceMainClass::hello;
		sayable.say();
		
		//non-static method
		Sayable sayable1 = new MethodReferenceMainClass()::hello1;
		sayable1.say();
		
		//constructor
		MessageInter messageInter = Message::new;
		messageInter.mess();
	}

	public static int hello() {
		System.out.println("in hello method");
		return 1;
	}
	
	public  int hello1() {
		System.out.println("in hello method");
		return 1;
	}

}
