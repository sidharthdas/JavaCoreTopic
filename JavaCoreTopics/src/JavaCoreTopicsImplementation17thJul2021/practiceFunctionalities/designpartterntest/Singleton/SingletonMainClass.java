package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.designpartterntest.Singleton;

/**
 * @author sidharthdas on 21/07/21.
 */
public class SingletonMainClass {

    public static void main ( String[] args ) {

        System.out.println(Employee.getInstance().hashCode());
        System.out.println(Employee.getInstance().hashCode());
        System.out.println(Employee.getInstance().hashCode());
        System.out.println(Employee.getInstance().hashCode());
        System.out.println(Employee.getInstance().hashCode());
        System.out.println(Employee.getInstance().hashCode());

    }
}
