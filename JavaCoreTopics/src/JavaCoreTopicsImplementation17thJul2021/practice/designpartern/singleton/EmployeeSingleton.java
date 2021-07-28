package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.singleton;

/**
 * @author sidharthdas on 28/07/21.
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
