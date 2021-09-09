package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.designpattern.builder;

/**
 * @author sidharthdas on 09/09/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Laptop lap = new Laptop.LaptopBuilder("a","s", "s").build();
    }
}
