package JavaCoreTopicsImplementation17thJul2021.upcastingDowncasting;

/**
 * @author sidharthdas on 25/06/21.
 */
public class UpCastingDownCastingImplementation {

    public static void main ( String[] args ) {

        //IN UPCASTING - ALL METHOD OF PARENT CLASS EXCEPT OVERRIDE METHOD
        System.out.println("Up casting:---");
        Parent p = new Child();
        p.ptest2();
        p.ptest3();
        p.padd();

        //DOWNCASTING -
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
