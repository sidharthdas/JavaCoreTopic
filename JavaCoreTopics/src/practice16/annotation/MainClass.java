package practice16.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface WorkFlow {
	int osVersion() default 1;

	String osName() default "Andriod";

}

@WorkFlow(osName = "iOS", osVersion = 14)
class Mobile{
	
}

public class MainClass {
	
	public static void main(String[] args) {
		Mobile mobile = new  Mobile();
		
		Class c = mobile.getClass();
		Annotation a = c.getDeclaredAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		System.out.println(w.osName());
		System.out.println(w.osVersion());
	}

}
