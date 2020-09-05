package arrayquestions;


//How do you find the largest and smallest number in an unsorted integer array?
public class MainClass3 {
	
	
	public static void main(String[] args) {
		
		
		int arr[] = {1,8,2,7,4,9,2,9,0,11,-1,-55};
		
		int largest = 0;
		int smallest = 0;
		
		
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				largest = arr[i];
				smallest = arr[i];
			}else {
				if(arr[i] > largest) {
					largest = arr[i];
				}else if(arr[i] < smallest) {
					smallest = arr[i];
				}
			}
		}
		
		
		System.out.println("largest : "+largest);
		System.out.println("smallest : "+smallest);
	}

}
