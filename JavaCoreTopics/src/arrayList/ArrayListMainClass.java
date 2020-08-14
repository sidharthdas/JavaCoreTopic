package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListMainClass {
	
	public static void main(String[] args) {
		
		
		//Declaring and initialising arrayList
		
		List<String> nameArrayList = Arrays.asList("Sid","SAGAR","Rakesh","Ram");
		List<Integer> numArrayList = Arrays.asList(1,2,3,4,5,6);
		
		
		List<String> arr = new CopyOnWriteArrayList<>();
		arr.add("sid");
		arr.add("sagar");
		arr.add("sita");
		arr.add("ram");
		arr.add("raju");
		
		System.out.println(arr);
		
		Iterator<String> it = arr.iterator();
		
		while(it.hasNext()) {
			if(it.next().equals("sid")) {
				//arr.remove());
				break;
			}				
		}
		
		System.out.println(arr);
		
	}
	


}
