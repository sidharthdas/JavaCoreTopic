package practice3.generic;

public class JsonResponse<T> {

	T t;
	String id;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
