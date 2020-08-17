package multithreading;

public class MultiThreadingMainClass {
	
	
	public static void main(String[] args) {
		
		MyThreadByThread t1 = new MyThreadByThread();
		MyThreadByRunnable t2 = new MyThreadByRunnable();
		
		Thread t = new Thread(t2);
		
		Runnable t3 = () -> {
			
			System.out.println("In t3 runnable thread of lambda method");
			
		};
		
		Thread t4 = new Thread(t3);
		
		t.start();
		//t.start(); Illigal thread state exception
		t1.start();
		t4.start();
		
	}

}
