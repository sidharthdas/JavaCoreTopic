package JavaCoreTopicsImplementation17thJul2021.designparttern.prototypeDesignPattern;

/**
 * @author sidharthdas on 31/08/21.
 */
public class EmployeeRecord implements Prototype {

    private int id;
    private String name, designation;
    private double salary;
    private String address;

    public EmployeeRecord ( int id, String name, String designation, double salary, String address ) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord () {
        System.out.println(id + " " + name + " " + designation + " " + salary + " " + address);
    }

    @Override
    public Prototype getClone () {
        return new EmployeeRecord(id, name, designation, salary, address);
    }
}
