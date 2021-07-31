package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.designPattern.factorypattern;

/**
 * @author sidharthdas on 31/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Shape shape = ShapeFactory.getShape("Circle");

        shape.shapeName();
    }
}
