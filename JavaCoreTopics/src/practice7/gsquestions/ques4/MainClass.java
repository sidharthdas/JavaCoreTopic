package practice7.gsquestions.ques4;
//Swap the first and last character of a string in Java
public class MainClass {
	
	
	public static void main(String[] args) {
		
		
		String s = "Sidharth";
		
		char[] sArr = s.toCharArray();
		
		char temp = sArr[sArr.length -1];
		sArr[sArr.length -1] = sArr[0];
		sArr[0] = temp;
		
		
		
		System.out.println(String.valueOf(sArr));
		System.out.println(s.contains("sid"));
	}

}
