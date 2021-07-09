package JUNE.practice1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sidharthdas on 09/07/21.
 */
public class LinkedHashMapMainClass {

    public static void main ( String[] args ) {
/*      m : 2
        y : 1
        n : 1
        a : 3
        e : 1
        i : 2
        s : 3
        d : 2
        h : 2
        r : 1
        t : 1

        m : 2
        y : 1
        n : 1
        a : 3
        e : 1
        i : 2
        s : 3
        d : 2
        h : 2
        r : 1
        t : 1 */

        String s = "My name is Sidharth Das";

        Map< String, Integer > map = new LinkedHashMap<>();

        String str[] = s.split(" ");

        String strWithoutSp = "";

        for (String s1 : str) {
            strWithoutSp += s1;
        }
        strWithoutSp = strWithoutSp.toLowerCase();

        String[] s2 = strWithoutSp.split("");

        for (String sss : s2) {
            if (map.containsKey(sss)) {
                map.put(sss, map.get(sss) + 1);
            } else {
                map.put(sss, 1);
            }
        }


        for (Map.Entry< String, Integer > m : map.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}
