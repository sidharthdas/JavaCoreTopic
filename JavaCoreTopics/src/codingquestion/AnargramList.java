package codingquestion;

import java.util.Arrays;



import java.util.*;

public class AnargramList {
	
	public static void main(String[] args) {
	
		
		Set<String > s=new HashSet<>();
		
		String arr[]= {"ball","allb","cook","fox","ookc"};
		
		
		for(int i=0;i<arr.length;i++) {
			for(int  j=0;j<arr.length;j++){
				if(i!=j) {
				boolean b=	checkAnargram(arr[i],arr[j]);
				if(b) {
					s.add(arr[i]);
					s.add(arr[j]);
					
				}
				}
			}
		}
		System.out.println(s);
	}

	
	static boolean checkAnargram(String s1,String s2){
		
		
	char c1[]=	s1.toCharArray();
	char c2[]=	s2.toCharArray();
	
	Arrays.sort(c1);
	Arrays.sort(c2);
	if(String.valueOf(c1).equals(String.valueOf(c2))) {
		return true;
	}

		
		return false;
		
	}
}
