package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.designpattern.fiveton;

/**
 * @author sidharthdas on 05/09/21.
 */
public class FivetonEmployeeClass {

    private static FivetonEmployeeClass[] instances = new FivetonEmployeeClass[5];

    private static int index = 0;

    private FivetonEmployeeClass () {
    }

    public FivetonEmployeeClass getInstance () {
        if (instances[index] == null) {
            instances[index] = new FivetonEmployeeClass();
        }
        FivetonEmployeeClass instance = instances[index];
        System.out.println(index);
        index = (index + 1) % instances.length;
        return instance;
    }
}
