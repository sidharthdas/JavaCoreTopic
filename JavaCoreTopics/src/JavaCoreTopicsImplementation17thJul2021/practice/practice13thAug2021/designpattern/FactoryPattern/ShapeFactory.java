package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.FactoryPattern;

/**
 * @author sidharthdas on 13/08/21.
 */
public class ShapeFactory {


    public static Shape getShape ( String name ) {
        if (name.equals("Circle")) {
            return new CircleShape();
        } else if (name.equals("Rectangle")) {
            return new RectangleShape();
        } else {
            return null;
        }
    }
}
