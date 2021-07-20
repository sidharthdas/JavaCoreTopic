package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author sidharthdas on 20/07/21.
 */
public class IntPredicateMainClass {

    public static void main ( String[] args ) {

        Predicate< Integer > p = x -> x % 2 == 0;
        System.out.println(p.test(10));
        /*Here what is happening is we are giving int ---> Integer ----> int
        * Autoboxing and autounboxing is happening, which may lead to performance issue, to overcome that we have anaother FunctionalInterface.
        * i.e. IntPredicate
        * */

        IntPredicate intPredicate = y -> y%2 ==0;
        System.out.println(intPredicate.test(20));
    }
}
