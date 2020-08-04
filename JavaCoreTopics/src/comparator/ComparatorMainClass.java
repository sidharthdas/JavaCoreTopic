package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMainClass {
	
	public static void main(String[] args) {
		
		
		//Comparing using comparator interface
		
		User u1 = new User(1, "Sidharth", "test1@gmail.com", "odisha", 10);
		User u2 = new User(2, "Sidharth1", "test12@gmail.com", "pune", 20);
		
		UserNameComparator u = new UserNameComparator();
		int i = u.compare(u1, u2);
		
		if(i == 0) {
			System.out.println("Both objects are same");
		} else {
			System.out.println("Both object are different");
		}
		
		//Sorting the User object using comparator interface and lambda expression
		
		List<User> allUsers = new ArrayList<>();
		allUsers.add(new User(1, "Sidharth", "test1@gmail.com", "odisha", 20));
		allUsers.add(new User(2, "Ram", "test1@gmail.com", "odisha", 30));
		allUsers.add(new User(3, "sita", "test1@gmail.com", "odisha", 40));
		allUsers.add(new User(4, "gita", "test1@gmail.com", "odisha", 210));
		allUsers.add(new User(5, "laxman", "test1@gmail.com", "odisha", 120));
		allUsers.add(new User(6, "raju", "test1@gmail.com", "odisha", 200));
		allUsers.add(new User(7, "karan", "test1@gmail.com", "odisha", 2000));
		allUsers.add(new User(8, "dev", "test1@gmail.com", "odisha", 1120));
		
		
		//Used lambda expression in Comparator method
		
		Comparator<User> comp = (User o1, User o2)-> {
			if(o1.getMark() > o2.getMark()) {
				return 1;
			}else if(o1.getMark() < o2.getMark()) {
				return -1;
			}else
				return 0;
		};
		
		Collections.sort(allUsers, comp);
		System.out.println(allUsers);

		
		
	}

}
