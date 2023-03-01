package mapAllFunctionalities.singleton;

/**
 * @author Sidharth Das
 * created on  01/03/23
 */
public class Employee {
    private String name;
    private String add;
    private static Employee instance = null;

    private Employee() {
    }

    public static Employee getInstance() {
        if (instance == null) {

            synchronized (Employee.class) {
                if (instance == null) {
                    instance = new Employee();
                }
            }

            return instance;
        }

        return instance;
    }
}
