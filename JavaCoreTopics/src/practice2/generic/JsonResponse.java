package practice2.generic;

public class JsonResponse<T> {

	private T t;

	private int id;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
