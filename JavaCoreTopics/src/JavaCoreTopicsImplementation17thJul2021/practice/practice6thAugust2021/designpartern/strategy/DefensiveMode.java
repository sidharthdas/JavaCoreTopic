package JavaCoreTopicsImplementation17thJul2021.practice.practice6thAugust2021.designpartern.strategy;

/**
 * @author sidharthdas on 06/08/21.
 */
public class DefensiveMode implements Mode{
    @Override
    public void mode () {
        System.out.println("Defensive mode: Save urself and your teammate.");
    }
}
