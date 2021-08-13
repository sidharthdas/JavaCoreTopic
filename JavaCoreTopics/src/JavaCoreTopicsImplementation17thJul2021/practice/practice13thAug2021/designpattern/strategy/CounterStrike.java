package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.strategy;

import JavaCoreTopicsImplementation17thJul2021.practice.designpartern.strategy.AggressiveMode;

/**
 * @author sidharthdas on 13/08/21.
 */
public class CounterStrike {

    public static void main ( String[] args ) {

        Player cs = new Player("Counter terrorist");
        Player terrorist = new Player("terrorist");

        System.out.println("Before bomb. . . ");
        cs.mode = new AgressiveMode();
        terrorist.mode = new DefensiveMode();
        cs.action();

        terrorist.action();

        System.out.println("After bomb. . . ");
        cs.mode = new DefensiveMode();
        terrorist.mode = new AgressiveMode();
        cs.action();
        terrorist.action();


    }
}
