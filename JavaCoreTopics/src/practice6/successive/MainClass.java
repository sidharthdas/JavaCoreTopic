package practice6.successive;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		int[] numArr = { 10, 40, 50,40, 30, 100, -10, 20 };

		List<List<Integer>> succ = new ArrayList<>();

		int num = 90;

		for (int i = 0; i < numArr.length; i++) {
			if (i != numArr.length - 1) {
				if (numArr[i] + numArr[i + 1] == num) {
					List<Integer> numList = new ArrayList<>();
					numList.add(numArr[i]);
					numList.add(numArr[i + 1]);
					succ.add(numList);
				}
			}
		}

		System.out.println(succ);
	}

}
