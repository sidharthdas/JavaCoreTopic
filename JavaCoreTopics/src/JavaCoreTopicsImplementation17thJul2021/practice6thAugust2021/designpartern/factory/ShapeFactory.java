package JavaCoreTopicsImplementation17thJul2021.practice6thAugust2021.designpartern.factory;

/**
 * @author sidharthdas on 06/08/21.
 */
public class ShapeFactory {

    public static Shape getShape(String shapeName){
        if(shapeName.equals("Rectangle")){
            return new Rectangle();
        }else if(shapeName.equals("Circle")){
            return new Circle();
        }

        return null;
    }
}
