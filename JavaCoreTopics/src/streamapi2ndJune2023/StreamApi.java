package streamapi2ndJune2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,45,6);

        Stream<Integer> data = l.stream();

        data.forEach(x -> {
            System.out.println(x);
        });
        //We cant call again coz stream can only be used once. it will throw
        //java.lang.IllegalStateException: stream has already been operated upon or closed
        /*data.forEach(x -> {
            System.out.println(x);
        });*/
    }
}
