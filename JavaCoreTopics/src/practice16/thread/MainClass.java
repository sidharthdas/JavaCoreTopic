package practice16.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Test implements Callable{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return 200;
	}
	
}

public class MainClass {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Test t = new Test();
		ExecutorService service = Executors.newFixedThreadPool(3);
		Future<Integer> i = service.submit(t);
		System.out.println(i.get());
		
	}

}
