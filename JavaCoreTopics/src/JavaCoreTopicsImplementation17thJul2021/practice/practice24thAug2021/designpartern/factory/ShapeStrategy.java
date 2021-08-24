package JavaCoreTopicsImplementation17thJul2021.practice.practice24thAug2021.designpartern.factory;

/**
 * @author sidharthdas on 24/08/21.
 */
public class ShapeStrategy {


    public static Shape getShape ( String name ) {
        if (name.equals("circle")) {
            return new Circle();
        } else if (name.equals("triangle")) {
            return new Triangle();
        }

        return null;
    }
}
