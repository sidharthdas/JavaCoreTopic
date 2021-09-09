package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.designpattern.singleton;

import JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.serialization.Employee;

/**
 * @author sidharthdas on 09/09/21.
 */
public class EmployeeSingle {

    private static EmployeeSingle instance;

    private EmployeeSingle () {
    }

    public static EmployeeSingle getInstance () {
        if (instance == null) {

            synchronized (EmployeeSingle.class) {
                if (instance == null) {
                    instance = new EmployeeSingle();
                }
            }
        }

        return instance;
    }
}
