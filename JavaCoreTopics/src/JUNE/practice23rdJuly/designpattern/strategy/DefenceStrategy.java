package JUNE.practice23rdJuly.designpattern.strategy;

/**
 * @author sidharthdas on 23/07/21.
 */
public class DefenceStrategy implements IStrategy {
    @Override
    public void command () {
        System.out.println("Defence Strategy : look for teammate and defence");
    }
}
