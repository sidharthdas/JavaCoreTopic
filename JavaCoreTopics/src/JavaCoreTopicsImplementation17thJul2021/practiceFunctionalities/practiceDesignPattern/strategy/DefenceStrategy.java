package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.practiceDesignPattern.strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class DefenceStrategy implements IStrategy {
    @Override
    public void command () {
        System.out.println("DefenceStrategy: defence and save your teammate");
    }
}
