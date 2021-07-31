package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.designPattern.factorypattern;

/**
 * @author sidharthdas on 31/07/21.
 */
public class ShapeFactory {


    public static Shape getShape ( String shapeName ) {
        if (shapeName.equals("Circle")) {
            return new Circle();
        } else if (shapeName.equals("Rectangle")) {
            return new Rectangle();
        } else if (shapeName.equals("Square")) {
            return new Square();
        } else {
            return null;
        }
    }
}
