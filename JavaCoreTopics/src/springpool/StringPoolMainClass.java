package springpool;

public class StringPoolMainClass {
	
	
	public static void main(String[] args) {
		
		
		String s1 = "Sidh";
		String s2 = "Sidh";
		
		s2 = "Ram";
		s1 = s2;
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s1 == s2);
	}

}
