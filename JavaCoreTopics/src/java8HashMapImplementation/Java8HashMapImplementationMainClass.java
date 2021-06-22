package java8HashMapImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Employee{
    private String employeeName;
    public Employee(String employeeName){
        this.employeeName = employeeName;
    }


    @Override
    public int hashCode () {
        return 1;
    }

    @Override
    public boolean equals ( Object o ) {
       return this.getEmployeeName() == ((Employee)o).getEmployeeName();
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName ( String employeeName ) {
        this.employeeName = employeeName;
    }
}

public class Java8HashMapImplementationMainClass {

    public static void main ( String[] args ) {

        Map< Employee, Integer > map = new HashMap<>();
        map.put(new Employee("Sid"), 1);
        map.put(new Employee("Si1d"), 1);
        map.put(new Employee("Si2d"), 1);
        map.put(new Employee("Si3d"), 1);
        map.put(new Employee("Si4d"), 1);
        map.put(new Employee("Si5d"), 1);
        map.put(new Employee("Si6d"), 1);
        map.put(new Employee("Si7d"), 1);
        map.put(new Employee("Si744d"), 1);
        map.put(new Employee("Si633d"), 1);
        map.put(new Employee("Si6111d"), 1);
        map.put(new Employee("Si655d"), 1);
        map.put(new Employee("Si006d"), 1);





    }
}
