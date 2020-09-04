package practice.annagramlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AnnagramList {

	public static void main(String[] args) {

		String[] strArr = { "ball", "allb","llab", "cook", "fox", "ookc" };

		Set<String> s = new HashSet<>();

		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr.length; j++) {
				if (i != j) {
					boolean anagram = isAnagram(strArr[i], strArr[j]);
					if (anagram) {
						s.add(strArr[i]);
						s.add(strArr[j]);
					}
				}
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
