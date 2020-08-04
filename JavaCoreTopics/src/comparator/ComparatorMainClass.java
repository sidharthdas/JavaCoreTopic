package comparator;

public class ComparatorMainClass {
	
	public static void main(String[] args) {
		
		User u1 = new User(1, "Sidharth", "test1@gmail.com", "odisha");
		User u2 = new User(2, "Sidharth1", "test12@gmail.com", "pune");
		
		UserNameComparator u = new UserNameComparator();
		int i = u.compare(u1, u2);
		
		if(i == 0) {
			System.out.println("Both objects are same");
		} else {
			System.out.println("Both object are different");
		}
		
	}

}
