package JavaCoreTopicsImplementation17thJul2021.practice.practice31stJuly2021.designPattern.strategy;

/**
 * @author sidharthdas on 31/07/21.
 */
public class CounterStrikeMainClass {

    public static void main ( String[] args ) {

        Player terrorist = new Player(" Terrorist");
        Player cs = new Player(" Counter Strike");

        System.out.println("Before Bomb. . . ");
        terrorist.setMode(new DefensiveMode());
        cs.setMode(new AggressiveMode());

        terrorist.action();
        cs.action();

        System.out.println("After Bomb. . . ");
        terrorist.setMode(new AggressiveMode());
        cs.setMode(new DefensiveMode());

        terrorist.action();
        cs.action();
    }
}
