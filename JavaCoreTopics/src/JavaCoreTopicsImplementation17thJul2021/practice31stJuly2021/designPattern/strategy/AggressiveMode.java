package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.designPattern.strategy;

/**
 * @author sidharthdas on 31/07/21.
 */
public class AggressiveMode implements Mode{

    @Override
    public void mode () {
        System.out.println("Aggressive Mode : Attack! Attack! Attack! ");
    }
}
