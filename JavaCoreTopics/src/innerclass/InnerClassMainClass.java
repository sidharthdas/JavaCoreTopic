package innerclass;

public class InnerClassMainClass {
	
	
	static class Inner{
		
		public void add(int a, int b) {
			System.out.println(a+b);
		}
	}
	
	public static void main(String[] args) {
		
		InnerClassMainClass.Inner inner = new InnerClassMainClass.Inner();
		
		inner.add(10, 20);
		
		Inner i = new Inner();
		i.add(20, 50);
	}

}
