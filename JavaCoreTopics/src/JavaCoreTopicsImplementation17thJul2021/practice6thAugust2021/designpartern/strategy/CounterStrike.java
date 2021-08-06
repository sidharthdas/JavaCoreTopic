package JavaCoreTopicsImplementation17thJul2021.practice6thAugust2021.designpartern.strategy;

/**
 * @author sidharthdas on 06/08/21.
 */
public class CounterStrike {

    public static void main ( String[] args ) {
        System.out.println("Before bomb: ");
        Player cs = new Player("CS");
        cs.mode = new AggressiveMode();
        Player terrorist = new Player("Terrorist");
        terrorist.mode = new DefensiveMode();
        cs.action();
        terrorist.action();

        System.out.println("After bomb: ");
        cs.mode = new DefensiveMode();
        terrorist.mode = new AggressiveMode();

        cs.action();
        terrorist.action();


    }
}
