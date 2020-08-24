package java8features;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

interface Sayable {

	void say();
}

interface Mess {

	Message m1();
}

class Message {

	public Message() {
		System.out.println("in message const");
	}
}

public class MethodReferenceMainClass {

	public static void main(String[] args) {

		// Method Reference
		// 1. Method Reference to static method
		// 2. method reference to non-static method
		// 3. Method reference to constructor

		// 1. Method Reference to static method
		Sayable sayabale = MethodReferenceMainClass::hello;
		sayabale.say();

		// 2. method reference to non-static method
		Sayable sayabale1 = new MethodReferenceMainClass()::hello1;
		sayabale1.say();

		// 3. Method reference to constructor
		Mess mess = Message::new;
		mess.m1();
		
		System.out.println("-------------------------------------------------");

		Map<String, Integer> map = new HashMap<>();
		map.put("Anjali", 20);
		map.put("Sidharth", 300);
		map.put("Gita", 100);
		map.put("sita", 10);
		map.put("tita", 1000);
		map.put("rita", 105);
		
		
		
		Map<String, Integer> newMap = map.entrySet().stream().filter(x -> x.getValue() > 100)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(newMap);

	}

	public static void hello() {
		System.out.println("Hello world");
	}

	public void hello1() {
		System.out.println("Hello world -- non-static");
	}

}
