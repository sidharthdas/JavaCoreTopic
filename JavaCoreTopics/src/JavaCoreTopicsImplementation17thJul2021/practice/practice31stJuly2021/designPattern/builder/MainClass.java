package JavaCoreTopicsImplementation17thJul2021.practice.practice31stJuly2021.designPattern.builder;

/**
 * @author sidharthdas on 31/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Laptop laptop = new Laptop.LaptopBuilder(100, "256", "512").build();
        System.out.println(laptop.getHdd());
    }
}
