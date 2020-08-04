package comparator;

import java.util.Comparator;

public class UserNameComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		if(o1.getName().equals(o2.getName())) {
			return 0;
		}
		return -1;
	}

}
