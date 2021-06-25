package JUNE.upcastingDowncasting;

/**
 * @author sidharthdas on 25/06/21.
 */
public class Child extends Parent{

    public void ctest2(){
        System.out.println("in ctest2 method of Child class");
    }
    public void ctest3(){
        System.out.println("in ctest3 method of Child class");
    }

    @Override
    public void padd () {

        System.out.println("in override padd method in child class");
    }
}
