package JavaCoreTopicsImplementation17thJul2021.java8FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author sidharthdas on 20/07/21.
 */
class Employee2 {

    int empId;
    String empName;
    int empSalary;

    public Employee2 ( int empId, String empName, int empSalary ) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    @Override
    public String toString () {
        return "Employee2{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}

public class FunctionalInterfacesMainClass {

    public static void main ( String[] args ) {


        List< Employee2 > list = Arrays.asList(new Employee2(1, "Sid", 10000), new Employee2(2, "Ram", 10000), new Employee2(3, "Shayam", 10000), new Employee2(4, "Vidya", 10000));
        filterList(list, x -> (x.empName.charAt(0)+"").equals("S"));
        updateSalary(list, x -> x.empSalary +=  100);

        BiFunction<String, Integer, Employee2> biFunction = (String name, Integer salary)->{
            Employee2 emp = new Employee2(10, name,salary);
            return emp;

        };
        list = addNewEmployee(list, "Sagar", 20000, biFunction);
        System.out.println("+++++++++++++++++");
        for(Employee2 emp : list){
            System.out.println(emp);
        }
    }

    public static void filterList( List<Employee2> emp, Predicate<Employee2> predicate ){
        for(Employee2 e: emp){
            if(predicate.test(e)){
                System.out.println(e);
            }
        }
    }

    public static void updateSalary(List<Employee2> emp, Consumer<Employee2> consumer){
        for(Employee2 e : emp){
            consumer.accept(e);
            System.out.println(e);
        }
    }

    public static List<Employee2> addNewEmployee( List<Employee2> list,String name, int salary, BiFunction<String, Integer, Employee2> biFunction ){
        Employee2 e1 = biFunction.apply(name, salary);
        list.add(e1);
        return list;
    }
}
