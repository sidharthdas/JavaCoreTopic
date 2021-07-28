package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.singleton;

/**
 * @author sidharthdas on 28/07/21.
 */
public class SingletonMainClass {

    public static void main ( String[] args ) {
        System.out.println(EmployeeSingleton.getInstance().hashCode());
        System.out.println(EmployeeSingleton.getInstance().hashCode());
        System.out.println(EmployeeSingleton.getInstance().hashCode());
        System.out.println(EmployeeSingleton.getInstance().hashCode());
        System.out.println(EmployeeSingleton.getInstance().hashCode());
        System.out.println(EmployeeSingleton.getInstance().hashCode());
    }
}
