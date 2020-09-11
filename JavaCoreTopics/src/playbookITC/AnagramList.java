package playbookITC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnagramList {

	public static void main(String[] args) {
		
		String[] strArr = { "aks", "rom", "kas", "Krish", "sak", "java", "mor", "ajav" };
		
		List<List<String>> mainList = new ArrayList<>();
		Set<Integer> indexes = new HashSet<>();
		
		
		for(int i = 0; i < strArr.length; i++) {
			List<String> ana = new ArrayList<>();
			ana.add(strArr[i]);
			if(!indexes.contains(i)) {
				for(int j = 0; j < strArr.length; j++) {
					if(i != j) {
						if(!indexes.contains(j)) {
							indexes.add(i);	
							
							boolean isAna = checkAnagram(strArr[i], strArr[j]);
							if(isAna) {
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

		if (s1.length() != s2.length()) {
			return false;
		}

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);

		return String.valueOf(c1).equals(String.valueOf(c2)) ? true : false;
	}

}
