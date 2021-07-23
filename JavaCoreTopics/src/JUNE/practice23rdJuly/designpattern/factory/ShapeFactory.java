package JUNE.practice23rdJuly.designpattern.factory;

/**
 * @author sidharthdas on 23/07/21.
 */
public class ShapeFactory {

    public static Shape getShape (String shapeName){
        if(shapeName.equals("Circle")){
            return new Circle();
        }else  if(shapeName.equals("Square")){
            return new Square();
        }else  if(shapeName.equals("Rectangle")){
            return new Rectangle();
        }else{
            return null;
        }

    }
}
