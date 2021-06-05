/**
 * 
 */
package sid.exceptionhandler;

/**
 * @author sidharthdas
 *
 */
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.parseInt("234"));
		System.out.println(Integer.parseInt("345"));
		
		
		
		System.out.println(Integer.parseInt("456"));
		
		try {
			System.out.println(Integer.parseInt("XYZ")); // This will cause NumberFormatException
			Thread.sleep(1000);
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
