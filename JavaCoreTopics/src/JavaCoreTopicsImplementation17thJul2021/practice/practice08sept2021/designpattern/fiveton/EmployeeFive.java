package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.designpattern.fiveton;

/**
 * @author sidharthdas on 09/09/21.
 */
public class EmployeeFive {

    private static EmployeeFive[] instances = new EmployeeFive[5];
    private static int index = 0;

    private EmployeeFive () {
    }

    public static EmployeeFive getInstance () {
        if (instances[index] == null) {
            instances[index] = new EmployeeFive();
        }
        System.out.println(index);
        EmployeeFive instance = instances[index];
        index = (index + 1) % 5;
        return instance;
    }
}
