package practice5.immutable;

public final class Student {

	private final String name;
	private final String add;

	public Student(String name, String add) {
		this.name = name;
		this.add = add;
	}

	public String getName() {
		return name;
	}

	public String getAdd() {
		return add;
	}

}
