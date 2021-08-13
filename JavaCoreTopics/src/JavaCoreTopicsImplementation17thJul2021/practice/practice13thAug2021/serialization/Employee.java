package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.serialization;

import java.io.Serializable;

/**
 * @author sidharthdas on 14/08/21.
 */
public class Employee implements Serializable {

    private static long serialId = 10l;

    String empName;
    transient String empAdd;

    public Employee ( String empName, String empAdd ) {
        this.empName = empName;
        this.empAdd = empAdd;
    }
}
