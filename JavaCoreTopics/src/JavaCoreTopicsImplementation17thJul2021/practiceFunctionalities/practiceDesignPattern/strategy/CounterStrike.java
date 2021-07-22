package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.practiceDesignPattern.strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class CounterStrike {


    public static void main ( String[] args ) {

        System.out.println("Before Bomb");

        Player terrorist = new Player("Terrorist");
        terrorist.strategy = new DefenceStrategy();

        Player cs = new Player("Counter Terrorist");
        cs.strategy = new AgressiveStrategy();

        terrorist.action();
        cs.action();

        System.out.println("After Bomb");

        terrorist.strategy = new AgressiveStrategy();
        cs.strategy = new DefenceStrategy();

        terrorist.action();
        cs.action();

    }
}
