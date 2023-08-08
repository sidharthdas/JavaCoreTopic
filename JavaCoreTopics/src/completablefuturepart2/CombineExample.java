package completablefuturepart2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombineExample {

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        CompletableFuture<String> finalOutput = getUserDetails().thenCombine(getWeatherDetails(), (u, w) -> {
            return "sent email to " + u + " where weather is " + w;
        });


        System.out.println(finalOutput.join());

    }

    public static CompletableFuture<String> getUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("In getUser");
            delay(2);
            return "Sidharth";
        });
    }

    public static CompletableFuture<String> getWeatherDetails() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("In getWeatherDetails");
            delay(3);
            return "Sunny";
        });
    }
}
