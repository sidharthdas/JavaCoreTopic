package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.designpartterntest.Singleton;

/**
 * @author sidharthdas on 21/07/21.
 */
public class Employee {

    private static Employee instance;

    private Employee () {

    }

    public static Employee getInstance () {
        if (instance == null) {

            synchronized (Employee.class) {
                if (instance == null) {
                    instance = new Employee();
                }
            }

        }
        return instance;
    }
}
