package codingquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PAnagramList {

	public static void main(String[] args) {

		// System.out.println((int) sqRoot(9));

		// "ball", "allb", "llab", "cook", "fox", "ookc"
		// [[aks, kas, sak], [ rom ,mor], [java,ajav],[ Krish ]]

		String[] strArr = { "aks", "rom", "kas", "Krish", "sak", "java", "mor", "ajav" };

		Set<Integer> indexes = new HashSet<>();
		List<List<String>> mainList = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {
			List<String> ana = new ArrayList<>();
			ana.add(strArr[i]);
			if (!indexes.contains(i)) {
				for (int j = 0; j < strArr.length; j++) {
					if (i != j) {
						if (!indexes.contains(j)) {
							indexes.add(i);
							if (checkAnagram(strArr[i], strArr[j])) {
								ana.add(strArr[j]);
								indexes.add(j);
							}
						}
					}
				}
				mainList.add(ana);
			}
		}
		
		System.out.println(mainList);
		
		

	}

	public static boolean checkAnagram(String s1, String s2) {

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		if (c1.length != c2.length) {
			return false;
		}
		Arrays.sort(c1);
		Arrays.sort(c2);
		return (String.valueOf(c1).equals(String.valueOf(c2))) ? true : false;
	}

	public static double sqRoot(int number) {

		double temp;

		double sq = number / 2;

		do {
			temp = sq;
			sq = (temp + (number / temp)) / 2;

		} while ((temp - sq) != 0);

		return sq;
	}
}
