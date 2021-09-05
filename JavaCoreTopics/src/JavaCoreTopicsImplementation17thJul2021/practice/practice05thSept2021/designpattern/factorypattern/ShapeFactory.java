package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.designpattern.factorypattern;

/**
 * @author sidharthdas on 05/09/21.
 */
public class ShapeFactory {

    public static Shape getShape ( String shape ) {
        if (shape.equals("circle")) {
            return new Circle();
        } else if (shape.equals("Triangle")) {
            return new Triangle();
        } else {
            return null;
        }
    }
}
