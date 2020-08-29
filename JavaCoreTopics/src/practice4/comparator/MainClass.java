package practice4.comparator;

import java.util.Comparator;

class Student {

	private int i;
	private String name;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class MainClass {

	public static void main(String[] args) {

		Comparator<Student> comp = (Student o1, Student o2) -> {
			if (o1.getI() > o2.getI()) {
				return 1;
			} else if (o1.getI() > o2.getI()) {
				return -1;
			} else {
				return 0;
			}
		};

	}

}
