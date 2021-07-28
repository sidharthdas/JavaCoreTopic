package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.fiveton;

import JavaCoreTopicsImplementation17thJul2021.practice.designpartern.singleton.EmployeeSingleton;

/**
 * @author sidharthdas on 28/07/21.
 */
public class EmployeeFiveton {

    private static final EmployeeFiveton[] instances = new EmployeeFiveton[5];
    private static int index = 0;

    private EmployeeFiveton(){

    }

    public static EmployeeFiveton getInstance(){
        if(instances[index] == null){
            instances[index] = new EmployeeFiveton();
        }

        EmployeeFiveton instance = instances[index];
        System.out.println(index);
        index = (index+1) % instances.length;
        return instance;
    }
}
