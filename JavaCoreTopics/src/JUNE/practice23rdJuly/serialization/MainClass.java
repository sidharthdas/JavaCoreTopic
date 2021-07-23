package JUNE.practice23rdJuly.serialization;

import java.io.*;

/**
 * @author sidharthdas on 23/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) throws IOException, ClassNotFoundException {

        Employee emp = new Employee();

        FileOutputStream fos = new FileOutputStream("sidd.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(emp);

        FileInputStream fis = new FileInputStream("sidd.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Employee e1 = (Employee)ois.readObject();

        System.out.println(e1.empName);
        System.out.println(e1.empId);
    }
}
