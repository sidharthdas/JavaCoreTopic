package practice5.userAnnotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface WorkFlow{
	int version() default 1;
	String OS() default "non";
}

@WorkFlow(version = 12, OS = "iOS")
class IPhone{
	
}

public class UserDefindAnnotaionMainClass {
	
	public static void main(String[] args) {
		
		IPhone iphone = new IPhone();
		
		Class c = iphone.getClass();
		Annotation a = c.getAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		System.out.println(w.OS());
		System.out.println(w.version());
		
		
	}

}
