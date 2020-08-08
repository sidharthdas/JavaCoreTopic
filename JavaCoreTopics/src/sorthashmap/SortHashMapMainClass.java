package sorthashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortHashMapMainClass {
	
	
	public static void main(String[] args) {
		
		
		List<String> names = new ArrayList<>();
		
		/*
		 * names.add("Sidharth"); names.add("Sagar"); names.add("Sagarika");
		 * names.add("Tripsy"); names.add("Ram");
		 * 
		 * Collections.sort(names);
		 * 
		 * System.out.println(names);
		 */
		
		
		
		
		  Map<String, Integer> nameAndSalary = new HashMap<>();
		  
		  nameAndSalary.put("Sidharth", 1000); nameAndSalary.put("Sagar", 110);
		  nameAndSalary.put("raj", 2310); nameAndSalary.put("rohit", 2150);
		  nameAndSalary.put("sita", 2170);
		  
		  System.out.println(nameAndSalary);
		  
		  Map<String, Integer> nameAndSalary1 = new TreeMap<>(nameAndSalary);
		  System.out.println(nameAndSalary1);
		 
		
	}

}
