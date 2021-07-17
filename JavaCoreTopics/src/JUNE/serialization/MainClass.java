package JUNE.serialization;

import java.io.*;

/**
 * @author sidharthdas on 17/07/21.
 */

class Dog implements Serializable {
    int id = 10;
    String name = "Dog";

}

class Cat implements Serializable {
    int id = 11;
    String name = "Cat";

}

class Rat implements Serializable {
    int id = 12;
    String name = "Rat";

}

public class MainClass {


    public static void main ( String[] args ) throws IOException, ClassNotFoundException {


        Employee emp = new Employee();


        //Serialization
        FileOutputStream fos = new FileOutputStream("sid.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(emp);

        //Deserialization
        FileInputStream fis = new FileInputStream("sid.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee emp1 = (Employee) ois.readObject();
        System.out.println("id:" + emp1.id + ", empName: " + emp1.ename);


        //If we want to save all data to a file, we just need to add Serialization, result : id:10, empName: Sidharth
        //if we dont want to save a variable, we can name it as transient result : id:10, empName: null
        //Static variable cant be participate in serialization
        //Even if you do triensent to static variable, no use.
        // If we dont know what is obj is serialized
        Dog dog = new Dog();
        Cat cat = new Cat();
        Rat rat = new Rat();

        FileOutputStream fos1 = new FileOutputStream("sid1.txt");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos);
        oos1.writeObject(rat);
        oos1.writeObject(cat);
        oos1.writeObject(dog);

        int i = 3;

        FileInputStream fis1 = new FileInputStream("sid1.txt");
        ObjectInputStream ois1 = new ObjectInputStream(fis);

        Object o = ois1.readObject();

        if (o instanceof Dog) {
            Dog d = (Dog) o;
            System.out.println(d.name);
        } else if (o instanceof Cat) {
            Cat c = (Cat) o;
            System.out.println(c.name);
        } else if (o instanceof Rat) {
            Rat r = (Rat) o;
            System.out.println(r.name);
        }

    }


}

