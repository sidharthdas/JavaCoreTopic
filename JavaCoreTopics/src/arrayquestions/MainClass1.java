package arrayquestions;

//How do you find the missing number in a given integer array of 1 to 100?
public class MainClass1 {
	
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6,7,8,10};
		
		System.out.println(missingNum(arr));
		
	}
	
	public static int missingNum(int[] arr) {
		int totalSum = 0;
		int givenArrSum = 0;
		for(int i = 1; i < 11; i++) {
			totalSum = totalSum + i;
		}
		
		for(int i = 0; i < arr.length; i++) {
			givenArrSum = givenArrSum + arr[i];
		}
		
		return totalSum - givenArrSum;
		
		
	}

}
