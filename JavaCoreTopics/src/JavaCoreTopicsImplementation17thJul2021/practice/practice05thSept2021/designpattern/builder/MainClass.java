package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.designpattern.builder;

/**
 * @author sidharthdas on 05/09/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Laptop laptop = new Laptop.LaptopBuilder(1, "Apple", "256", "512").build();
    }
}
