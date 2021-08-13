package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.Serialization;

import java.io.*;

/**
 * @author sidharthdas on 21/07/21.
 */
public class SerializationMainClass {

    public static void main ( String[] args ) throws IOException, ClassNotFoundException {

        //Serialization
        FileOutputStream fos = new FileOutputStream("sid.txt");
        ObjectOutputStream oos =new  ObjectOutputStream(fos);
        oos.writeObject(new Employee());

        //Deserialization
        FileInputStream fis = new FileInputStream("sid.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee e = (Employee)ois.readObject();
        System.out.println(e.name);
    }
}
