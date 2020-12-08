package abstractClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test123 {

	public static void main(String args[]) {
		String s1 = "";
		String aa = "FATOil FIBERSpinach CARBRice FATCheese FIBERBeans FATOlive CARBPotato FIBERBroccoli FIBERBanana";
		
		String aaa[] = aa.split(" ");
		List<String> list = new CopyOnWriteArrayList<>();
		
		for(String s6: aaa) {
			list.add(s6);
		}
		int numberOfDays = 9;

		int count = 0;
		int fatCount = 0;
		int carbCount = 0;
		List<String> list11 = new ArrayList<>();
		while (count != numberOfDays) {

			for (String s11 : list) {
				list11.add(s11);
				if (count < 3) {
					s1 = s1.concat("-");
				} else {
					list11.add(s11);
					for (String s : list11) {
						if (s.contains("FAT")) {
							fatCount += 1;
						} else if (s.contains("CARB")) {
							carbCount += 1;
						}
					}

					if (carbCount == 0 && fatCount >= 2) {
						s1 = s1.concat("X");
						fatCount = fatCount - 2;

					} else if (carbCount >= 1 && fatCount == 0) {
						s1 = s1.concat("Y");
						carbCount = carbCount - 1;
					} else {
						s1 = s1.concat("-");
					}
				}
				
				count +=1;
			}
		}

		System.out.println(s1);

	}

}
