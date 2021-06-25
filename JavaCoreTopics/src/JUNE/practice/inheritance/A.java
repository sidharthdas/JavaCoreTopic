package JUNE.practice.inheritance;

import java.util.Map;

/**
 * @author sidharthdas on 24/06/21.
 */

interface I{

    public void authenticate();
}
public class A implements  I{
    @Override
    public void authenticate () {
        System.out.println("in authenticate method of A class");
    }

    public void refreshToken(){

        System.out.println("in authenticate method of A class");
        this.getAccess();

    }

    protected Map<String, String> getAccess(){
        System.out.println("in getAccess method of A class");
        throw new RuntimeException("error");
    }
}
