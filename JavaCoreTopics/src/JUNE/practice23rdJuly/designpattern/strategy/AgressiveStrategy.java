package JUNE.practice23rdJuly.designpattern.strategy;

/**
 * @author sidharthdas on 23/07/21.
 */
public class AgressiveStrategy implements IStrategy{
    @Override
    public void command () {
        System.out.println("Agressive Strategy: Attack Attack Attack");
    }
}
