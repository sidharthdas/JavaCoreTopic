package mapAllFunctionalities.singleton;

/**
 * @author Sidharth Das
 * created on  01/03/23
 */
public class MainClass {

    public static void main(String[] args) {

        Employee emp = Employee.getInstance();
        Employee emp1 = Employee.getInstance();

        System.out.println(emp);
        System.out.println(emp1);
    }
}
