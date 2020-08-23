package practice3.userdefinedannotation;

import java.lang.annotation.Annotation;

@WorkFlow(version = 2, OS =  "Andriod")
class Mobile{
	
	int modelNo;
	String modelName;
	
	public Mobile(int modelNo, String modelName) {
		this.modelNo = modelNo;
		this.modelName = modelName;
	}
}

public class UserDefinedAnnotationMainClass {
	
	public static void main(String[] args) {
		
		
		Mobile mobile = new Mobile(12, "iPhone 7");
		Class c = mobile.getClass();
		Annotation a = c.getAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		
		
		System.out.println(w.OS());
		System.out.println(w.version());
		
	}

}
