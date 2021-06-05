/**
 * 
 */
package sid.exceptionhandler;

/**
 * @author sidharthdas
 *
 */
public class MainClass {

	public static void main(String[] args) {

		RunnableImpl rImpl = new RunnableImpl();
		Thread thread = new Thread(rImpl);
		thread.start();

	}

}
