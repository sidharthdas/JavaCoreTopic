package playbookITC;

/*8.	Dot Product of two array/matrix. Both array should be same in size
 * e.g:
	arr1 = {1,2}
	arr2 = {3,4}

 * */

public class MainClass8 {
	
	
	public static void main(String[] args) {
		
		
		int dotProduct = 0;
		
		int[] arr1 = {1,2};
		int[] arr2 = {3,4};
		
		if(arr1.length != arr2.length) {
			return;
		}
		
		for(int i= 0; i < arr1.length; i++) {
			
			dotProduct = dotProduct + (arr1[i] * arr2[i]);
		}
		
		
		System.out.println(dotProduct);
	}

}
