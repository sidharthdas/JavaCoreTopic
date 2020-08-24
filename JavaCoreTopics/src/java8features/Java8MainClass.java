package java8features;

public class Java8MainClass {
	
	public static void main(String[] args) {
		
		Java8Class mainClass = new Java8Class();
		
		mainClass.add(10, 20);
		System.out.println(mainClass.sub(10, 20));
		System.out.println(mainClass.mulCal(10, 20));
	}

}
