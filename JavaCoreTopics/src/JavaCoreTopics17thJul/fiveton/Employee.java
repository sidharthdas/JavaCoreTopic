package JavaCoreTopics17thJul.fiveton;

/**
 * @author sidharthdas on 23/06/21.
 */
public class Employee {

    private int employeeId;
    private static final Employee[] instances = new Employee[5];
    private static int index = 0;

    private Employee(int employeeId){
        this.employeeId = employeeId;
    }


    public static Employee getInstance( int employeeId){
        if(instances[index] == null){
            instances[index] = new Employee(employeeId);
        }
        Employee instance = instances[index];
        System.out.println(index);
        index = (index+1) % instances.length;
        return instance;
    }
}
