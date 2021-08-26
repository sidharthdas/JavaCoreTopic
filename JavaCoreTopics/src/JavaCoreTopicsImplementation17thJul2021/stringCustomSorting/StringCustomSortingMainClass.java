package JavaCoreTopicsImplementation17thJul2021.stringCustomSorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sidharthdas on 26/08/21.
 */
public class StringCustomSortingMainClass {

    public static void main ( String[] args ) {
        final String ORDER= "FCBWHJLOAQUXMPVINTKGZERDYS";

        String s = "acbjabcugdiuwodhjiuowh";

        String[] str = s.split("");

        Arrays.sort(str, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return ORDER.indexOf(o1) -  ORDER.indexOf(o2) ;
            }
        });
        String result = "";
        for(String s1 : str){
            result+= s1;
        }
        System.out.println(result);
    }
}
