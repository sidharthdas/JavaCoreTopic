package JavaCoreTopicsImplementation17thJul2021.callableImplementation;

import java.util.concurrent.*;

/**
 * @author sidharthdas on 23/06/21.
 */
public class CallableImplementation {

    public static void main ( String[] args ) throws ExecutionException, InterruptedException {


        Callable<Integer> callable = ()->{
            return 10;
        };

        ExecutorService executerService = Executors.newFixedThreadPool(10);
        Future<Integer> value =  executerService.submit(callable);
        System.out.println(value.get());
    }
}
