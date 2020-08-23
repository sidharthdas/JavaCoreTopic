package practice3.singleton1;

public class SingletonMainClass {
	
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance().hashCode());
		System.out.println(Singleton.getInstance().hashCode());
		System.out.println(Singleton.getInstance().hashCode());
		System.out.println(Singleton.getInstance().hashCode());
		
	}

}
