package JavaCoreTopics17thJul.factoryparttern;

/**
 * @author sidharthdas on 25/06/21.
 */
public class FactoryPattenMainClass {

    public static void main ( String[] args ) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getImplementation("Circle");
        circle.area();
        Shape rectangle =shapeFactory.getImplementation("Rectangle");
        rectangle.area();
        Shape triangle = shapeFactory.getImplementation("Triangle");
        triangle.area();

    }
}
