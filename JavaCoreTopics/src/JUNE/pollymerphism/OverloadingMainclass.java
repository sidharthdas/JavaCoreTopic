package JUNE.pollymerphism;

/**
 * @author sidharthdas on 17/07/21.
 */
public class OverloadingMainclass {

    public void display ( Object o ) {
        System.out.println("Object");
    }

    public void display ( String s ) {
        System.out.println("String");
    }

    public void display ( Integer i ) {
        System.out.println("Integer");
    }

    public static void main ( String[] args ) {

        OverloadingMainclass overloadingMainclass = new OverloadingMainclass();
        // in this case, atleast we need to cast null to Integer or String, else its a compile time error.
        // overloadingMainclass.display(null);
    }
}
