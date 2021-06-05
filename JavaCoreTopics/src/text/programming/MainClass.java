/**
 * 
 */
package text.programming;

import java.util.Arrays;
import java.util.List;

/**
 * @author sidharthdas
 *
 */
public class MainClass {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		int s = 1*1 + 3*3 + 5*5 + 7*7 +9*9 ;
		System.out.println("S: "+s);
		
		
		int totalSum = list.stream().filter(x -> x%2 !=0).mapToInt(x-> x*x).sum();
		System.out.println("totalsum: "+totalSum);
		
	}

}
