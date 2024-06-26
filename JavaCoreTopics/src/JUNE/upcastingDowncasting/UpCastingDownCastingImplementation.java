package JUNE.upcastingDowncasting;

/**
 * @author sidharthdas on 25/06/21.
 */
public class UpCastingDownCastingImplementation {

    public static void main ( String[] args ) {

        //IN UPCASTING - ALL METHOD OF PARENT CLASS EXCEPT OVERRIDE METHOD
        System.out.println("Up casting:---");
        Parent p = new Child();
       p.ptest3();
       p.ptest2();
       p.padd();

        //DOWNCASTING - All method of Parent and all method of child but not the over-hiding method(the method which is overrided in Child class)
        System.out.println("Down casting:---");
        Parent p1 = new Child();
        Child c1 = (Child) p1;

        c1.ctest2();
        c1.ctest3();
        c1.ptest2();
        c1.ptest3();
        c1.padd();


    }
}
