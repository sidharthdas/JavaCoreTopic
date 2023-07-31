package completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureMainClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Validator> validatorList = List.of(new Validator(), new Validator(), new Validator());

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount);
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        List<CompletableFuture<Boolean>> completableFutureList = new ArrayList<>();
        for (Validator v : validatorList) {
            completableFutureList.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return v.validate();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, executorService));
        }

        CompletableFuture<Void> completableFutureVoid =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        List<Boolean> b = completableFutureVoid.thenApply(x ->
                completableFutureList.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        ).get();

        System.out.println(b);
    }

}

class Validator {

    public boolean validate() throws InterruptedException {
        //For Testing
        Thread.sleep(3000);
        return true;
    }
}
