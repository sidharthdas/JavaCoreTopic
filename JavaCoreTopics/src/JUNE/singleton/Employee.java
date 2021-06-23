package JUNE.singleton;

/**
 * @author sidharthdas on 23/06/21.
 */
public class Employee {

    private String employeeName;
    private static Employee instance;

    private Employee(String employeeName){
        this.employeeName = employeeName;
    }

    public static Employee getInstance(String employeeName){
        if(instance == null){
            instance = new Employee(employeeName);
        }
        return instance;
    }


}
