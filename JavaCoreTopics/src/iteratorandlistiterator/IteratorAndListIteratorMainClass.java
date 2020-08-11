package iteratorandlistiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorAndListIteratorMainClass {
	public static void main(String[] args) {
		
		
		List<String> names = new ArrayList<>();
		
		names.add("sid");
		names.add("sagar");
		names.add("sita");
		names.add("gita");
		names.add("ram");
		
		Iterator<String> it = names.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		ListIterator<String> listIt = names.listIterator();
		
		listIt.next();
		listIt.next();
		listIt.next();
		
		System.out.println(listIt.previous());
		
	}
}
