package playbookITC;

/*3.Given an input string, write a function that returns the Run Length encoded string. For example, if the 
 * input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”. 
Example: Input "aaabbcaaaadddeee"
Output: "a3b2c1a4d3e3
*/

public class MainClass3 {
	
	
	public static void main(String[] args) {
		
		String s = "aaabbcaaaadddeee";
		
		String temp = null;
		int count = 0;
		String mainString =  null;
		String[] sArr = s.split("");
		
		for(int i = 0; i < sArr.length; i++) {
			
			if(i == 0) {
				temp = sArr[i];
				count = count + 1;
			}else {
				if(temp.equals(sArr[i])) {
					count = count +1;
				}else {
					if(mainString == null) {
					mainString = temp + count;
					}else {
						mainString = mainString+ temp + count;
					}
					temp = sArr[i];
					count = 1;
				}
			}
			
		}
		
		mainString = mainString+temp+count;
		System.out.println(mainString);
		
	}

}
