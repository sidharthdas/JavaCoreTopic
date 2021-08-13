package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.designpartterntest.Fiveton;

/**
 * @author sidharthdas on 21/07/21.
 */
public class Employee {

    private static Employee[] instances = new Employee[5];
    private static int index = 0;

    private Employee(){

    }

    public static Employee getInstance(){
        if(instances[index] == null){
            instances[index] = new Employee();
        }
        Employee instance = instances[index];
        System.out.println(index);
        index = (index+1) % instances.length;
        return instance;
    }
}
