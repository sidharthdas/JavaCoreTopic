package Oct4Th2022.generic;

/**
 * @author Sidharth Das
 * created on  07/10/22
 */
public class EmployeeMainClass implements Staff<Employee>{
    @Override
    public void staf(Employee employee) {
        employee.employeeHey();
    }

    public static void main(String[] args) {
        EmployeeMainClass emc = new EmployeeMainClass();
        Employee e = new Employee();
        e.seteName("Sid");
        emc.staf(e);
    }
}
