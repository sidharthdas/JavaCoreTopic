package javadatetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class MainClass {
	
	public static void main(String[] args) {
		
		
		long milliseconds = 1597429800000l;
		LocalDate date =
		    Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDate();
		
		date.plusDays(2);
		
		System.out.println(date);
		
		LocalDate date1 = date.plusDays(2);
		
		System.out.println(date1);
	}

}
