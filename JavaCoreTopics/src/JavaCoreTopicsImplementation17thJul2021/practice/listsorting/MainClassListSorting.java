package JavaCoreTopicsImplementation17thJul2021.practice.listsorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 28/07/21.
 */
class Employee{
    private int id;
    private String name;
    private int salary;

    public Employee ( int id, String name, int salary ) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString () {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getSalary () {
        return salary;
    }

    public void setSalary ( int salary ) {
        this.salary = salary;
    }
}
public class MainClassListSorting {

    public static void main ( String[] args ) {


        List< Employee > list = Arrays.asList(new Employee(1, "Sidharth", 10000),
                new Employee(1, "Ram", 30000),new Employee(1, "Raju", 20000),
                new Employee(1, "karan", 5000),new Employee(1, "Malik", 90000),
                new Employee(1, "Narayan", 80000));

        System.out.println("Sorted order. . .");

        list =list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("Reversed order. . . ");
        list = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(list);
    }
}
