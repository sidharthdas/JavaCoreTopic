package callableandfuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureMainClass {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Future<Integer>> list  = new ArrayList<>();
		for(int i = 0; i<100; i++) {
		Future<Integer> future = service.submit(new SumCalable(i));
		
		list.add(future);
		}
		
		for(Future<Integer> f : list) {
			System.out.println(f.get());
		}
	}

}
