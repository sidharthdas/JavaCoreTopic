package playbookITC.stringrotationalornot;

//A Program to check if strings are rotations of each other or not

public class MainClass {

	public static void main(String[] args) {

		System.out.println(checkRotation("ABCD", "ACBD"));

	}

	public static boolean checkRotation(String s1, String s2) {
		return (s1.length() == s2.length() && (s1 + s2).indexOf(s2) != -1);
	}

}
