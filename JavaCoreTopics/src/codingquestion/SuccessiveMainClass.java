package codingquestion;

public class SuccessiveMainClass {

	public static void main(String[] args) {

		int[] intArr = { 1, 5, 3, 6, 4, 8, 1 , 8};

		int j = 9;
		
		System.out.println(intArr);

		for (int i = 0; i < intArr.length; i++) {
			if (i < intArr.length - 1) {
				if (intArr[i] + intArr[i + 1] == j) {
					System.out.println(intArr[i]);
					System.out.println(intArr[i + 1]);
				}
			}

		}
	}

}
