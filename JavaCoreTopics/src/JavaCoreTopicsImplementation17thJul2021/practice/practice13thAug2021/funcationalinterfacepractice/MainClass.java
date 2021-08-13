package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.funcationalinterfacepractice;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author sidharthdas on 14/08/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        new MainClass().asPerChecks(Arrays.asList(1,2,3,4,5,6,7,8,9,10), x-> x % 2 != 0);

    }


    public void asPerChecks( List<Integer> list , IntPredicate predicate ){

        list.forEach(x->{

            if(predicate.test(x)){
                System.out.print(x+" ");
            }
        });
    }
}
