package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.builder;

/**
 * @author sidharthdas on 28/07/21.
 */
public class BuilderMainClass {

    public static void main ( String[] args ) {

        Laptop laptop = new Laptop.LaptopBuilder("apple", "256", "512").build();
        System.out.println(laptop.getBrandName());
    }
}
