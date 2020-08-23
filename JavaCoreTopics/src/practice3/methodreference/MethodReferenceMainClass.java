package practice3.methodreference;

interface Sayable{
	void say();
}

interface Textable{
	Message say();
}

class Message{
	
	public Message() {
		System.out.println("in message const");
	}
}

public class MethodReferenceMainClass {
	
	public static void main(String[] args) {
		Sayable sayable = MethodReferenceMainClass::hello;
		sayable.say();
		
		Sayable sayable1 = new MethodReferenceMainClass()::hello1;
		sayable1.say();
		
		Textable textable = Message::new;
		textable.say();
		
		
	}
	public static void hello() {
		System.out.println("hellow world");
	}
	
	
	public  void hello1() {
		System.out.println("hellow world");
	}
}
