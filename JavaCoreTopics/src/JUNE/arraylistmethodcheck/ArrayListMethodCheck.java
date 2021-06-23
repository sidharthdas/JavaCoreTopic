package JUNE.arraylistmethodcheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethodCheck {

    public static void main ( String[] args ) {

        List<String> list = new ArrayList<>();
        list.add("Tinku");
        list.add("Tinku1");
        list.add("Tinku2");
        list.add("Tinku3");
        list.set(0, "Pinku");

        System.out.println(list);






    }
}
