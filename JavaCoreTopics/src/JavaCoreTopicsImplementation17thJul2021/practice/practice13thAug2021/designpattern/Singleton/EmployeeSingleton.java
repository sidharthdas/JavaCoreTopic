package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.Singleton;

/**
 * @author sidharthdas on 13/08/21.
 */
public class EmployeeSingleton {

    private static EmployeeSingleton instance;

    private EmployeeSingleton () {
    }

    public static EmployeeSingleton getInstance () {
        if (instance == null) {

            synchronized (EmployeeSingleton.class) {
                if (instance == null) {
                    instance = new EmployeeSingleton();
                }
            }
        }
        return instance;
    }
}
