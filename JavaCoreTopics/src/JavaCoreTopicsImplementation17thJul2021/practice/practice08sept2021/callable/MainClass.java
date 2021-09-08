package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.callable;

import java.util.concurrent.*;

/**
 * @author sidharthdas on 08/09/21.
 */
public class MainClass {


    public static void main ( String[] args ) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = ()->{
          return 1;
        };

        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<Integer> i = service.submit(callable);
        System.out.println(i.get());
    }
}
