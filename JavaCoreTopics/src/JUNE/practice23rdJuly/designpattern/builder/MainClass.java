package JUNE.practice23rdJuly.designpattern.builder;

/**
 * @author sidharthdas on 23/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Laptop laptop = new Laptop.LaptopBuilder(1, "254", "444").build();
        System.out.println(laptop.getHdd());
    }
}
