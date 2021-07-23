package JUNE.practice23rdJuly.designpattern.strategy;

/**
 * @author sidharthdas on 23/07/21.
 */
public class CounterStrike {

    public static void main ( String[] args ) {

        System.out.println("before bomb");

        Player  terrorist = new Player("Terrorist");
        Player  cs = new Player("Counter Strike");

        terrorist.strategy = new DefenceStrategy();
        cs.strategy = new AgressiveStrategy();

        terrorist.action();
        cs.action();

        System.out.println("after bomb");

        terrorist.strategy = new AgressiveStrategy();
        cs.strategy = new DefenceStrategy();

        terrorist.action();
        cs.action();





    }
}
