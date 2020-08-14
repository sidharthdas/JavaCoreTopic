package codingquestion;

class Message{
	Message(){
		System.out.println("in Message const");
	}
}

interface Sayable{
	
	void say(int i, int j);
	
}

interface Sayable1{
	
	void say();
	
}

interface Messageable{
	
	Message m();
	
}

public class MethodReferenceMain {
	
	public static void main(String[] args) {
		
		
		//Method Reference to static method
		Sayable sayable = MethodReferenceMain::hello;
		sayable.say(10, 20);
		
		
		//Method reference to non-static method
		Sayable1 sayable1 = new MethodReferenceMain()::hey;
		sayable1.say();
		
		
		//Method reference to Constructor
		Messageable messageable = Message::new;
		messageable.m();
		
		
		
		
		
		
		
		
		
	}
	
	public static void hello(int i, int j) {
		System.out.println("hello"+ i + j);
	}
	
	public void hey() {
		System.out.println("Hey world");
	}

}
