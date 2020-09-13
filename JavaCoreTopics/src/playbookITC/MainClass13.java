package playbookITC;

/*13.	Reverse words in a given string
Example: "getting good at coding needs a lot of practice"
Output: "practice of lot a needs coding at good getting"
Time: 30 min
*/

public class MainClass13 {
	
	public static void main(String[] args) {
		
		String s = "getting good at coding needs a lot of practice";
		
		String[] srr = s.split(" ");
		
		for(int i = srr.length-1; i>=0; i-- ) {
			System.out.print(srr[i]+" ");
		}
	}

}
