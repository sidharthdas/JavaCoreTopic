package completablefuturepart2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AnyAllOfExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //AllOf()
        long start = System.currentTimeMillis();
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFuture1(), completableFuture2(), completableFuture3());

        completableFuture.join();
        long end = System.currentTimeMillis();

        System.out.println("time taken - " + (end - start) / 1000);

        //AllOf 2nd Way

        List<CompletableFuture<String>> completableFutureList = new ArrayList<>();
        completableFutureList.add(completableFuture1());
        completableFutureList.add(completableFuture2());
        completableFutureList.add(completableFuture3());


        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        List<String> l1 = voidCompletableFuture
                .thenApply(x ->
                        completableFutureList.stream()
                                .map(CompletableFuture::join)
                                .toList())
                .get()
                .stream().toList();
        System.out.println(l1);


        //AnyOf()
        start = System.currentTimeMillis();
        CompletableFuture<Object> completableFuture1 = CompletableFuture.anyOf(completableFuture1(), completableFuture2(), completableFuture3());

        completableFuture.join();
        end = System.currentTimeMillis();

        System.out.println("time taken - " + (end - start) / 1000);
    }

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<String> completableFuture1() {
        return CompletableFuture.supplyAsync(() -> {
            delay(1);
            return "Completable Future 1";
        });
    }

    public static CompletableFuture<String> completableFuture2() {
        return CompletableFuture.supplyAsync(() -> {
            delay(3);
            return "Completable Future 2";
        });
    }

    public static CompletableFuture<String> completableFuture3() {
        return CompletableFuture.supplyAsync(() -> {
            delay(3);
            return "Completable Future 3";
        });
    }
}
