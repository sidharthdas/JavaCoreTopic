package JUNE.practice23rdJuly.serialization;

import java.io.Serializable;

/**
 * @author sidharthdas on 23/07/21.
 */
public class Employee implements Serializable {

    // User-defined SerialVersionUID
    private static final long SerialVersionUID = 10l;

    int empId = 100;
    transient String empName = "Sidharth";

}
