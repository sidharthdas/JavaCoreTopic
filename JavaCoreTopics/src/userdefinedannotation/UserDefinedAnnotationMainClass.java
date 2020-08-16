package userdefinedannotation;

import java.lang.annotation.Annotation;

@WorkFlow(version = 13.6 , OS = "iOS")
class AppleIphone{
	
	int modelNumber;
	String iphoneName;
	
	public AppleIphone(int modelNumber, String iphoneName) {
		this.modelNumber = modelNumber;
		this.iphoneName = iphoneName;
	}
	
}

public class UserDefinedAnnotationMainClass {
	
	public static void main(String[] args) {
		
		AppleIphone appleIphone = new AppleIphone(2022, "x12");
		
		Class c = appleIphone.getClass();
		Annotation a = c.getDeclaredAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		System.out.println(w.OS());
		System.out.println(w.version());
	}

}
