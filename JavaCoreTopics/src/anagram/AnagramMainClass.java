package anagram;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramMainClass {
	
	public static void main(String[] args) {
		
		boolean isAnagram = true;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first word: ");
		String word1 = sc.nextLine();
		
		System.out.println("Enter second word: ");
		String word2 = sc.nextLine();
		
		char[] word1arr = word1.toCharArray();
		char[] word2arr = word2.toCharArray();
		
		Arrays.sort(word1arr);
		Arrays.sort(word2arr);
		
		if(word1arr.length != word2arr.length) {
			isAnagram = false;
			
		}else {
			for(int i = 0; i < word1arr.length; i++) {
				System.out.println("char at index "+i+" word1arr: "+word1arr[i]+" and word2arr: "+word2arr[i]);
				if(word1arr[i] != word2arr[i]) {
					isAnagram = false;
				}
				
			}
		}
		
		
		System.out.println(isAnagram);
		
	}

}
