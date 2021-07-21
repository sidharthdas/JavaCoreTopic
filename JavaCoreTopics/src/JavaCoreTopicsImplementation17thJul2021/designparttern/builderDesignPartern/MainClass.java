package JavaCoreTopicsImplementation17thJul2021.designparttern.builderDesignPartern;

/**
 * @author sidharthdas on 21/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

       Laptop lap = new Laptop.LaptopBuilder("256","123", "i5").build();
    }
}
