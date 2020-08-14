package overriding;

public class ChildEmployee extends Employee {

	private int childId;
	private int childName;

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public int getChildName() {
		return childName;
	}

	public void setChildName(int childName) {
		this.childName = childName;
	}

}
