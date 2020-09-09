package playbookITC;

import java.util.HashMap;
import java.util.Map;

/*1.	Find the first non-repeating character in string
Example: racecar 
Output: e
Time: 15 min*/


public class MainClass1 {
	
	public static void main(String[] args) {
		
		
		String s1 = "racecar";
		
		Map<String, Integer> map = new HashMap<>();
		
		String[] sArr = s1.split("");
		
		for(String s : sArr) {
			
			if(map.containsKey(s)) {
				map.put(s, map.get(s) +1);
			}else {
				map.put(s, 1);
			}
		}
		
		for(String s : sArr) {
			if(map.get(s) == 1) {
				System.out.println(s);
				break;
			}
		}
	}

}
