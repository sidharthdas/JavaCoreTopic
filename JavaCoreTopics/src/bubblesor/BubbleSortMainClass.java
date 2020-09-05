package bubblesor;

public class BubbleSortMainClass {
	
	
	public static void main(String[] args) {
		
		int arr[] = {0,9,8,7,6,5,4,3,2,1};
		

		for(int a : bubbleSort(arr)) {
			System.out.println(a +" ");
		}
		
	}
	
	
	public static int[] bubbleSort(int[] arr) {
		
		int n = arr.length;
		
		for(int i = 0; i < n-1; i++) {
			
			for(int j = 0; j < n-i-1; j++) {
				
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			
		}
		
		return arr;
	}

}
