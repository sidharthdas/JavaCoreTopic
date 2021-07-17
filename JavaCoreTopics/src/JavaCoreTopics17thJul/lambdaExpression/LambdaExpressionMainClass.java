package JavaCoreTopics17thJul.lambdaExpression;

interface Calc{
	
	int add(int a, int b);
}

public class LambdaExpressionMainClass {
	
	public static void main(String[] args) {
		
		Calc calc = ( int a, int b) -> {
			return a+b;
		};
		
		System.out.println(calc.add(10, 20));
		
		
		
	}

}
