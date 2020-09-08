package practice7.gsquestions.ques3;

//Reverse words in a given string
public class MainClass {

	public static void main(String[] args) {

		String s = "getting good at coding needs a lot of practice";

		String[] sArr = s.split(" ");

		for (int i = sArr.length - 1; i >= 0; i--) {
			System.out.print(sArr[i]+" ");
		}
	}

}
