package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.sortingjava8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 14/08/21.
 */
class Employee {
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

public class SortingJava8 {

    public static void main ( String[] args ) {

        List< Employee > list = Arrays.asList(new Employee(1, "Sidharth", 10000),
                new Employee(1, "Ram", 30000), new Employee(1, "Raju", 20000),
                new Employee(1, "karan", 5000), new Employee(1, "Malik", 90000),
                new Employee(1, "Narayan", 80000));


        list = list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(list);
        list = list.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(list);
        Map<String, Integer> map = new HashMap<>();
        map.put("Sidharth",100);
        map.put("Raj",1030);
        map.put("May",1020);
        map.put("Jerry",1100);
        map.put("coin",10220);
        map.put("Rocco",900);

        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));

        System.out.println(map);

        map = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));

        System.out.println(map);
    }
}
