package practice.annagramlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnnagramList {

	public static void main(String[] args) {

		// "ball", "allb", "llab", "cook", "fox", "ookc"
		// [[aks, kas, sak], [ rom ,mor], [java,ajav],[ Krish ]]

		String[] strArr = { "aks", "rom", "kas", "Krish", "sak", "java", "mor", "ajav" };
		Set<Integer> indexes = new HashSet<>();

		List<List<String>> s = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {
			List<String> ana = new ArrayList<>();
			ana.add(strArr[i]);
			if (!indexes.contains(i)) {
				for (int j = 0; j < strArr.length; j++) {
					if (i != j) {
						if (!indexes.contains(j)) {
							indexes.add(i);
							boolean anagram = isAnagram(strArr[i], strArr[j]);

							if (anagram) {
								ana.add(strArr[j]);
								indexes.add(j);
							}
						}
					}
				}
				s.add(ana);
			}
		}
		System.out.println(s);

	}

	public static boolean isAnagram(String s1, String s2) {

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);

		if (String.valueOf(c1).equals(String.valueOf(c2))) {
			return true;
		}

		return false;
	}

}
