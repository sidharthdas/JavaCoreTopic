package JUNE.practice23rdJuly.callableImplementation;

import java.util.concurrent.*;

/**
 * @author sidharthdas on 23/07/21.
 */
public class CallableMainClass {

    public static void main ( String[] args ) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = ()->{
          return 10;
        };

        ExecutorService  service =  Executors.newFixedThreadPool(10);
        Future< Integer > i = service.submit(callable);
        System.out.println(i.get());
    }
}
