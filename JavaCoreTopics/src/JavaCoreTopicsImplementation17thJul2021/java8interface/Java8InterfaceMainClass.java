package JavaCoreTopicsImplementation17thJul2021.java8interface;

import static JavaCoreTopicsImplementation17thJul2021.java8interface.A.test1;

/**
 * @author sidharthdas on 18/07/21.
 */

interface A {

    default void test () {
        System.out.println("in default method  test of A interface");
    }

    static void test1 () {
        System.out.println("in static method test1 of A interface");
    }

    void test3 ();
}

class B implements A {

    @Override
    public void test3 () {

        System.out.println("in test3 implementation method");

    }

    static void test1 () {
        System.out.println("in static method test1 of B CLASS");
    }

    @Override
    public void test () {
        System.out.println("in override method test class of interface A in class B");
        System.out.println("calling super test method");
        A.super.test();
    }
}

public class Java8InterfaceMainClass {

    public static void main ( String[] args ) {
        B b = new B();

        b.test();
        b.test3();
        b.test1(); // can call static method from object reference

        A.test1(); // cant call static method from object reference as its in interface
    }
}
