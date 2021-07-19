package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author sidharthdas on 19/07/21.
 */

class Employee {

    String employeeName;
    int empSalary;

    public Employee ( String employeeName, int empSalary ) {
        this.employeeName = employeeName;
        this.empSalary = empSalary;
    }


    @Override
    public String toString () {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", empSalary='" + empSalary + '\'' +
                '}';
    }
}

public class ConsumerJava8MainClass {

    public static void main ( String[] args ) {

        Consumer< String > consumer = ( x ) -> System.out.println(x);
        consumer.accept("Sidharth");

        List<Employee> employeeList = Arrays.asList(new Employee("Sidharth", 1000),new Employee("Ram", 3000),new Employee("Shayam", 1000));
        Consumer<Employee> consumer1 = (x)->{
          x.empSalary = x.empSalary+10;
        };
        //Consumer functional interface, it has one method i.e. accept(T t) and return type is void.
        addAmountToTheEmployee(employeeList, consumer1);

        System.out.println(employeeList);
    }



    public static void addAmountToTheEmployee( List<Employee> list, Consumer<Employee> consumer){

        for(Employee e: list){
            consumer.accept(e);
        }
    }
}
