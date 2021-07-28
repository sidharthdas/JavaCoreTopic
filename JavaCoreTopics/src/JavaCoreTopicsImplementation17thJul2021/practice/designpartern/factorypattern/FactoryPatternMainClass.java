package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.factorypattern;

/**
 * @author sidharthdas on 28/07/21.
 */
public class FactoryPatternMainClass {

    public static void main ( String[] args ) {

        Shape shape = ShapeFactory.getShape("Circle");
        shape.shape();
    }
}
