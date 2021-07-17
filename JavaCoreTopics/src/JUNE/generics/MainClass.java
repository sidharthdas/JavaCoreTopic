package JUNE.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sidharthdas on 17/07/21.
 */

class A {
}

class B extends A {
}

public class MainClass {

    public static void main ( String[] args ) {

        List< B > list = new ArrayList<>();

        list.add(new B());
        list.add((B) new A());

    }
}
