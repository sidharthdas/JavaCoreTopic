package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.serialization;

import java.io.*;

/**
 * @author sidharthdas on 14/08/21.
 */
public class MainClass {

    public static void main ( String[] args ) throws IOException, ClassNotFoundException {

        Employee emp = new Employee("Sidharth", "cuttack");

        FileOutputStream fos = new FileOutputStream("sidd.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(emp);

        FileInputStream fis = new FileInputStream("sidd.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee emp1 = (Employee) ois.readObject();

        System.out.println(emp1.empName);
        System.out.println(emp1.empAdd);




    }
}
