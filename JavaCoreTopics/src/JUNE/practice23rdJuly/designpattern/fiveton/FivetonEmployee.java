package JUNE.practice23rdJuly.designpattern.fiveton;

import JUNE.practice23rdJuly.serialization.Employee;

/**
 * @author sidharthdas on 23/07/21.
 */
public class FivetonEmployee {

    private static FivetonEmployee[] instances = new FivetonEmployee[5];
    private static int index = 0;

    private FivetonEmployee(){

    }

    public static FivetonEmployee getInstance(){
        if(instances[index] == null){
            instances[index] = new FivetonEmployee();
        }
        FivetonEmployee instance = instances[index];
        System.out.println(index);
        index = (index +1) % instances.length;
        return instance;
    }
}
