package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.designpartterntest.FactoryPattern;

/**
 * @author sidharthdas on 21/07/21.
 */
public class FactoryParternMainClass {
    public static void main ( String[] args ) {

        Shape shape = ShapeFactory.getShape("circle");
        shape.shapeName();

    }
}
