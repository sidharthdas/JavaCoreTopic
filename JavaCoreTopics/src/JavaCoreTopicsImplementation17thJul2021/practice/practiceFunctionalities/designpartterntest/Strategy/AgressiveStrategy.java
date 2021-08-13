package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.designpartterntest.Strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class AgressiveStrategy implements IStrategy{
    @Override
    public void command () {
        System.out.println("Agressive Strategy : Attack Attack Attack");
    }
}
