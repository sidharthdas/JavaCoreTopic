package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.prototype;

/**
 * @author sidharthdas on 31/08/21.
 */
public class EmployeePrototype implements Prototype
{

    private String empName;

    private String empAddress;

    public EmployeePrototype ( String empName, String empAddress ) {
        this.empName = empName;
        this.empAddress = empAddress;
    }

    public String getEmpName () {
        return empName;
    }

    public String getEmpAddress () {
        return empAddress;
    }

    @Override
    public Prototype clone () {
        return  new EmployeePrototype(empName, empAddress);
    }
}
