package practice4.annotation;

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
	int version() default 0;
	String ios() default "andriod";
}

@WorkFlow(ios =  "ios", version = 1)
class Mobile{
	
}

public class MainClass {
	
	public static void main(String[] args) {
		Mobile mob = new Mobile();
		Class c = mob.getClass();
		Annotation a = c.getAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		System.out.println(w.ios());
		System.out.println(w.version());
		
	}

}
