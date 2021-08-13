package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.Fiveton;

/**
 * @author sidharthdas on 13/08/21.
 */
public class EmployeeFiveton {

    private static EmployeeFiveton[] instances = new EmployeeFiveton[5];
    private static int index = 0;

    private EmployeeFiveton(){};

    public static EmployeeFiveton getInstance(){
        if(instances[index] == null){
            instances[index] = new EmployeeFiveton();
        }
        EmployeeFiveton instance = instances[index];
        index = (index + 1) % instances.length;
        System.out.println(index);
        return instance;
    }
}
