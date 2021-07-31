package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.designPattern.singleton;

/**
 * @author sidharthdas on 31/07/21.
 */
public class SingletonEmployee {


    private static SingletonEmployee instance;

    private SingletonEmployee () {

    }

    public static SingletonEmployee getInstance () {
        if (instance == null) {

            synchronized (SingletonEmployee.class) {
                if (instance == null) {
                    instance = new SingletonEmployee();
                }
            }
        }

        return instance;
    }
}
