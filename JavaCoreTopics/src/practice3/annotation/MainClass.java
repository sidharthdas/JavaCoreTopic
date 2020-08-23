package practice3.annotation;

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
	String osname() default "Andriod";
	
}
@WorkFlow(version = 2, osname = "iOS")
class SmartPhone{
	
}

public class MainClass {
	
	public static void main(String[] args) {
		
		SmartPhone st = new SmartPhone();
		Class c = st.getClass();
		Annotation a = c.getAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		System.out.println(w.version());
		System.out.println(w.osname());
		
		Object obj = new Object();
		
	}

}
