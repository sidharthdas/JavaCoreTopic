package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.fiveton;

/**
 * @author sidharthdas on 31/08/21.
 */
public class FiveEmployee {

    private static FiveEmployee[] instances = new FiveEmployee[5];
    private  static int index = 0;

    private FiveEmployee(){

    }

    public static  FiveEmployee getInstance(){

        if(instances[index] == null){
            instances[index] = new FiveEmployee();
        }
        FiveEmployee instance = instances[index];
        System.out.println(index);
        index = (index+1) % 5;
        return instance;
    }
}
