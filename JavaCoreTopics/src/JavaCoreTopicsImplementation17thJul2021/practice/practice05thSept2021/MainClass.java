package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021;

/**
 * @author sidharthdas on 05/09/21.
 */

class Emp {

    int data;
    int add;

    public Emp () {
    }

    public Emp ( int data, int add ) {
        this.data = data;
        this.add = add;
    }
}

public class MainClass {
    int i = 0;

    public static void main ( String[] args ) {
        Emp e = new Emp(1, 2);
        test(e);
        System.out.println(e.data);
    }

    static void test ( Emp e ) {
        e = new Emp();
        e.data = 50;
    }
}
