package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.practiceDesignPattern.strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class AgressiveStrategy implements IStrategy{
    @Override
    public void command () {
        System.out.println("AgressiveStrategy: Attack Attack Attack");
    }
}
