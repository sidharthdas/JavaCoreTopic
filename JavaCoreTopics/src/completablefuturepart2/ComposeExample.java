package completablefuturepart2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ComposeExample {

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

        //Supplier
        CompletableFuture<String> completableFutureSupply = getUserDetails()
                .thenCompose(s -> getWishList(s));

        System.out.println("hellow world");
        delay(3); 
        System.out.println(completableFutureSupply.join());
    }

    public static CompletableFuture<String> getUserDetails(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("in getUserDetails");
            delay(2);
            return "Sidharth";
        });
    }


    public static CompletableFuture<String> getWishList(String user){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("in getWishList");
            delay(2);
            return "User wishlist is returned-"+user;
        });
    }
}
