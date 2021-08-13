package JavaCoreTopicsImplementation17thJul2021.practice.practice31stJuly2021.designPattern.singleton;

/**
 * @author sidharthdas on 31/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());
        System.out.println(SingletonEmployee.getInstance().hashCode());

    }
}
