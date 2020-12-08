package practice15.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface WorkFlow{
	long osVersion() default  1l;
	String mobileOS() default "Andriod";
	
}

@WorkFlow(osVersion =  (long) 14.2, mobileOS = "iOS")
class Test{
	
}

public class AnnotationMainClass {
	
	public static void main(String[] args) {
		
		Test t = new Test();
		Class c = t.getClass();
		Annotation a = c.getDeclaredAnnotation(WorkFlow.class);
		
		WorkFlow w = (WorkFlow) a;
		
		System.out.println(w.mobileOS());
		System.out.println(w.osVersion());
		
	}

	

}
