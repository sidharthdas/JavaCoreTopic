package JavaCoreTopicsImplementation17thJul2021.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 27/07/21.
 */

class Employee {
    private int empId;
    private String empName;
    private int empSal;

    public Employee(int empId, String empName, int empSal) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpSal() {
        return empSal;
    }

    public void setEmpSal(int empSal) {
        this.empSal = empSal;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
    }
}
public class ListPractice {

    public static void main ( String[] args ) {


        List< Employee > list = Arrays.asList(new Employee(1, "Sidharth", 10000),
                new Employee(1, "Ram", 30000), new Employee(1, "Raju", 20000),
                new Employee(1, "karan", 5000), new Employee(1, "Malik", 90000),
                new Employee(1, "Narayan", 80000));


        list = list.stream().sorted(Comparator.comparing(Employee::getEmpSal)).collect(Collectors.toList());
        System.out.println(list);

        list =  list.stream().sorted(Comparator.comparingInt(Employee::getEmpSal).reversed()).collect(Collectors.toList());
        System.out.println(list);






    }
}
