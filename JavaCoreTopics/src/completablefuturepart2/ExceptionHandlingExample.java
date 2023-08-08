package completablefuturepart2;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        boolean error = false;
//Handle
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
           if(error) {
               throw new RuntimeException("Error");
           }
           return "Success";
        }).handle((s, e)->{
            if(e != null){
                System.out.println(e.getMessage());
                return "null";
            }
            return s;
        });

        System.out.println(completableFuture.join());

        //Exceptionally

        CompletableFuture<String> completableFutureExceptionally = CompletableFuture.supplyAsync(() -> {
            if(error) {
                throw new RuntimeException("Error");
            }
            return "Success";
        }).exceptionally((e)->{
            if(e != null){
                System.out.println(e.getMessage());
                return "null";
            }
            return null;
        });
    }


}
