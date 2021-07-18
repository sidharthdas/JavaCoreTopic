package JavaCoreTopicsImplementation17thJul2021.inheritance;

/**
 * @author sidharthdas on 18/07/21.
 */

class A{

    public void test(){
        System.out.println("in test method of class A");
    }

    public static void test1(){
        System.out.println("in test1 static  method of class A");
    }

}

class B extends A{

    @Override
    public void test () {
        System.out.println("in override method");
    }

    public static void test1(){
        System.out.println("in test1 static  method of class B");
    }
}
public class InheritanceMainClass {

    public static void main ( String[] args ) {

        //We can call static method with object reference.
        //We cant override the static method in java.
        // A b = new B();   b.test1(); : it will call the static method of class A.

        A b = new B(); //Upcasting, IN UPCASTING - ALL METHOD OF PARENT CLASS EXCEPT OVERRIDE METHOD
        B b1 = (B)b; /*Downcasting, IN DOWNCASTING - All method of Parent and all method of child but
                                / not the over-hiding method(the method which is overrided in Child class)  */
        b.test1();
    }
}
