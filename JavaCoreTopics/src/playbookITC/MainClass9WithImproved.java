package playbookITC;

/*9.	Find the second smallest on array
Example: {12, 13, 1, 10, 34, 1}
Output: 10
Time: 15 min*/

public class MainClass9WithImproved {

	public static void main(String[] args) {

		int[] arr = { 12, 13, 1, 10, 34, 1 };

		int smallest = 0;
		int secondSmallest = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				smallest = arr[i];
				secondSmallest = arr[i + 1];
			} else {
				if (smallest > arr[i]) {
					secondSmallest = smallest;
					smallest = arr[i];
				} else if (secondSmallest > arr[i] ) {
					secondSmallest = arr[i];
				}
			}
		}

		System.out.println(secondSmallest);
	}

}
