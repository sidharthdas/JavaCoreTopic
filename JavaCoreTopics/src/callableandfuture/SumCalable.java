package callableandfuture;

import java.util.concurrent.Callable;

public class SumCalable implements Callable<Integer>{
	
	
	private int input;
	
	public SumCalable(int input) {
		this.input = input;
	}

	@Override
	public Integer call() throws Exception {
		
		Thread.sleep(1000);
		int sum = 0;
		
		for(int i =1; i <= input; i++) {
			sum = sum +i;
			
		}
		return sum;
	}

}
