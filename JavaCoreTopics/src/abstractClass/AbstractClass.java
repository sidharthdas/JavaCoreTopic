package abstractClass;

public abstract class AbstractClass {

	private int i; //variable

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public AbstractClass(int i) {
		this.i = i;
	}
	
	
	abstract void add();
	
	public void sub() {
		System.out.println("in sub method");
	}

}
