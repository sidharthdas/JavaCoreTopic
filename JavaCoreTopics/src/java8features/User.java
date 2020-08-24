package java8features;

public class User {

	private int id;
	private String userName;
	private String userAdd;
	private int salary;
	private int age;
	
	
	public User() {
		
	}
	
	

	public User(int id, String userName, String userAdd, int salary, int age) {
		this.id = id;
		this.userName = userName;
		this.userAdd = userAdd;
		this.salary = salary;
		this.age = age;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userAdd=" + userAdd + ", salary=" + salary + ", age="
				+ age + "]";
	}
	
	
}
