package JavaCoreTopicsImplementation17thJul2021.customList;

import java.util.Arrays;
import java.util.List;

/**
 * @author sidharthdas on 20/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        List<Integer> l = Arrays.asList(1,2,3,4,5);

        for(int i : l){
            System.out.println(i);
        }

        CustomList<Integer> lis = new CustomList<>();

        for(Object i : lis){

        }
    }
}
