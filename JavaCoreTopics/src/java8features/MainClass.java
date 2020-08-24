package java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java8features.functionalinterface.Sayable;

public class MainClass {
	
	//Lambda Expression
	//FunctionalInterface
	//Method Reference
	//StreamAPI
	//ReflectionAPI
	//LocalDateTime
	//static and default method in Interface
	
	public static void main(String[] args) {
		
		System.out.println("Lambda Expression: ");
		
		System.out.println("----------------------------------------------");
		//Lambda Expression
		Sayable sayable = (int x, String y) -> {
		System.out.println("x value is : "+x+" and y value is : "+y);
		};
		
		sayable.say(10, "Anjali");
		
		
		
		System.out.println("----------------------------------------------");
		
		
		List<User> allUsers = Arrays.asList(new User(1, "Anjali", "ranchi", 10000, 25),
				new User(2, "Raj", "ranc", 50000, 51),
				new User(3, "Sita", "rachi", 23000, 22),
				new User(4, "gita", "ri", 90000, 30),
				new User(5, "ram", "r", 5000, 20));
		
		
		Collections.sort(allUsers, new SalarySort());
		
		System.out.println(allUsers);
		
		
		System.out.println("----------------------------------------------");
		
		Comparator<User> comp = (User o1, User o2)->{
			if(o1.getAge()>o2.getAge()) {
				return 1;
				
			}else if(o1.getAge()<o2.getAge()) {
				return -1;
				
			}else
				return 0;
			
		};
		
		Collections.sort(allUsers, comp);
		
		System.out.println(allUsers);
		
		
		
		
		System.out.println("----------------------------------------------");
		
		
		Runnable r = ()->{
		System.out.println("in run method of runnable");	
		};
		
		Thread t = new Thread(r);
		t.start();
		
		
		System.out.println("----------------------------------------------");
		
		
		
		
	}

}
