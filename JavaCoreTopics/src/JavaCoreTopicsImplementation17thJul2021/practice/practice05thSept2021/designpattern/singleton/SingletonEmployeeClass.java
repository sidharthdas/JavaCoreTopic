package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.designpattern.singleton;

/**
 * @author sidharthdas on 05/09/21.
 */
public class SingletonEmployeeClass {

    private static SingletonEmployeeClass instance;

    private SingletonEmployeeClass () {
    }

    public static SingletonEmployeeClass getInstance () {
        if (instance == null) {

            synchronized (SingletonEmployeeClass.class) {

                if (instance == null) {
                    instance = new SingletonEmployeeClass();
                }
            }
        }

        return instance;
    }
}
