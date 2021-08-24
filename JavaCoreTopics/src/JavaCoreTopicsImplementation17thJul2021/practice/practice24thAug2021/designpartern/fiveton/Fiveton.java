package JavaCoreTopicsImplementation17thJul2021.practice.practice24thAug2021.designpartern.fiveton;

/**
 * @author sidharthdas on 24/08/21.
 */
public class Fiveton {

    private static Fiveton[] instances = new Fiveton[5];
    private static int index;

    private Fiveton(){}

    public static Fiveton getInstance(){
        if(instances[index] == null){
            instances[index] = new Fiveton();
        }
        Fiveton instance = instances[index];
        System.out.println(index);
        index = (index + 1) % instances.length;
        return instance;
    }
}
