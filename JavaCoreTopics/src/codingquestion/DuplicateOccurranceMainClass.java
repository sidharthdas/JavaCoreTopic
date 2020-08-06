package codingquestion;

import java.util.HashMap;
import java.util.Map;

public class DuplicateOccurranceMainClass {
	
	
	public static void main(String[] args) {
		
		String str = "I am am loving to learn java java my fav language is is";
		
		String[] strArray = str.split(" ");
		
		Map<String, Integer> words = new HashMap<>();
		
		for(String s : strArray) {
			if(words.containsKey(s)) {
				words.put(s, words.get(s) + 1);
			}else {
				words.put(s, 1);
			}
		}
		
		System.out.println(words);
		
		
		
	}

}
