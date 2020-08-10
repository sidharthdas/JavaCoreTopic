package practice.singleton;

class SingleTon{
	
	private static SingleTon singleTon;
	
	private SingleTon() {
		
	}
	
	public static SingleTon getInstance() {
		if(singleTon == null) {
			singleTon = new SingleTon();
		}
		
		return singleTon;
	}
}

public class SingletonMainClass {
	
	public static void main(String[] args) {
		
		
	}

}
