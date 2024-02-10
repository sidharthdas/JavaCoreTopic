package multimap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiMapMainClass {

    public static void main(String[] args) {

        List<String> l = Arrays.asList("1", "2", "3", " ", "5");

        //Here using flatMap we can avoid that problem, but we are creating stream of nums
        List<Integer> lInt = l.stream()
                .flatMap(string -> {
                    try {
                        ;
                        return Stream.of(Integer.parseInt(string));

                    } catch (NumberFormatException nfe) {
                        return Stream.empty();
                    }
                }).collect(Collectors.toList());

        //Here using mapMulti we can avoid creating new Streams.
        List<Integer> ll = l.stream()
                //mapMulti take biConsumer, so we are sending string and consumer
                .<Integer>mapMulti((string, consumer) -> {
                    try {
                        consumer.accept(Integer.parseInt(string));
                    } catch (Exception ee) {
                    }
                }).collect(Collectors.toList());
    }


}
