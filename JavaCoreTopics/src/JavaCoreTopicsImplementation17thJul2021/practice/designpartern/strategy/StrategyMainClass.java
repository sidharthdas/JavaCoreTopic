package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.strategy;

/**
 * @author sidharthdas on 28/07/21.
 */
public class StrategyMainClass {

    public static void main ( String[] args ) {

        Player terrorist = new Player("Terrorist");
        Player cs = new Player("Counter Strike");

        System.out.println("before bomb planted. . . ");
        terrorist.setMode(new DefensiveMode());
        cs.setMode(new AggressiveMode());

        terrorist.action();
        cs.action();

        System.out.println("after bomb planted. . . ");
        terrorist.setMode(new AggressiveMode());
        cs.setMode(new DefensiveMode());

        terrorist.action();
        cs.action();

    }
}
