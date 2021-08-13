package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.Serialization;

import java.io.Serializable;

/**
 * @author sidharthdas on 21/07/21.
 */
public class Employee implements Serializable {

    // User-defined SerialVersionUID
    private static final long SerialVersionUID = 10l;

     int data = 1;
    String name = "Sidharth";
}
