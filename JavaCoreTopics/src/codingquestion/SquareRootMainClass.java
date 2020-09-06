package codingquestion;

public class SquareRootMainClass {
	
	public static double squareRoot(int number) {
		double temp;

		double sr = number / 2;

		do {
			temp = sr;
			sr = (temp + (number / temp)) / 2;
		} while ((temp - sr) != 0);

		return sr;
	    }

	public static void main(String[] args) {
		
		
		System.out.println(squareRoot(9));
	}

}
