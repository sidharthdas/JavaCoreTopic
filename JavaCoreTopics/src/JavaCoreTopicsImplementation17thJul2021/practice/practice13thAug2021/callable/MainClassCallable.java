package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.callable;

import java.util.concurrent.*;

/**
 * @author sidharthdas on 14/08/21.
 */
public class MainClassCallable {

    public static void main ( String[] args ) throws ExecutionException, InterruptedException {

        Callable< Integer > callable = () -> {
            return 10;
        };


        ExecutorService service = Executors.newFixedThreadPool(10);
        Future< Integer > i = service.submit(callable);
        System.out.println(i.get());
    }
}
