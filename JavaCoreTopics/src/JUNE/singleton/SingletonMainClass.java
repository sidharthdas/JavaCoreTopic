package JUNE.singleton;

/**
 * @author sidharthdas on 23/06/21.
 */
public class SingletonMainClass {

    public static void main ( String[] args ) {

        System.out.println(Employee.getInstance("sid").hashCode());
        System.out.println(Employee.getInstance("ram").hashCode());
        System.out.println(Employee.getInstance("s").hashCode());
        System.out.println(Employee.getInstance("ff").hashCode());
        System.out.println(Employee.getInstance("gfdfd").hashCode());



    }
}
