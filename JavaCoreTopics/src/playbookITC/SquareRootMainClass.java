package playbookITC;

public class SquareRootMainClass {
	
	public static void main(String[] args) {
		
		System.out.println(squareRoot(4));
		
	}
	
	public static double squareRoot(int data) {
		double temp;
		
		double sq = data /2;
		
		do {
			temp = sq;
			sq = (temp + (data/temp) )/ 2;
		}while((temp -sq) != 0);
		
		return sq;
	}

}
