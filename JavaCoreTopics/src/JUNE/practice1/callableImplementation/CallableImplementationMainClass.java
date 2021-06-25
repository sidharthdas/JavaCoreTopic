package JUNE.practice1.callableImplementation;

import java.util.concurrent.*;

/**
 * @author sidharthdas on 25/06/21.
 */
public class CallableImplementationMainClass {


    public static void main ( String[] args ) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = ()->{
            return 10;
        };

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future< Integer > obj = service.submit(callable);
        System.out.println(obj.get());
    }
}
