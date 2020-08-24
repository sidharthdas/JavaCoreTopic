package java8features;

import java.time.LocalDateTime;

public class LocalDateTimeMainClass {
	
	public static void main(String[] args) {
		
		
		LocalDateTime local = LocalDateTime.now();
		System.out.println(local.plusDays(6));
	}

}
