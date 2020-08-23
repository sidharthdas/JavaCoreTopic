package practice3.fiveton;

public class FivetonClass {
	
	private static final FivetonClass[] instances = new FivetonClass[5];
	private static int index = 0;
	
	private FivetonClass() {
		
	}
	
	public static FivetonClass getInstance() {
		if(instances[index] == null) {
			instances[index] = new FivetonClass();
		}
		FivetonClass instance = instances[index];
		index = (index + 1) % instances.length;
		System.out.println(index);
		return instance;
		
	}
	
	

}
