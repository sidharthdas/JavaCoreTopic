package completablefuturepart2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CallbackExample {

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

        //Supplier
        CompletableFuture<Void> completableFutureSupply = CompletableFuture.supplyAsync(() -> {
            delay(2);
            System.out.println("Im supplier -" + Thread.currentThread().getName());
            return 10;
        }).thenApply(
                x -> x+10
        ).thenAccept(System.out::println);


        completableFutureSupply.join();
    }
}
