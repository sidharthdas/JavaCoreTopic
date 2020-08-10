package practice.methodrefernce;

interface Sayable{
	
	void say();
}


class Message{
	
	public Message() {
		System.out.println("in message class constructor");
	}
}

interface Messagable{
	Message mes();
}

public class MethodReferenceMainClass {
	
	public static void main(String[] args) {
		Sayable saya = MethodReferenceMainClass::hello;
		saya.say();
		
		
		Sayable saya1 = new MethodReferenceMainClass()::hey;
		saya1.say();
		
		
		Messagable messagable  = Message::new;
		messagable.mes();
	}
	
	
	
	public static void hello() {
		System.out.println("Hello");
	}
	
	public void hey() {
		System.out.println("hey");
	}

}


