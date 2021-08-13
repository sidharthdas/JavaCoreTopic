package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.strategy;

/**
 * @author sidharthdas on 13/08/21.
 */
public class DefensiveMode implements Mode{
    @Override
    public void mode () {
        System.out.println("DefensiveMode : Save yourself and your team!");
    }
}
