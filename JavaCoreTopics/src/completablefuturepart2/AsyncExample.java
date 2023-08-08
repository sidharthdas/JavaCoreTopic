package completablefuturepart2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncExample {

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

        //Runnable
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            delay(1);
            System.out.println("Im runnable -" + Thread.currentThread().getName());
        }, executorService);

        completableFuture.join();

        //Supplier
        CompletableFuture<Integer> completableFutureSupply = CompletableFuture.supplyAsync(() -> {
            delay(1);
            System.out.println("Im supplier -" + Thread.currentThread().getName());
            return 10;
        }, executorService);

        int i = completableFutureSupply.join();
        System.out.println(i);
    }
}
