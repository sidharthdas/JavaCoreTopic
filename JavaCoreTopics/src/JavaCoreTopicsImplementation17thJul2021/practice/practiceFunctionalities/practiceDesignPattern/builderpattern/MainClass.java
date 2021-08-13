package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.practiceDesignPattern.builderpattern;

/**
 * @author sidharthdas on 22/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Laptop laptop = new Laptop.LaptopBuilder(1, "265", "512").build();

        System.out.println(laptop);
    }
}
