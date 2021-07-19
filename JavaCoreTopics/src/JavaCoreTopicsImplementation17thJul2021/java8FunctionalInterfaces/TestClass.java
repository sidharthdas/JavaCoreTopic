package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 19/07/21.
 */
public class TestClass {

    public static void main ( String[] args ) {

        List< Integer > list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Predicate<Integer> predicate = x-> x%2 ==0;
        Predicate<Integer> predicate1 = x-> x> 10;
        Predicate<Integer> predicate2 = predicate1.or(predicate);
        List<Integer> list1 = list.stream().filter(predicate2).collect(Collectors.toList());
        System.out.println(list1);

    }
}
