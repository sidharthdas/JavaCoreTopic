/**
 * 
 */
package practice18.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author sidharthdas
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface WorkFlow{
	int osversion() default 1;
	String osName() default "Andriod";
}

@WorkFlow(osversion = 2, osName = "iOS")
class Mobile{
	
}
public class MainClass {
	
	public static void main(String[] args) {
		
		
		Mobile mob = new Mobile();
		
		Class c = mob.getClass();
		Annotation a = (Annotation) c.getDeclaredAnnotation(WorkFlow.class);
		WorkFlow w = (WorkFlow) a;
		System.out.println(w.osName());
		System.out.println(w.osversion());
	}

}
