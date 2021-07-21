package JavaCoreTopicsImplementation17thJul2021.designparttern.singleton;

/**
 * @author sidharthdas on 25/06/21.
 */
public class SingletonMainClass {

    public static void main ( String[] args ) {
        System.out.println(Student.getInstance().hashCode());
        System.out.println(Student.getInstance().hashCode());
        System.out.println(Student.getInstance().hashCode());
        System.out.println(Student.getInstance().hashCode());
        System.out.println(Student.getInstance().hashCode());

    }
}
