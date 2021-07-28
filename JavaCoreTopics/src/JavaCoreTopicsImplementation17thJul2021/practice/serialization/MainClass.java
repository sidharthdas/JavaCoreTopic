package JavaCoreTopicsImplementation17thJul2021.practice.serialization;

import JUNE.practice23rdJuly.serialization.Employee;

import java.io.*;

/**
 * @author sidharthdas on 28/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) throws IOException, ClassNotFoundException {
        Student st = new Student();

        FileOutputStream fos = new FileOutputStream("sidd.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(st);

        FileInputStream fis = new FileInputStream("sidd.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student s = (Student) ois.readObject();
    }
}
