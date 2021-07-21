package JavaCoreTopicsImplementation17thJul2021.designparttern.factoryparttern;

/**
 * @author sidharthdas on 25/06/21.
 */
public class ShapeFactory {

    public Shape getImplementation( String shapeName){
        if(shapeName == null){
            throw new RuntimeException("Value is Null");
        }

        if(shapeName.equals("Triangle")){
            return new Triangle();
        }else if(shapeName.equals("Circle")){
            return new Circle();
        }else if(shapeName.equals("Rectangle")){
            return new Rectangle();
        }else{
            return null;
        }
    }
}
