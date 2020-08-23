package practice3.immutableclass;

import java.util.ArrayList;

public class ImmutableMainClass {
	
	public static void main(String[] args) {
		Immutable im1 = new Immutable("test1", new ArrayList<String>());
		im1.getName();
		im1.getStrList().add("sid");
		im1.getStrList().add("sag");
		
		System.out.println(im1.getStrList());
	}

}
