package practice3.wrapper;

public class MainClass {
	
	public static void main(String[] args) {
		
		
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		
		Integer i3 = 1;
		Integer i4 = 1;
		
		System.out.println("Comparision of Integer element with new keyword: "+ (i1 == i2));
		System.out.println("Comparision of Integer element without new keyword: "+ (i3 == i4));
		
	}

}
