package arrayquestions;

public class MainClass {
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {1,2,3,6,5,7,8};
		
		String s = "";
		
		//s.valueOf
		
		int[] arr1 = new int[arr.length-1];
		int j= 0;
		
		int size = arr.length;
		for(int i = 0; i < size; i ++) {
			if(arr[i] == 3) {
				
			}else {
				arr1[j] = arr[i];
				j++;
			}
		}
		
		for(int a : arr1) {
			System.out.print(a+ " ");
		}
	}

}
