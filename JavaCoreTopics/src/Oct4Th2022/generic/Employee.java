package Oct4Th2022.generic;

/**
 * @author Sidharth Das
 * created on  07/10/22
 */
public class Employee {

    private String eName;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void employeeHey(){
        System.out.println("Hey: "+ eName);
    }
}
