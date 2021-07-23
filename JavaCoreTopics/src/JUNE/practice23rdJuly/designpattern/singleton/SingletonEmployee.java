package JUNE.practice23rdJuly.designpattern.singleton;

/**
 * @author sidharthdas on 23/07/21.
 */
public class SingletonEmployee {

    private static SingletonEmployee instance;

    private SingletonEmployee(){

    }

    public static SingletonEmployee getInstance(){

        if(instance == null){

            synchronized (SingletonEmployee.class){
                if (instance == null){
                    instance = new SingletonEmployee();
                }
            }
        }
        return instance;
    }
}
