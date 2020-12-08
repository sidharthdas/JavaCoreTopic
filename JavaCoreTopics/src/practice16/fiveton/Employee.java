package practice16.fiveton;

public class Employee {
	
	private static final Employee instances[] = new Employee[5];
	private static int index= 0;
	
	private Employee(){
		
	}
	
	public static Employee getInstance() {
		if(instances[index] ==null) {
			instances[index] = new Employee();
		}
		
		Employee instance = instances[index];
		index = (index+1) % instances.length;
		System.out.println(index);
		return instance;
	}

}
