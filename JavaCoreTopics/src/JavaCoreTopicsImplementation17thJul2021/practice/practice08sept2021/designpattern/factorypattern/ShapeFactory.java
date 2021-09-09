package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.designpattern.factorypattern;

/**
 * @author sidharthdas on 09/09/21.
 */
public class ShapeFactory {

    public static Shape getShape(String shapeName){
        if(shapeName.equals("circle")){
            return new Circle();
        }else if(shapeName.equals("triangle")){
            return new Triangle();
        }else{
            return null;
        }
    }
}
