package JavaCoreTopicsImplementation17thJul2021.practice.practice6thAugust2021.designpartern.singleton;

/**
 * @author sidharthdas on 06/08/21.
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
