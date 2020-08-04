package abstractClass;

public class AbstractClassMain {
	
	public static void main(String[] args) {
		
		AbstractClass m = new AbstractClass(10) {
			
			@Override
			void add() {
				// TODO Auto-generated method stub
				
			}
		};
		
		TestClass c = new TestClass(10);
		
		c.add();
		c.sub();
	}

}
