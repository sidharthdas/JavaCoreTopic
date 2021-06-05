/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sidharthdas
 *
 */
public class MainClass {
	
	public static void main(String[] args) {
		
		int[] nums = {1,1,2};
		Set<Integer> s = new HashSet<>();
        for(int i : nums){
            s.add(i);
        }
       
       int size = s.size();
       
       int num[] = new int[size];
       
       int count =0;
       for(int i : s){
           num[count] = i;
           count++;
       }
       nums = num;
       
       for(int i : nums){
           System.out.println(i);
       }
       
	}

}
