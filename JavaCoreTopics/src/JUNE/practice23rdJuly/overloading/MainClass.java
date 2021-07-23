package JUNE.practice23rdJuly.overloading;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sidharthdas on 23/07/21.
 */

class A{
    public void test(){
        System.out.println("in A class test");
    }

    public static void test1(){
        System.out.println("in A CLASS STATIC");
    }
}

class B extends A{
    @Override
    public void test () {
        System.out.println("in B override");
    }

    public static void test1(){
        System.out.println("in B " +
                "CLASS STATIC");
    }


}
public class MainClass {

    public static void main ( String[] args ) {

        A a = new B();
        a.test1();

        List<A> list = new ArrayList<>();
        list.add(a);
        list.add(new B());
        list.add(new A());

    }
}
