package arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListMainClass {
	
	public static void main(String[] args) {
		
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
