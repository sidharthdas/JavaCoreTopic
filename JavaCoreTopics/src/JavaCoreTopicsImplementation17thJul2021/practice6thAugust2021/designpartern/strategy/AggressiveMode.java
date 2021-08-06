package JavaCoreTopicsImplementation17thJul2021.practice6thAugust2021.designpartern.strategy;

/**
 * @author sidharthdas on 06/08/21.
 */
public class AggressiveMode implements Mode{
    @Override
    public void mode () {
        System.out.println("Aggressive mode: Attack Attack Attack!!!!");
    }
}
