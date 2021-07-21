package JavaCoreTopicsImplementation17thJul2021.designparttern.strategydesignpattern;

import override.A;

/**
 * @author sidharthdas on 21/07/21.
 */
public class CounterStrikeMainClass {

    public static void main ( String[] args ) {
        Player terrorist = new Player("Terrorist");
        Player counterTerrorist = new Player("Counter Terrorist");

        System.out.println("Before bomb is planted");
        terrorist.setBehaviour(new AgressiveStrategy());
        counterTerrorist.setBehaviour(new DefenssiveStrategy());

        terrorist.action();
        counterTerrorist.action();

        System.out.println("Once the bomb is planted");
        terrorist.setBehaviour(new DefenssiveStrategy());
        counterTerrorist.setBehaviour(new AgressiveStrategy());

        terrorist.action();
        counterTerrorist.action();
    }
}
