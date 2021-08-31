package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.factory;

/**
 * @author sidharthdas on 31/08/21.
 */
public class ShapeFactory {

    public static Shape getShape ( String shapeName ) {
        if (shapeName.equals("circle")) {
            return new Circle();
        } else if (shapeName.equals("triangle")) {
            return new Triangle();
        }

        return null;
    }
}
