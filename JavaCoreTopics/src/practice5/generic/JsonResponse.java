package practice5.generic;

public class JsonResponse<T> {
	
	private T t;
	private String name;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "JsonResponse [t=" + t + ", name=" + name + "]";
	}
	
	

}
