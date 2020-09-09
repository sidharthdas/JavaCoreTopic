package practice7.gsquestions.ques5;

public class MainClass {
	
	
	public static void main(String[] args) {
		
		System.out.println(squreRoot(9));
		
	}
	
	
	
	public static double squreRoot(int a) {
		double temp ;
		
		double sr = a /2;
		
		do {
			temp = sr;
			
			sr = (temp +(a/temp)) /2;
		}while((temp -sr)!= 0);
		
		return sr;
	}

}
