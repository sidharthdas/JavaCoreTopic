package practice10.interfacejava8;

public interface Java8 {

	void add();

	default void sub() {
		System.out.println("in sub");
	}

	static void mul() {
		System.out.println("in mul");
	}

}
