package practice16.methodreference;

interface Sayable{
	void say();
}

interface Messagem{
	Message mes();
}

class Message{
	public Message() {
		System.out.println("in const");
	}
}

public class MainClass {
	
	public static void main(String[] args) {
		
		Sayable say = MainClass::hey;
		say.say();
		
		Sayable say1 =new  MainClass()::hey1;
		say1.say();
		
		Messagem mm = Message::new;
		mm.mes();
		
		
	}
	
	public static void hey() {
		System.out.println("in static");
	}
	
	public  void hey1() {
		System.out.println("in non-static");
	}

}
