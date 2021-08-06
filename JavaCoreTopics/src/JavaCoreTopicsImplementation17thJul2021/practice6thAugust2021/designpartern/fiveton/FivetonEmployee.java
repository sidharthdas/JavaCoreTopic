package JavaCoreTopicsImplementation17thJul2021.practice6thAugust2021.designpartern.fiveton;

/**
 * @author sidharthdas on 06/08/21.
 */
public class FivetonEmployee {

    private static FivetonEmployee[] instances = new FivetonEmployee[5];
    private static int index = 0;

    private FivetonEmployee () {

    }

    public static FivetonEmployee getInstance () {
        if (instances[index] == null) {
            instances[index] = new FivetonEmployee();
        }
        FivetonEmployee instance = instances[index];
        System.out.println(index);
        index = (index + 1) % instances.length;
        return instance;

    }
}
