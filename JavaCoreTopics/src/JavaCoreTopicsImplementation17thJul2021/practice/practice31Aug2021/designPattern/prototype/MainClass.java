package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.prototype;

/**
 * @author sidharthdas on 31/08/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        EmployeePrototype e1 = new EmployeePrototype("s", "a");

        System.out.println(e1.getEmpAddress());
        System.out.println(e1.getEmpName());

        System.out.println("---------");

        EmployeePrototype e2 = (EmployeePrototype) e1.clone();

        System.out.println(e2.getEmpName());
        System.out.println(e2.getEmpAddress());

    }
}
