package JavaCoreTopicsImplementation17thJul2021.designparttern.prototypeDesignPattern;

/**
 * @author sidharthdas on 31/08/21.
 */
public class PrototypeDemo {

    public static void main ( String[] args ) {

        EmployeeRecord empRecord = new EmployeeRecord(1, "Sidharth", "Software Engineer", 200000, "Odisha");
        empRecord.showRecord();

        EmployeeRecord emp1Record = (EmployeeRecord) empRecord.getClone();

        emp1Record.showRecord();

    }
}
