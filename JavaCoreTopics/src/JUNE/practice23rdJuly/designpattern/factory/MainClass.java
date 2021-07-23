package JUNE.practice23rdJuly.designpattern.factory;

/**
 * @author sidharthdas on 23/07/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Shape shape = ShapeFactory.getShape("Circle");
        shape.shapeName();
    }
}
