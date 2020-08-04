package comparator;

public class User {

	private int id;
	private String name;
	private String email;
	private String address;
	private int mark;
	
	

	public User(int id, String name, String email, String address, int mark) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mark = mark;
	}
	
	

	public int getMark() {
		return mark;
	}



	public void setMark(int mark) {
		this.mark = mark;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", mark=" + mark
				+ "]";
	}
	
	

}
