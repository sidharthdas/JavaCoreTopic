package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.designpartterntest.FactoryPattern;

import java.util.Locale;

/**
 * @author sidharthdas on 21/07/21.
 */
public class ShapeFactory {

    public static Shape getShape ( String shapeName ) {
        String query = shapeName.toLowerCase();
        if (query.equals("triangle")) {
            return new Triangle();
        } else if (query.equals("circle")) {
            return new Circle();
        } else if (query.equals("square")) {
            return new Square();
        } else {
            return null;
        }
    }
}
