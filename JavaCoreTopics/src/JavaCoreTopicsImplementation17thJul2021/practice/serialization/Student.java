package JavaCoreTopicsImplementation17thJul2021.practice.serialization;

import java.io.Serializable;

/**
 * @author sidharthdas on 28/07/21.
 */
public class Student implements Serializable {

    public static final long serialUID = 10l;

    int id = 10;
    String empName = "Sidharth";
}
