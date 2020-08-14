package generics;

public class JsonResponse<T> {

	private int id;
	private String baseDTOName;

	T objT;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaseDTOName() {
		return baseDTOName;
	}

	public void setBaseDTOName(String baseDTOName) {
		this.baseDTOName = baseDTOName;
	}

	public T getObjT() {
		return objT;
	}

	public void setObjT(T objT) {
		this.objT = objT;
	}

	@Override
	public String toString() {
		return "JsonResponse [id=" + id + ", baseDTOName=" + baseDTOName + ", objT=" + objT + "]";
	}
	
	

}
