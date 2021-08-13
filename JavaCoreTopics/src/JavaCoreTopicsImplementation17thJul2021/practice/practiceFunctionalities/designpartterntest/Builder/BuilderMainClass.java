package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.designpartterntest.Builder;

/**
 * @author sidharthdas on 21/07/21.
 */
public class BuilderMainClass {

    public static void main ( String[] args ) {

        Laptop laptop = new Laptop.LaptopBuilder(1,"256", "512","intel").build();

        System.out.println(laptop.getChip());
    }
}
