package JUNE.practice.inheritance;

/**
 * @author sidharthdas on 24/06/21.
 */
public class B extends A{


    @Override
    public void authenticate () {
        this.refreshToken();
    }

    public static void main ( String[] args ) {

   B b = new B();
   b.authenticate();
    }
}
