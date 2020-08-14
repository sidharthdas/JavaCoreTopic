package generics;

public class MyGeneric<T> {
	
	T obj;
	
	void display(T t) {
		this.obj = t;
	}
	
	T get() {
		return obj;
	}

}
