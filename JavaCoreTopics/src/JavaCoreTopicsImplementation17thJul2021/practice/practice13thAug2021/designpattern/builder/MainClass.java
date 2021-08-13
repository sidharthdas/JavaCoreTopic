package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.builder;

/**
 * @author sidharthdas on 14/08/21.
 */
public class MainClass {

    public static void main ( String[] args ) {
        Laptop laptop = new Laptop.LaptopBuilder(1, "Apple", "256", "444").build();
    }
}
