package practice15.immutable;

public final class Test {

	private final int i;
	private final String name;

	private Test(int i, String name) {
		super();
		this.i = i;
		this.name = name;
	}

	public int getI() {
		return i;
	}

	public String getName() {
		return name;
	}

}
