package codingquestion;

public class FindIndexOfElementInArr {
	
	public static void main(String[] args) {
		
		
		int arr[] = {3,4,2,6,4,9,1,0};
		
		int num = 3;
		
		int index = -1;
		int i = 0;
		while(i < arr.length) {
			
			if(arr[i] == num) {
				index = i;
				break;
			}else {
				i++;
			}
			
		}
		
		System.out.println(index);
		
	}

}
