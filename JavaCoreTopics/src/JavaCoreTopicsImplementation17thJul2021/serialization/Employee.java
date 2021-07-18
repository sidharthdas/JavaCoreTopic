package JavaCoreTopicsImplementation17thJul2021.serialization;

import java.io.Serializable;

/**
 * @author sidharthdas on 17/07/21.
 */
public class Employee  implements Serializable {



     int id = 10;
     transient String ename = "Sidharth";


}
