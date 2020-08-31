package practice5.methodref;

interface Sayable{
	void say();
}

interface Messagable{
	Message mess();
}


class Message{
	
	public Message() {
		System.out.println("in message const");
	}
}

public class MainClass {
	
	public static void main(String[] args) {
		
		Sayable sayable = MainClass::hey;
		sayable.say();
		
		Sayable sayable1 = new MainClass()::hello;
		sayable1.say();
		
		Messagable messagable = Message::new;
		messagable.mess();
		
		
		
	}
	
	public static void hey() {
		System.out.println("in hey");
	}
	public  void hello() {
		System.out.println("in hello");
	}
}
