package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.singleton;

/**
 * @author sidharthdas on 31/08/21.
 */
public class SingleEmployee {

    private static SingleEmployee instance;


    private SingleEmployee(){}

    public static SingleEmployee getInstance(){
        if(instance == null){

            synchronized (SingleEmployee.class){
                if(instance == null){
                    instance = new SingleEmployee();
                }
            }
        }

        return instance;
    }
}
