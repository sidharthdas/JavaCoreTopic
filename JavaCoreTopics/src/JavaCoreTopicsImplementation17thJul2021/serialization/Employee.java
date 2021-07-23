package JavaCoreTopicsImplementation17thJul2021.serialization;

import java.io.Serializable;

/**
 * @author sidharthdas on 17/07/21.
 */
public class Employee  implements Serializable {


     // User-defined SerialVersionUID
     private static final long SerialVersionUID = 10l;
     int id = 10;
     transient String ename = "Sidharth";


}
