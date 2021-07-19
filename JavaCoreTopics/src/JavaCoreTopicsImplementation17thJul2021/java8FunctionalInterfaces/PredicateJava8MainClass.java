package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 19/07/21.
 */


public class PredicateJava8MainClass {

    public static void main ( String[] args ) {


        List< String > list1 = Arrays.asList("Sagar", "Tripsy", "Dev", "Om", "Sidharth");
        List< Integer > resultList = checkStringConditions(list1, x -> x.charAt(0) == 'S'); //to check if the word starts with 's'.
        Function f;
        Consumer c;


        List< Integer > list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Predicate< Integer > predicate = x -> x % 2 == 0;
        Predicate< Integer > predicate1 = x -> x > 10;

        checkIntConditions(list, predicate); //Condition as per the predicate
        checkIntConditions(list, predicate.negate()); // negate() means reverse condition
        checkIntConditions(list, predicate.and(predicate1)); //we can add as many as predicates using and
        checkIntConditions(list, predicate.or(predicate1)); //we can add as many as predicates using or
        System.out.println("++++++++++++++++++++++++++++++++++");
        checkIntConditions(list, x -> x > 10);

    }

    public static List checkStringConditions ( List< String > list, Predicate< String > condition ) {//Predicate has a boolean method called test()
        List< String > result = new ArrayList<>();
        for (String i : list) {
            if (condition.test(i)) {
                System.out.println(i);
                result.add(i);
            }

        }
        return result;
    }


    public static void checkIntConditions ( List< Integer > list, Predicate< Integer > condition ) {//Predicate has a boolean method called test()
        for (int i : list) {
            if (condition.test(i)) {
                System.out.println(i);

            }

        }

    }
}
