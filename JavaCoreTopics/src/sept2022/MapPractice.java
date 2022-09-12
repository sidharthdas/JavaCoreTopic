package src.sept2022;

/**
 * @author sidharthdas on 12/09/22.
 */

import java.util.*;
import java.util.stream.Collectors;

public class MapPractice {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Apple", "Cat","Cat", "Dog", "Banana", "Banana");

        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(o->o, Collectors.counting()));
        System.out.println(map);

        map = map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Comparator.comparing(Map.Entry::getKey)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));
        System.out.println(map);

        List<Employee> empList = Arrays.asList(
                new Employee("Sidharth Das", "111", new Department("IT", "CRM"),2000),
                new Employee("Ram Das", "112", new Department("BA", "CRM"),7878),
                new Employee("Raju Das", "1122", new Department("ADMIN", "GMD"),9090),
                new Employee("Sita Das", "1134", new Department("IT", "CRM"),6000),
                new Employee("Rahul Das", "1212", new Department("ADMIN", "CRM"),900),
                new Employee("Kiran Das", "1121211", new Department("IT", "GMD"),100)
        );

        Map<String, List<Employee>> mapE = empList.stream().collect(Collectors.groupingBy(x->x.dept.deptCode));
        System.out.println(mapE);

        Map<String, Long> mapD =empList.stream().collect(Collectors.groupingBy(x->x.dept.deptName, Collectors.counting()));
        System.out.println(mapD);
        Comparator<Employee> comparator = (Employee e1, Employee e2) ->{
            if(e1.empSalary > e2.empSalary){
                return 1;
            }else if(e1.empSalary < e2.empSalary){
                return -1;
            }else{
                return 0;
            }
        };
        Map<String, Employee> topEmployees =
                empList.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.dept.deptCode, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(x -> x.empSalary)),  Optional::get)));

        System.out.println(topEmployees);

        Map<String, Employee> mapEmpl = empList.stream().collect(Collectors.groupingBy(x -> x.dept.deptCode, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(x -> x.empSalary)),
                Optional::get)));

        System.out.println(mapEmpl);


    }
}

class Employee{
    String empName;
    String empCode;
    Department dept;
    int empSalary;

    public Employee(String empName, String empCode, Department dept, int empSalary) {
        this.empName = empName;
        this.empCode = empCode;
        this.dept = dept;
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empCode='" + empCode + '\'' +
                ", dept=" + dept +
                ", empSalary=" + empSalary +
                '}';
    }
}

class Department{

    String deptName;
    String deptCode;

    public Department(String deptName, String deptCode) {
        this.deptName = deptName;
        this.deptCode = deptCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                '}';
    }
}
