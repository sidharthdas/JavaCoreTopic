package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author sidharthdas on 05/09/21.
 */
public class MainClass {


    public static void main ( String[] args ) {

    }


    public List< Integer > filter ( List< Integer > l, Predicate< Integer > predicate ) {
        List< Integer > list = new ArrayList<>();
        for (int i : l) {
            if (predicate.test(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
