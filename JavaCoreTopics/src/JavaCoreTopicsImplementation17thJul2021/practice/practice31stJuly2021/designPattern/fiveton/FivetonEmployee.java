package JavaCoreTopicsImplementation17thJul2021.practice.practice31stJuly2021.designPattern.fiveton;

/**
 * @author sidharthdas on 31/07/21.
 */
public class FivetonEmployee {

    private static  FivetonEmployee[] instances = new FivetonEmployee[5];
    private static int index = 0;

    private  FivetonEmployee(){

    }

    public static FivetonEmployee getInstance(){
        if(instances[index] == null){
            instances[index] = new FivetonEmployee();
        }
        FivetonEmployee instance = instances[index];
        System.out.println(index);
        index = (index + 1) % instances.length;
        return instance;

    }
}
