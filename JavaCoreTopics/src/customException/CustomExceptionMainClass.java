package customException;

public class CustomExceptionMainClass {
	
	public static void main(String[] args) {
		
		
		try {
			System.out.println(CustomExceptionMainClass.div(10, 0));
		} catch (FiestElementCantBeZeroException | DividedByZeroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorMessage());
		}
		
		
		System.out.println("Code executed successfully. . . ");
		
		
		
	}
	
	public static int div(int a, int b) throws FiestElementCantBeZeroException, DividedByZeroException {
		if(a == 0) {
			throw new FiestElementCantBeZeroException(66001, "A cant be zero");
		}
		if(b == 0) {
			throw new DividedByZeroException(66002, "Divided by zero exception");
		}
		
		return a/b;
	}

}
