package JUNE.practice23rdJuly.designpattern.singleton;

/**
 * @author sidharthdas on 23/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());System.out.println(SingletonEmployee.getInstance().hashCode());

    }
}
