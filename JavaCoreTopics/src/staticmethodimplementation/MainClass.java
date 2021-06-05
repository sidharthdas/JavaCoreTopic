/**
 * 
 */
package staticmethodimplementation;

/**
 * @author sidharthdas
 *
 */

class Employee{
	
	public static void test() {
		System.out.println("in test method");
	}
}
public class MainClass {

	public static void main(String[] args) {
		
		Employee emp = null;
		Employee.test();

	}

}
