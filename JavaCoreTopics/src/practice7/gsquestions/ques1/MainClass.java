package practice7.gsquestions.ques1;

import java.util.HashMap;
import java.util.Map;

//Given a string, find its first non-repeating character
public class MainClass {

	public static void main(String[] args) {
		
		
		String s = "geeksforgezeks";
		
			Map<String, Integer> map = new HashMap<>();
		
		char[] arr = s.toCharArray();
		
		for(char c : arr) {
			
			if(map.containsKey(String.valueOf(c))) {
				map.put(String.valueOf(c), map.get(String.valueOf(c))+ 1);
			}else {
				map.put(String.valueOf(c), 1);
			}
		}
		
		
		
		for(char c : arr) {
			if(map.get(String.valueOf(c)) ==1) {
				System.out.println(c);
				break;
			}
		}
	}

}
