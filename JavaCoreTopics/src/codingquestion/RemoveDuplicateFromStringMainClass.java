package codingquestion;

public class RemoveDuplicateFromStringMainClass {
	
	
	public static void main(String[] args) {
		
		
		System.out.println(reverse("java"));
	}
	
	public static String reverse(String s){
		
		String[] strArr = s.split("");
		String newS = null;

		for(int i = strArr.length-1; i>=0; i--){

		if(newS == null){
		newS = strArr[i];
		}else{

		newS = newS+strArr[i];
		}


		}

		return newS;

	}
	
	

}
