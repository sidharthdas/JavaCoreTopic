package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.factorypattern;

/**
 * @author sidharthdas on 28/07/21.
 */
public class ShapeFactory {

    public static Shape getShape(String shapeName){
        if(shapeName.equals("Circle")){
            return new Circle();
        }else if(shapeName.equals("Rectangle")){
            return new Rectangle();
        }else if(shapeName.equals("Square")){
            return new Square();
        }else{
            return null;
        }
    }
}
