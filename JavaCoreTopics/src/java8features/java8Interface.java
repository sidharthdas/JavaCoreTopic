package java8features;

public interface java8Interface {
	
	final static int i = 10;
	
	void add(int a, int b);
	
	default int sub(int a, int b) {
		return a-b;
	}
	
	static int mul(int a, int b) {
		return a*b;
	}
	
	default int mulCal(int a, int b) {
		int multi = mul(a, b);
		return multi;
	}

}
