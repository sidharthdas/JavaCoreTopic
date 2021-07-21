package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.designpartterntest.Strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class CounterStrike {

    public static void main ( String[] args ) {
        Player terrorist = new Player("Terrorist");

        System.out.println("before bomb placed");
        terrorist.setStrategy(new DeffensiveStrategy());
        Player CS = new Player("CS");
        CS.setStrategy(new AgressiveStrategy());

        terrorist.action();
        CS.action();

        System.out.println("After bomb placed");
        terrorist.setStrategy(new AgressiveStrategy());

        CS.setStrategy(new DeffensiveStrategy());

        terrorist.action();
        CS.action();
    }
}
