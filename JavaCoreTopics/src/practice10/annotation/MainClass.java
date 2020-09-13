package practice10.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface WorkFlow {
	int version() default 1;

	String OS() default "Andriod";
}

@WorkFlow(OS = "iOS", version = 12)
class Mobile {

}

public class MainClass {

	public static void main(String[] args) {

		Mobile m = new Mobile();
		Class c = m.getClass();
		Annotation a = c.getDeclaredAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		System.out.println(w.OS());
		System.out.println(w.version());
	}

}
