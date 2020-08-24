package java8features;

import java.util.Comparator;

public class SalarySort implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		if (o1.getSalary() > o2.getSalary()) {
			return 1;
		} else if (o1.getSalary() < o2.getSalary()) {
			return -1;
		}
		return 0;
	}

}
