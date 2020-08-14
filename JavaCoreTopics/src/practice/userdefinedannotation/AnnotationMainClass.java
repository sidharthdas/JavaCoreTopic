package practice.userdefinedannotation;

import java.lang.annotation.Annotation;

@WorkFlow(version = 1, OS = "Andriod")
class Student{
	
	long i ;
	String osName;
	
}

public class AnnotationMainClass {
	
	
	public static void main(String[] args) {
		
		Student std = new Student();
		
		Class cl = std.getClass();
		Annotation a = cl.getAnnotation(WorkFlow.class);
		WorkFlow s = (WorkFlow) a;
		System.out.println(s.version());
		System.out.println(s.OS());
		
		
		
	}

}
